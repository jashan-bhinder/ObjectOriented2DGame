import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager.setStage(primaryStage);
        SceneManager.switchToCustomization(); // start at customization scene
        primaryStage.setTitle("JavaFX Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
