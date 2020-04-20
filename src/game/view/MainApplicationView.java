package game.view;

import game.factory.LayoutFactory;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 * This class represents the main content view of the application.
 */
public class MainApplicationView extends VBox {

	private static final String CSS_CLASS = "main-app-view";

	private static final int PADDING = 15;

	public MainApplicationView() {
		super();
		this.configure();
	}

	private void configure() {
		this.setPadding(new Insets(PADDING));
		this.getStyleClass().add(CSS_CLASS);
		this.createChildElements();
	}

	private void createChildElements() {
		final InfoPane infoPane = LayoutFactory.getInstance().createInfoPane();
		final BoardViewWrapper boardViewWrapper = LayoutFactory.getInstance().createBoardViewWrapper();
		this.getChildren().addAll(infoPane, boardViewWrapper);
	}

}
