package game.factory;

import game.controller.ApplicationStateContext;
import game.view.BoardView;
import game.view.BoardViewWrapper;
import game.view.InfoPane;
import game.view.MainApplicationView;

/**
 * This class contains methods to instantiate all views shown in the
 * application.
 */
public class LayoutFactory {

    private static LayoutFactory layoutFactoryInstance;

    public static LayoutFactory getInstance() {
        if (layoutFactoryInstance == null) {
            layoutFactoryInstance = new LayoutFactory();
        }
        return layoutFactoryInstance;
    }

    public MainApplicationView createMainApplicationView() {
        return new MainApplicationView();
    }

    public InfoPane createInfoPane() {
        final InfoPane infoPane = new InfoPane();
        ApplicationStateContext.getInstance().setInfoPane(infoPane);
        return infoPane;
    }

    public BoardView createBoardView() {
        final BoardView boardView = new BoardView();
        ApplicationStateContext.getInstance().setBoardView(boardView);
        return boardView;
    }

    public BoardViewWrapper createBoardViewWrapper() {
        return new BoardViewWrapper();
    }
}
