package v1ch10.simpleFrame;

import java.awt.*;

import javax.swing.*;

/**
 * @author Cay Horstmann
 * @version 1.33 2015-05-12
 */
public class SimpleFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(
                () -> {
                    SimpleFrame frame = new SimpleFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setUndecorated(true);
                    frame.setVisible(true);
                }
        );
    }
}

class SimpleFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
