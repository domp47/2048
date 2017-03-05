import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dom's Computer on 2017-03-05.
 */
public class Board extends JPanel{


    private int emptySquares = 16;                  //numbers of squares open
    private int[][] data = new int[4][4];           //Array that holds the values of the grid

    public Board() {

    }

    protected void move(KeyEvent e){                //method for when a key is pressed

    }
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    @Override
    public void paint(Graphics g){
        background(g);
        numbers(g);
    }
    public void background(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(-1,-1,800,800);

        g.setColor(Color.lightGray);
        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);
            }
        }
    }
    public void numbers(Graphics g){
        for(int y[] : data){
            for( int x: y){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
