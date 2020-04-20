package game.view.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class contains constants that are used as reference paths to resources
 * in the application.
 */
public class StyleConstants {

    public static final String CELL_CSS_CLASS_2 = "cell2";

    public static final String CELL_CSS_CLASS_4 = "cell4";

    public static final String CELL_CSS_CLASS_8 = "cell8";

    public static final String CELL_CSS_CLASS_16 = "cell16";

    public static final String CELL_CSS_CLASS_32 = "cell32";

    public static final String CELL_CSS_CLASS_64 = "cell64";

    public static final String CELL_CSS_CLASS_128 = "cell128";

    public static final String CELL_CSS_CLASS_256 = "cell256";

    public static final String CELL_CSS_CLASS_512 = "cell512";

    public static final String CELL_CSS_CLASS_1024 = "cell1024";

    public static final String CELL_CSS_CLASS_2048 = "cell2048";

    public static final String CELL_CSS_CLASS_4096_PLUS = "cell4096";

    public static final String CELL_CSS_CLASS_5_DIGIT = "cell5Digit";

    public static List<String> getCellStyles() {
        return Collections.unmodifiableList(CELL_STYLES);
    }

    private static final List<String> CELL_STYLES = Arrays.asList(CELL_CSS_CLASS_2, CELL_CSS_CLASS_4, CELL_CSS_CLASS_8,
            CELL_CSS_CLASS_16, CELL_CSS_CLASS_32, CELL_CSS_CLASS_64, CELL_CSS_CLASS_128,
            CELL_CSS_CLASS_256, CELL_CSS_CLASS_512, CELL_CSS_CLASS_1024, CELL_CSS_CLASS_2048,
            CELL_CSS_CLASS_4096_PLUS, CELL_CSS_CLASS_5_DIGIT);

    private StyleConstants() {
        // Private constructor to prevent instantiation.
    }
}
