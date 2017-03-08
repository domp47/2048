import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Dom's Computer on 2017-03-05.
 */
public class Game extends JFrame implements KeyListener{

    private Board b;

    public static void main(String args[]){
        new Game();
    }
    public Game(){
        super("2048");

        b = new Board();
        add(b);
        b.setPreferredSize(new Dimension(740,740));
        pack();
        //setSize(750,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width/2)-(getSize().width/2), (dim.height/2)-(getSize().height/2));
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()>=37&&e.getKeyCode()<=40){
            b.move(e);
            b.RandomNum();
            try {
                Thread.sleep(100);
            }catch (InterruptedException exception){}
            super.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
