import java.awt.*;
import java.io.IOException;
import javax.swing.*;



public class Window{


    public Window(int width, int height, String title, GraphicsConfiguration gc) throws IOException {
        JFrame frame = new JFrame(gc);
        JPanel grid = new Grid();
        grid.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.add(grid);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }
}
