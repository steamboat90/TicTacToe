import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {

    private static GraphicsConfiguration gc;

    public static void main(String[] args) throws IOException {
        Window window = new Window(940, 940, "TicTacToe", gc);
    }

}
