import java.awt.*;
import java.util.HashMap;

/**
 * Created by Dom's Computer on 2017-03-05.
 */
public class Test{


    public Test(){
        for(int i = 0; i<50; i++){
            System.out.println((int)(Math.random()*4));
        }
    }
    public static void main(String[] args) {
        new Test();
    }
}
