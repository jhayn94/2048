package game.model;

import java.util.Stack;

public class BoardHistory {

    private final Stack<BoardModel> undoStack;

    private final Stack<BoardModel> redoStack;

    public BoardHistory() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void addToUndoStack(final BoardModel newBoard) {
        this.undoStack.push(newBoard.createCopy());
    }

    public void addToRedoStack(final BoardModel newBoard) {
        this.redoStack.push(newBoard.createCopy());
    }

    /**
     * Gets the next state if an undo needs to occur.
     */
    public BoardModel getBoardForUndo() {
        return this.undoStack.pop();
    }

    /**
     * Gets the next state if a redo needs to occur.
     */
    public BoardModel getBoardForRedo() {
        return this.redoStack.pop();
    }

    /**
     * Clears the redoStack. This should be done when the user undoes an action,
     * then does something else. The undone states are no longer usable because we
     * do not want to manage a tree of states instead of just a stack.
     */
    public void clearRedoStack() {
        this.redoStack.clear();
    }

    /**
     * Clears the undoStack. Mostly used for when the puzzle changes.
     */
    public void clearUndoStack() {
        this.undoStack.clear();
    }

    public boolean isUndoStackEmpty() {
        return this.undoStack.isEmpty();
    }

    public boolean isRedoStackEmpty() {
        return this.redoStack.isEmpty();
    }

}
