import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cell{

    private Rectangle rect;
    private int width;
    private int height;
    private int x;
    private int y;
    private int state;
    private boolean chosen;
    private boolean winningCell;
    private BufferedImage xImg;
    private BufferedImage oImg;
    private BufferedImage xImgGreen;
    private BufferedImage oImgGreen;
    private Color color;


    public Cell(int x, int y, int width, int height) throws IOException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(x, y, width, height);
        this.state = 0;
        this.chosen = false;
        this.winningCell = false;
        this.color = Color.white;

        xImg = ImageIO.read(new File("resources/X.png"));
        oImg = ImageIO.read(new File("resources/O.png"));
        xImgGreen = ImageIO.read(new File("resources/GreenX.png"));
        oImgGreen = ImageIO.read(new File("resources/GreenO.png"));
    }


    public void draw(Graphics2D g2){
        g2.setColor(this.color);
        g2.fill(rect);
        g2.draw(rect);
    }

    public void drawX(Graphics2D g2){
        draw(g2);
        if(winningCell)
            g2.drawImage(this.xImgGreen, x + 45, y + 45, null);
        else
            g2.drawImage(this.xImg, x + 45, y + 45, null);
        this.chosen = true;
    }

    public void drawO(Graphics2D g2){
        draw(g2);
        if(winningCell)
            g2.drawImage(this.oImgGreen, x + 45, y + 45, null);
        else
            g2.drawImage(this.oImg, x + 45, y + 45, null);
        this.chosen = true;
    }

    public void setState(int state){
        this.state = state;
    }

    public void setWinningCell(){
        this.winningCell = true;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Rectangle getRect(){
        return this.rect;
    }

    public int getState(){
        return this.state;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isChosen(){
        return this.chosen;
    }

    public boolean isWinningCell(){
        return this.winningCell;
    }

}
