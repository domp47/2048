import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dom's Computer on 2017-03-05.
 */
public class Board extends JPanel{

    private Colors colorChooser;
    private int emptySquares = 16;                  //numbers of squares open
    private int[][] data = new int[4][4];           //Array that holds the values of the grid

    public Board() {
        colorChooser = new Colors();
        RandomNum();
//        testBoard();
    }

    protected void move(KeyEvent e){                //method for when a key is pressed
        if(e.getKeyCode()==37){                     //left arrow pressed
            for(int x = 1; x < data.length; x++){
                for(int y = 0; y < data.length; y++){
                    if(data[y][x] != 0)
                        moveleft(x,y);
                }
            }
        }
        if(e.getKeyCode()==38){                     //left arrow pressed
            for(int x = 0; x < data.length; x++){
                for(int y = 1; y < data.length; y++){
                    if(data[y][x] != 0)
                        moveup(x,y);
                }
            }
        }
        if(e.getKeyCode()==39){                     //left arrow pressed
            for(int x = data.length-1; x >= 0; x--){
                for(int y = 0; y < data.length; y++){
                    if(data[y][x] != 0)
                        moveright(x,y);
                }
            }
        }
        if(e.getKeyCode()==40){                     //Down arrow pressed
            for(int y = data.length-1; y >= 0; y--){
                for(int x = 0; x < data.length; x++){
                    if(data[y][x] != 0)
                        movedown(x,y);
                }
            }
        }
    }
    private void moveright(int x, int y) {
        boolean inbounds = x >= 0 && x + 1 < data.length; //checks if
        inbounds = inbounds && y >= 0 && y < data.length; //x and y are in bounds

        if (inbounds && data[y][x + 1] == 0) {                //if it can go right go right
            transRight(y,x);

            data[y][x + 1] = data[y][x];
            data[y][x] = 0;

            moveright(x + 1, y);
            inbounds = false;
        }
        if (inbounds && data[y][x + 1] == data[y][x]) {     //add them togther
            transRight(y,x);

            data[y][x + 1] = data[y][x] * 2;
            data[y][x] = 0;
            emptySquares++;
        }
    }
    private void moveleft(int x, int y){
        boolean inbounds = x-1>=0 && x<data.length; //checks if
        inbounds = inbounds && y>=0 && y<data.length; //x and y are in bounds

        if(inbounds&&data[y][x-1]==0){                //if it can go left go left
            transLeft(y,x);

            data[y][x-1] = data[y][x];
            data[y][x] = 0;

            moveleft(x-1,y);
            inbounds = false;
        }
        if(inbounds&&data[y][x-1]==data[y][x]){
            transLeft(y,x);
            data[y][x-1] = data[y][x] * 2;
            data[y][x] = 0;
            emptySquares++;
        }
    }
    private void movedown(int x, int y){
        boolean inbounds = x>=0 && x<data.length; //checks if
        inbounds = inbounds && y>=0 && y+1<data.length; //x and y are in bounds

        if(inbounds&&data[y+1][x]==0){                //if it can go Down go Down
            transDown(y,x);

            data[y+1][x] = data[y][x];
            data[y][x] = 0;

            movedown(x,y+1);
            inbounds = false;
        }
        if(inbounds&&data[y+1][x]==data[y][x]){
            transDown(y,x);
            data[y+1][x] = data[y][x] * 2;
            data[y][x] = 0;
            emptySquares++;
        }
    }
    private void moveup(int x, int y){
        boolean inbounds = x>=0 && x<data.length; //checks if
        inbounds = inbounds && y-1>=0 && y<data.length; //x and y are in bounds

        if(inbounds&&data[y-1][x]==0){                //if it can go up go up
            transUp(y,x);

            data[y-1][x] = data[y][x];
            data[y][x] = 0;

            moveup(x,y-1);
            inbounds = false;
        }
        if(inbounds&&data[y-1][x]==data[y][x]){
            transUp(y,x);
            data[y-1][x] = data[y][x] * 2;
            data[y][x] = 0;
            emptySquares++;
        }
    }
    private void transUp(int y, int x){
        Graphics g = this.getGraphics();

        Color c = colorChooser.getColor(data[y][x]);

        g.setColor(Color.lightGray);
        g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);

