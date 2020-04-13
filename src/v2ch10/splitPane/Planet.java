package v2ch10.splitPane;

import javax.swing.*;

/**
 * Describes a planet(a little more immutable and thread-safe :).
 */
public class Planet {

    private static final String IMAGE_DIR = "img" + System.getProperty("file.separator");

    private final String name;
    private final double radius;
    private final int moons;
    // private final ImageIcon image;
    // private final URL imageURL;

    /**
     * Constructs a planet.
     * @param n the planet name
     * @param r the planet radius
     * @param m the number of moons
     */
    public Planet(String n, double r, int m) {
        name = n;
        radius = r;
        moons = m;
        // image = new ImageIcon(getClass().getResource(IMAGE_DIR + name + ".gif"));
        // imageURL = getClass().getResource(IMAGE_DIR + name + ".gif");
    }

    public String toString() {
        return name;
    }

    /**
     * Gets a description of the planet.
     * @return the description
     */
    public String getDescription() {
        return "Radius: " + radius + "\nMoons: " + moons + "\n";
    }

    /**
     * Gets an image of the planet.
     * @return the image
     */
    public ImageIcon getImage() {
        // return image;
        //return new ImageIcon(imageURL);
        return new ImageIcon(getClass().getResource(IMAGE_DIR + name + ".gif"));
    }
}
