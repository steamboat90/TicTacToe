import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Grid extends JPanel{

    private Cell[][] cells = new Cell[3][3];
    private int player;
    private int winner = 0;

    private int winLineStartX = -1;
    private int winLineStartY = -1;
    private int winLineFinishX = -1;
    private int winLineFinishY = -1;

    public Grid() throws IOException {
        super();
        this.setBackground(Color.BLACK);
        this.addMouseListener(listener);
        this.addKeyListener(keyListener);

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

        this.player = 1;

    }

    public void restart(){
        for(Cell[] cellArray : cells){
            for(Cell cell : cellArray){
                cell.setState(0);
            }
        }
        repaint();
    }

    //Finds the winner of the game. If it returns 0, there is no winner; if it returns 1, "X" is the winner;
    //  if it returns 2, "O" is the winner.
    public int findWinner(){
        //first row
        if(cells[0][0].getState() != 0 && cells[0][0].getState() == cells[1][0].getState() && cells[0][0].getState() == cells[2][0].getState()){
            winner = cells[0][0].getState();
            cells[0][0].setWinningCell();
            cells[1][0].setWinningCell();
            cells[2][0].setWinningCell();
        }

        //second row
        else if(cells[0][1].getState() != 0 && cells[0][1].getState() == cells[1][1].getState() && cells[0][1].getState() == cells[2][1].getState()){
            winner = cells[0][1].getState();
            cells[0][1].setWinningCell();
            cells[1][1].setWinningCell();
            cells[2][1].setWinningCell();
        }

        //third row
        else if(cells[0][2].getState() != 0 && cells[0][2].getState() == cells[1][2].getState() && cells[0][2].getState() == cells[2][2].getState()){
            winner = cells[0][2].getState();
            cells[0][2].setWinningCell();
            cells[1][2].setWinningCell();
            cells[2][2].setWinningCell();
        }

        //first column
        else if(cells[0][0].getState() != 0 && cells[0][0].getState() == cells[0][1].getState() && cells[0][0].getState() == cells[0][2].getState()){
            winner = cells[0][0].getState();
            cells[0][0].setWinningCell();
            cells[0][1].setWinningCell();
            cells[0][2].setWinningCell();
        }

        //second column
        else if(cells[1][0].getState() != 0 && cells[1][0].getState() == cells[1][1].getState() && cells[1][0].getState() == cells[1][2].getState()){
            winner = cells[1][0].getState();
            cells[1][0].setWinningCell();
            cells[1][1].setWinningCell();
            cells[1][2].setWinningCell();
        }

        //third column
        else if(cells[2][0].getState() != 0 && cells[2][0].getState() == cells[2][1].getState() && cells[2][0].getState() == cells[2][2].getState()){
            winner = cells[2][0].getState();
            cells[2][0].setWinningCell();
            cells[2][1].setWinningCell();
            cells[2][2].setWinningCell();
        }

        //diagonal top left to bottom right
        else if(cells[0][0].getState() != 0 && cells[0][0].getState() == cells[1][1].getState() && cells[0][0].getState() == cells[2][2].getState()){
            winner = cells[0][0].getState();
            cells[0][0].setWinningCell();
            cells[1][1].setWinningCell();
            cells[2][2].setWinningCell();
        }

        //diagonal top right to bottom left
        else if(cells[2][0].getState() != 0 && cells[2][0].getState() == cells[1][1].getState() && cells[2][0].getState() == cells[0][2].getState()){
            winner = cells[2][0].getState();
            cells[2][0].setWinningCell();
            cells[1][1].setWinningCell();
            cells[0][2].setWinningCell();
        }

        return winner;
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(Cell[] cellArray : cells){
            for(Cell cell : cellArray){
                if(cell.getState() == 0  && !cell.isChosen()){
                    cell.draw(g2);
                }
                else if(cell.getState() == 1){
                    cell.drawX(g2);
                }else if(cell.getState() == 2) {
                    cell.drawO(g2);
                }
            }
        }
        //Find and display the winner
        winner = findWinner();
        if(winner != 0){
            System.out.println(winner);
            for(Cell[] cellArray : cells) {
                for (Cell cell : cellArray) {
                    if (cell.isWinningCell()) {
                        cell.setColor(Color.green);
                        if (cell.getState() == 1) {
                            cell.drawX(g2);
                        }
                        if (cell.getState() == 2) {
                            cell.drawO(g2);
                        }
                    }
                }
            }
        }
    }



    public MouseListener listener = new MouseInputAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Point point = e.getPoint();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    Cell cell = cells[i][j];
                    if(cell.getRect().contains(point) && !cell.isChosen()){
                        cell.setState(player);
                        if(player == 1){
                            player++;
                        } else{
                            player--;
                        }
                        repaint();
                    }
                    //repaint();
                }
            }

        }
    };

    public KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyPressed(e);
            System.out.println("pressed");
        }
    };


}
