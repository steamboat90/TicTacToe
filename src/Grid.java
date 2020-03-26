import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Grid extends JPanel{

    private Cell[][] cells = new Cell[3][3];
    private int player;

    public Grid(){
        super();
        this.setBackground(Color.BLACK);
        this.addMouseListener(listener);

        int iCounter = 0;
        int jCounter = 0;

        for(int i = 0; i < 940; i += 320){
            for(int j = 0; j < 940; j += 320){
                Cell c = new Cell(i, j, 300, 300);
                cells[iCounter][jCounter] = c;
                jCounter++;
            }
            jCounter = 0;
            iCounter++;
        }

        this.player = 2;

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(Cell[] cellArray : cells){
            for(Cell cell : cellArray){
                if(cell.getState() == 0){
                    cell.draw(g2);
                }
                else if(cell.getState() == 1 && !cell.isChosen()){
                    cell.drawX(g2);
                }else if(cell.getState() == 2 && !cell.isChosen()){
                    cell.drawO(g2);
                }
            }
        }
    }



    public MouseListener listener = new MouseInputAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Point point = e.getPoint();
            for(Cell[] cellArray : cells){
                for(Cell cell : cellArray){
                    if(cell.getRect().contains(point)){
                        System.out.println("click");
                        if(!cell.isChosen()){
                            if(player == 1){
                                player++;
                            } else{
                                player--;
                            }
                        }
                        cell.setState(player);
                        repaint();
                    }
                }
            }

        }
    };


}
