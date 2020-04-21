package v2ch11.imageTransfer;

import java.awt.*;

import javax.swing.*;

/**
 * This program demonstrates the transfer of images between a Java application and the system clipboard.
 *
 * @author Cay Horstmann
 * @version 1.23 2016-05-10
 */
public class ImageTransferTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                               {
                                   JFrame frame = new ImageTransferFrame();
                                   frame.setTitle("ImageTransferTest");
                                   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                   frame.setVisible(true);
                               });
    }
}