        for(int height = (175*y)+(10*(y+1)); height > (175*y)+(10*(y+1))-175; height--) {
            g.setColor(c);
            g.fillRect((175*x)+(10*(x+1)),height,175,175);


            if(height%5==0)
                try{ Thread.sleep(1); }catch (InterruptedException excpetion){}

            g.setColor(Color.lightGray);
            g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);
            g.setColor(Color.gray);
            g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1))-10,175,10);
        }
    }
    private void transDown(int y, int x){
        Graphics g = this.getGraphics();

        Color c = colorChooser.getColor(data[y][x]);

        g.setColor(Color.lightGray);
        g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);

        for(int height = (175*y)+(10*(y+1)); height < (175*y)+(10*(y+1))+175; height++) {
            g.setColor(c);
            g.fillRect((175*x)+(10*(x+1)),height,175,175);


            if(height%10==0)
                try{ Thread.sleep(1); }catch (InterruptedException excpetion){}

            g.setColor(Color.lightGray);
            g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);
            g.setColor(Color.gray);
            g.fillRect((175*x)+(10*(x+1)),(175*y+1)+(10*(y+1))-10,175,10);
        }
    }
    private void transLeft(int y, int x){
        Graphics g = this.getGraphics();

        Color c = colorChooser.getColor(data[y][x]);

        g.setColor(Color.lightGray);
        g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);

        for(int width = (175*x)+(10*(x+1)); width > (175*x)+(10*(x+1))-175; width--) {
            g.setColor(c);
            g.fillRect(width,(175*y)+(10*(y+1)),175,175);


            if(width%5==0)
                try{ Thread.sleep(1); }catch (InterruptedException excpetion){}

            g.setColor(Color.lightGray);
            g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);
            g.setColor(Color.gray);
            g.fillRect((175*x)+(10*(x+1))-10,(175*y)+(10*(y+1)),10,175);
        }
    }
    private void transRight(int y, int x){
        Graphics g = this.getGraphics();

        Color c = colorChooser.getColor(data[y][x]);

        g.setColor(Color.lightGray);
        g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);

        for(int width = (175*x)+(10*(x+1)); width < (175*x)+(10*(x+1))+175; width++) {
            g.setColor(c);
            g.fillRect(width,(175*y)+(10*(y+1)),175,175);


            if(width%5==0)
                try{ Thread.sleep(1); }catch (InterruptedException excpetion){}

            g.setColor(Color.lightGray);
            g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);
            g.setColor(Color.gray);
            g.fillRect((175*x)+(10*(x+1))-10,(175*y)+(10*(y+1)),10,175);
        }
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
        g.fillRect(0,0,750,750);

        g.setColor(Color.lightGray);
        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);
            }
        }
    }
    public void numbers(Graphics g){
        Color c;
        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                if(data[y][x]!=0){
                    c = colorChooser.getColor(data[y][x]);  //get the color for the number value
                    g.setColor(c);                          //set the color value
                    g.fillRect((175*x)+(10*(x+1)),(175*y)+(10*(y+1)),175,175);

                    if(data[y][x]==2||data[y][x]==4)
                        g.setColor(Color.black);
                    else
                        g.setColor(Color.white);

                    g.setFont(new Font("TimesRoman", Font.BOLD,55));
                    if(data[y][x]<9)
                        g.drawString(Integer.toString(data[y][x]),(175*x)+(10*(x+1))+70,(175*y)+(10*(y+1))+110);
                    else if(data[y][x]>9&&data[y][x]<99)
                        g.drawString(Integer.toString(data[y][x]),(175*x)+(10*(x+1))+55,(175*y)+(10*(y+1))+110);
                    else if(data[y][x]>100&&data[y][x]<999)
                        g.drawString(Integer.toString(data[y][x]),(175*x)+(10*(x+1))+40,(175*y)+(10*(y+1))+110);
                    else if(data[y][x]>1000&&data[y][x]<9999)
                        g.drawString(Integer.toString(data[y][x]),(175*x)+(10*(x+1))+25,(175*y)+(10*(y+1))+110);
                    else if(data[y][x]>10000)
                        g.drawString(Integer.toString(data[y][x]),(175*x)+(10*(x+1))+10,(175*y)+(10*(y+1))+110);
                }
            }

        }

    }
    public void seeData(){
        for(int y = 0; y<data.length;y++){
            for(int x = 0; x<data.length;x++){
                System.out.print(data[y][x]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    protected void RandomNum(){   //puts random number on board
        if(emptySquares>0){


            boolean success = false;        //boolean for checking if number is put in data

            while(!success){                //while an empty spot isn't chosen
                int x = (int) (Math.random()*4);    //random y value on grid
                int y = (int) (Math.random()*4);    //random x value on grid

//                int x = 2;
//                int y = 0;
                if(data[y][x]!=0)           //if the spot isnt empty
                    continue;               //find new spot
                success = true;
                emptySquares--;

                boolean number = Math.random() < 0.7;   //chose either 2 or 4 to be added

                if(number)
                    data[y][x] = 2;
                else
                    data[y][x] = 4;
            }
        }
    }
    public void testBoard(){
        int val = 2;
        for(int y = 0; y<data.length;y++) {
            for (int x = 0; x < data.length; x++) {
                data[y][x] = val;
                val*=2;
            }
        }
        emptySquares = 0;
    }
}
