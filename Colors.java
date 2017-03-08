import java.awt.*;
import java.util.HashMap;

/**
 * Created by Dom's Computer on 2017-03-05.
 */
public class Colors {

    Color n0    = Color.lightGray;
    Color n2    = new Color(238,228,218);
    Color n4    = new Color(237,224,200);
    Color n8    = new Color(242,177,121);
    Color n16   = new Color(245,149,99);
    Color n32   = new Color(246,124,95);
    Color n64   = new Color(246,94,59);
    Color n128  = new Color(237,207,114);
    Color n256  = new Color(237,204,97);
    Color n512  = new Color(237,200,80);
    Color n1024 = new Color(237,197,63);
    Color n2048 = new Color(237,194,46);

    HashMap map;

    public Colors(){

        map = new HashMap(12);

        map.put(0,n0);
        map.put(2,n2);
        map.put(4,n4);
        map.put(8,n8);
        map.put(16,n16);
        map.put(32,n32);
        map.put(64,n64);
        map.put(128,n128);
        map.put(256,n256);
        map.put(512,n512);
        map.put(1024,n1024);
        map.put(2048,n2048);
    }
    public Color getColor(int x){
        Color c = (Color) map.get(x);

        if(c==null)
            c = (Color) map.get(2048);

        return c;
    }
}
