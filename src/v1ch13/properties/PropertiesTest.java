package v1ch13.properties;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;

import javax.swing.*;

/**
 * A program to test properties. The program remembers the frame position, size,
 * and title.
 * @author Cay Horstmann
 * @version 1.01 2015-06-16
 */
public class PropertiesTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PropertiesFrame frame = new PropertiesFrame();
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that restores position and size from a properties file and updates
 * the properties upon exit.
 */
class PropertiesFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private File propertiesFile;
    private Properties settings;

    PropertiesFrame() {
        // get position, size, title from properties

        propertiesFile = getPropertiesFile();

        settings = new Properties(getDefaultSettins());

        loadSettingsIfPropertiesFileExist();

        setBounds(asInt("left"), asInt("top"), asInt("width"), asInt("height"));

        getTitleFromUser();

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent event) {
                storeSettings();
            }
        });
    }

    private void storeSettings() {
        settings.setProperty("left", "" + getX());
        settings.setProperty("top", "" + getY());
        settings.setProperty("width", "" + getWidth());
        settings.setProperty("height", "" + getHeight());
        settings.setProperty("title", getTitle());
        try (OutputStream out = new FileOutputStream(propertiesFile)) {
            settings.store(out, "Program Properties");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    private void getTitleFromUser() {
        String title = settings.getProperty("title");
        if (title.equals(""))
            title = JOptionPane.showInputDialog("Please supply a frame title:");
        if (title == null) title = "";
        setTitle(title);
    }

    private int asInt(String name) {
        return Integer.parseInt(settings.getProperty(name));
    }

    private void loadSettingsIfPropertiesFileExist() {
        if (propertiesFile.exists()) {
            try (InputStream in = new FileInputStream(propertiesFile)) {
                settings.load(in);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private Properties getDefaultSettins() {
        Properties defaultSettings = new Properties();
        defaultSettings.setProperty("left", "0");
        defaultSettings.setProperty("top", "0");
        defaultSettings.setProperty("width", "" + DEFAULT_WIDTH);
        defaultSettings.setProperty("height", "" + DEFAULT_HEIGHT);
        defaultSettings.setProperty("title", "");
        return defaultSettings;
    }

    private File getPropertiesFile() {
        String userDir = System.getProperty("user.home");
        File propertiesDir = new File(userDir, ".corejava");
        if (!propertiesDir.exists()) propertiesDir.mkdir();
        return new File(propertiesDir, "program.properties");
    }
}