package game.state.model;

import game.model.BoardHistory;
import game.model.BoardModel;
import game.state.GameState;

/**
 * This class updates the state of the application when the user invokes an
 * "undo", either through the keyboard or a button press in the UI.
 */
public class UndoActionState extends GameState {

    public UndoActionState() {
        super();
    }

    @Override
    public void onEnter() {
        final BoardHistory history = this.context.getHistory();
        if (!history.isUndoStackEmpty()) {
            this.clearHighlightedCells();
            final BoardModel board = history.getBoardForUndo();
            history.addToRedoStack(this.context.getBoard());
            this.context.setBoard(board);
            this.resetViewToMatchModel();
            this.updateUndoRedoButtons();
        }

    }

}
