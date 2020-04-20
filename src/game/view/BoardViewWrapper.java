package game.view;

import game.factory.LayoutFactory;
import game.model.BoardModel;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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

    private static final double PADDING_FOR_PANE = 15;

    private static final double DEFAULT_WIDTH = 575;

    public BoardViewWrapper() {
        this.configure();
    }

    private void configure() {
        this.getStyleClass().add(CSS_CLASS);
        this.setPadding(new Insets(PADDING_FOR_PANE));
        this.setMinWidth(DEFAULT_WIDTH);
        this.setMaxWidth(DEFAULT_WIDTH);
        this.createChildElements();
    }

    private void createChildElements() {
        this.add(LayoutFactory.getInstance().createBoardView(), 0, 0);
    }

}
