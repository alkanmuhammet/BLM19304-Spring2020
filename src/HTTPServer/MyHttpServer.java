package HTTPServer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @file MyHttpServer.java
 * @date Mar 2, 2020 , 13:25:26
 * @author Zeki Kuş
 */
public class MyHttpServer {

    private static HttpServer ServerSocket;

    public static void Start() throws IOException {
        ServerSocket = HttpServer.create(new InetSocketAddress(8900), 0);
        ServerSocket.createContext("/info", new InfoHandler());
        ServerSocket.createContext("/pdf", new GetHandler());
        ServerSocket.createContext("/index", new GetPageHandler("index.html"));
        ServerSocket.createContext("/index_post", new GetPageHandler("post_example.html"));
        ServerSocket.createContext("/get", new GetParamHandler());
        ServerSocket.createContext("/post", new GetPostHandler());
        ServerSocket.setExecutor(null);
        ServerSocket.start();

    }

    // http://localhost:8900/info
    static class InfoHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange handleResponse) throws IOException {
            String ResponseText = "Fatih Sultan Mehmet Vakif University";
            handleResponse.sendResponseHeaders(200, ResponseText.length()); // headeri ayarlıyoruz
            OutputStream os = handleResponse.getResponseBody(); // body referansını alıyoruz
            os.write(ResponseText.getBytes()); // cevabı yazdırıyoruz.
            os.close();
        }
    }

    // http://localhost:8900/pdf
    static class GetHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange handleResponse) throws IOException {

            // pdf göndereceğiz
            Headers h = handleResponse.getResponseHeaders();
            h.add("Content-Type", "application/pdf"); // dosya tipini belirtiyoruz

            File file = new File("src/HTTPServer/files/http_server.pdf"); // pdf yolu dosyayı alıyoruz
            byte[] bytearray = new byte[(int) file.length()]; // bir buffer tanımlıyoruz
            FileInputStream fis = new FileInputStream(file); // dosyayı byte arraya çevireceğiz
            fis.read(bytearray, 0, bytearray.length);// dosyayı byte arraya çevirdik.

            // cevap için hazırız
            handleResponse.sendResponseHeaders(200, file.length());// cevap için header ayarlaması
            OutputStream os = handleResponse.getResponseBody();// body referansını alıyoruz
            os.write(bytearray, 0, bytearray.length); // dosya data kısmına byte dizisi olarak eklendi ve gönderildi
            os.close();
        }
    }

    // http://localhost:8900/index
    // http://localhost:8900/index_post
    static class GetPageHandler implements HttpHandler {

        String htmlFile = "";

        public GetPageHandler(String htmlFile) {
            this.htmlFile = htmlFile;
        }

        @Override
        public void handle(HttpExchange handleResponse) throws IOException {

            // text dosya göndereceğiz
            Headers h = handleResponse.getResponseHeaders(); // göndereceğimiz dosya tipini seçiyoruz
            h.add("Content-Type", "text/html"); // header ayarlaması yapıyoruz

            File file = new File("src/HTTPServer/files/" + this.htmlFile); // dosyayı alıyoruz
            byte[] bytearray = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(bytearray, 0, bytearray.length); // dosyayı byte arraya çevirdik

            // cevap için hazırız
            handleResponse.sendResponseHeaders(200, file.length()); // cevap için header ayarlaması
            OutputStream os = handleResponse.getResponseBody(); // body referansını alıyoruz
            os.write(bytearray, 0, bytearray.length); // dosya response body kısmına bytedizisi olarak eklendi ve gönderildi
            os.close();
        }
    }

    // http://localhost:8900/get?fname=Zeki&lname=Kus&email=zkus%40fsm.edu.tr&gender=male
    static class GetParamHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange handleResponse) throws IOException {
            StringBuilder response = new StringBuilder();
            Map<String, String> parms = MyHttpServer.queryToMap(handleResponse.getRequestURI().getQuery());

            response.append("<html><body>");
            response.append("Your name : " + parms.get("fname") + "<br/>");
            response.append("Your Surname : " + parms.get("lname") + "<br/>");
            response.append("Your Email : " + parms.get("email") + "<br/>");
            response.append("Your Gender : " + parms.get("gender") + "<br/>");
            response.append("</body></html>");

            handleResponse.sendResponseHeaders(200, response.length());
            OutputStream os = handleResponse.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();

        }
    }

    static class GetPostHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange handleResponse) throws IOException {
            // parse request
            InputStreamReader isr = new InputStreamReader(handleResponse.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String query = br.readLine();

            Map<String, String> params = MyHttpServer.queryToMap(query);

            // send response
            String response = "";
            for (String key : params.keySet()) {
                response += key + " = " + params.get(key) + "\n";
            }

            handleResponse.sendResponseHeaders(200, response.length());
            OutputStream os = handleResponse.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // Query Parser
    public static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        MyHttpServer.Start();
    }

}
