package game.state;

import game.controller.ApplicationStateContext;
import game.model.BoardHistory;
import game.model.BoardModel;
import game.view.BoardView;
import game.view.InfoPane;
import game.view.util.StyleConstants;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import org.apache.logging.log4j.util.Strings;

/**
 * A generic class for when the game changes state (i.e. anything occurs through the AI or player interaction).
 */
public abstract class GameState {

    protected final ApplicationStateContext context;

    protected GameState() {
        this.context = ApplicationStateContext.getInstance();
        this.context.getBoardView().requestFocus();
    }

    public abstract void onEnter();

    protected void resetBoard() {
        this.context.getBoard().reset(BoardModel.DEFAULT_SIZE);
    }

    protected void clearHighlightedCells() {
        final int boardSize = this.context.getBoard().getSize();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                for (final String styleClass : StyleConstants.getCellStyles()) {
                    this.updateCellStyle(row, col, styleClass, false);
                }
            }
        }
    }

    protected void updateCellStyle(final int row, final int col, final String cssClass, final boolean add) {
        final BoardView chessBoardView = this.context.getBoardView();
        final Label cell = chessBoardView.getCell(row, col);
        final ObservableList<String> styleClass = cell.getStyleClass();
        if (add && !styleClass.contains(cssClass)) {
            styleClass.add(cssClass);
        } else {
            styleClass.remove(cssClass);
        }
    }

    protected void setCellViewValue(final int row, final int col, final int value) {
        final BoardView chessBoardView = this.context.getBoardView();
        final Label cell = chessBoardView.getCell(row, col);
        if (value == 0) {
            cell.setText(Strings.EMPTY);
        } else {
            cell.setText(String.valueOf(value));
        }

        final String newCellValue = cell.getText();

        if (!newCellValue.isEmpty()) {
            cell.getStyleClass().add("cell" + newCellValue);
        }
    }

    protected void setCellModelValue(final int row, final int col, final int value) {
        this.context.getBoard().setCell(row, col, value);
    }

    protected void updateUndoRedoButtons() {
        final BoardHistory history = this.context.getHistory();
        final InfoPane infoPane = this.context.getInfoPane();
        infoPane.getRedoButton().setDisable(history.isRedoStackEmpty());
        infoPane.getUndoButton().setDisable(history.isUndoStackEmpty());
    }

    protected void resetAppToMatchBoard() {
        final BoardModel board = this.context.getBoard();
        final int boardSize = board.getSize();
        this.clearHighlightedCells();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                final int valueForCell = board.getCell(row, col);
                this.setCellViewValue(row, col, valueForCell);
            }
        }
    }

    protected void addBoardToUndoStack(final BoardModel board) {
        final BoardHistory history = this.context.getHistory();
        history.addToUndoStack(board);
        history.clearRedoStack();
        this.updateUndoRedoButtons();
    }

}
