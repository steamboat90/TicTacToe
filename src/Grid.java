import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Grid extends JPanel {

    Cell[][] cells = new Cell[3][3];

    public Grid(){
        super();
        this.setBackground(Color.BLACK);
        this.addMouseListener(listener);
    }

    public void draw(Graphics2D g2){
        int iCounter = 0;
        int jCounter = 0;
        for(int i = 0; i < 940; i += 320){
           for(int j = 0; j < 940; j += 320){
               Cell c = new Cell(i, j, 300, 300);
               cells[iCounter][jCounter] = c;
               if(c.getState() == 0){
                   c.draw(g2);
               }
               else if(c.getState() == 1){
                   c.drawX(g2);
               }else{
                   c.drawO(g2);
               }
               jCounter++;
           }
           jCounter = 0;
           iCounter++;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        this.draw(g2);
    }


    public MouseListener listener = new MouseInputAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Point point = e.getPoint();
            for(Cell[] cellArray : cells){
                for(Cell cell : cellArray){
                    if(cell.getRect().contains(point)){
                        System.out.println(cell.getX()/320 + "," + cell.getY()/320);
                        cell.setState(1);
                        repaint();
                    }
                }
            }
        }
    };


}
