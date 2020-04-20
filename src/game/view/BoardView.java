package game.view;

import game.controller.ApplicationStateContext;
import game.model.BoardModel;
import game.state.action.ArrowKeyPressedState;
import game.state.model.NewGameState;
import game.state.model.RedoActionState;
import game.state.model.UndoActionState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * This class corresponds to the 4 x 3 button grid on the top left of the
 * screen. It contains numeric buttons 1 - 9 , which highlight cells where those
 * digits could go. It also contains X|Y, which highlights bivalue cells.
 * Lastly, this class creates buttons labeled "<" and ">", which are undo and
 * redo, respectively.
 */
public class BoardView extends GridPane {

    private static final String CSS_CLASS = "board-view";

    private static final double PADDING_FOR_PANE = 15;

    private static final double DEFAULT_WIDTH = 550;

    private static final int CELL_SIZE = 100;

    private static final String EMPTY_CELL_STYLE = "board-view-cell";

    private final Label[][] cells;

    public BoardView() {
        this.cells = new Label[BoardModel.DEFAULT_SIZE][BoardModel.DEFAULT_SIZE];
        this.configure();
    }

    public Label getCell(final int row, final int col) {
        return this.cells[col][row];
    }

    private void configure() {
        this.getStyleClass().add(CSS_CLASS);
        this.setPadding(new Insets(PADDING_FOR_PANE));
        this.setHgap(40);
        this.setVgap(40);
        this.setMinWidth(DEFAULT_WIDTH);
        this.setMaxWidth(DEFAULT_WIDTH);
        this.setOnKeyPressed(BoardView.onKeyPressed());
        this.createChildElements();
    }

    private static EventHandler<? super KeyEvent> onKeyPressed() {
        return event -> {
            final KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.N && event.isControlDown()) {
                ApplicationStateContext.getInstance().changeState(new NewGameState());
            } else if (keyCode == KeyCode.Z && event.isControlDown()) {
                ApplicationStateContext.getInstance().changeState(new UndoActionState());
            } else if (keyCode == KeyCode.Y && event.isControlDown()) {
                ApplicationStateContext.getInstance().changeState(new RedoActionState());
            } else if (keyCode.isArrowKey() || keyCode.isLetterKey()) {
                ApplicationStateContext.getInstance().changeState(new ArrowKeyPressedState(keyCode));
            }
        };
    }

    private void createChildElements() {
        for (int row = 0; row < BoardModel.DEFAULT_SIZE; row++) {
            for (int col = 0; col < BoardModel.DEFAULT_SIZE; col++) {
                this.cells[col][row] = new Label();
                this.cells[col][row].setMinHeight(CELL_SIZE);
                this.cells[col][row].setMinWidth(CELL_SIZE);
                this.cells[col][row].getStyleClass().add(EMPTY_CELL_STYLE);
                this.cells[col][row].setAlignment(Pos.CENTER);
                this.add(this.cells[col][row], col, row);
            }
        }
    }

}
