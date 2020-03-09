package UDP_SwingUI;

import java.io.Serializable;

/**
 * @file Mesaj.java
 * @date Feb 21, 2020 , 16:13:31
 * @author Muhammet Alkan
 */
public class Mesaj implements Serializable {

    String text;

    @Override
    public String toString() {
        return "Mesaj nesnesi : " + text;
    }

}
