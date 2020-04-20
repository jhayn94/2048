package game.factory;

import game.controller.ApplicationStateContext;
import game.model.BoardHistory;
import game.model.BoardModel;

/**
 * This class contains methods to instantiation all models or entities shown in
 * the application.
 */
public class ModelFactory {

    private static ModelFactory instance;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public BoardModel createBoard() {
        final BoardModel boardModel = new BoardModel();
        ApplicationStateContext.getInstance().setBoard(boardModel);
        return boardModel;
    }

    public BoardHistory createBoardHistory() {
        final BoardHistory boardHistory = new BoardHistory();
        ApplicationStateContext.getInstance().setHistory(boardHistory);
        return boardHistory;
    }

    private ModelFactory() {
        // Private constructor to prevent external instantiation.
    }

}
