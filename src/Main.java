import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class Main extends Application {
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        Button button = new Button("Play");

        WorldGeneration world = new WorldGeneration(scene);

        Player player = new Player(100, 450, 20, scene, world);


        world.getRoot().getChildren().add(player.getCircle());
        root.getChildren().add(world.getRoot());
        root.getChildren().add(button);

        primaryStage.setTitle("JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}