package game.view;

import game.factory.LayoutFactory;
import javafx.scene.layout.GridPane;

/**
 * This class corresponds to the 4 x 3 button grid on the top left of the
 * screen. It contains numeric buttons 1 - 9 , which highlight cells where those
 * digits could go. It also contains X|Y, which highlights bivalue cells.
 * Lastly, this class creates buttons labeled "<" and ">", which are undo and
 * redo, respectively.
 */
public class BoardViewWrapper extends GridPane {

    private static final String CSS_CLASS = "board-view-wrapper";

    private static final double SIZE = 575;

    public BoardViewWrapper() {
        this.configure();
    }

    private void configure() {
        this.getStyleClass().add(CSS_CLASS);
        this.setMinWidth(SIZE);
        this.setMaxWidth(SIZE);
        this.setMaxHeight(SIZE);
        this.setMinHeight(SIZE);
        this.createChildElements();
    }

    private void createChildElements() {
        this.add(LayoutFactory.getInstance().createBoardView(), 0, 0);
    }

}
