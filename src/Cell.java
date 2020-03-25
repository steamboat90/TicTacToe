import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Cell{

    private Rectangle rect;
    private int width;
    private int height;
    private int x;
    private int y;
    private int state;

    public Cell(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(x, y, width, height);
        this.state = 0;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fill(rect);
        g2.draw(rect);
    }

    public void drawX(Graphics2D g2){
        System.out.println("x");
        g2.setColor(Color.green);
        g2.fill(rect);
        g2.draw(rect);
    }

    public void drawO(Graphics2D g2){

    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setState(int state){
        this.state = state;
    }

    public Rectangle getRect(){
        return this.rect;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getState(){
        return this.state;
    }

}
