import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        WorldGeneration world = new WorldGeneration();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
