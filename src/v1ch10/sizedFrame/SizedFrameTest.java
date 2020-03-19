package v1ch10.sizedFrame;

import static v1ch10.image.ImageTest.PACKAGE_FILE_NAME;

import java.awt.*;

import javax.swing.*;

/**
 * @author Cay Horstmann
 * @version 1.34 2015-06-16
 */
public class SizedFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                               {
                                   JFrame frame = new SizedFrame();
                                   frame.setTitle("SizedFrame");
                                   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                   frame.setVisible(true);
                               });
    }
}

class SizedFrame extends JFrame {

    public SizedFrame() {
        // get screen dimensions

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // set frame width, height and let platform pick screen location

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        // set frame icon

        // Image img = new ImageIcon("icon.gif").getImage();
        Image img = new ImageIcon(PACKAGE_FILE_NAME + "icon.gif").getImage();
        setIconImage(img);
    }
}
