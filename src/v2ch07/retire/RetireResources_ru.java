package v2ch07.retire;

import java.awt.*;

/**
 * These are the Russion non-string resources for the retirement calculator.
 * @author ildar66
 */
public class RetireResources_ru extends java.util.ListResourceBundle {

    private static final Object[][] contents = {
            // BEGIN LOCALIZE
            {"colorPre", Color.green}, {"colorGain", Color.black}, {"colorLoss", Color.red}
            // END LOCALIZE
    };

    public Object[][] getContents() {
        return contents;
    }
}
