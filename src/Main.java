import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Main extends Application {
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        WorldGeneration world = new WorldGeneration(scene);

        Player player = new Player(100, 450, 20, scene);


        world.getRoot().getChildren().add(player.getCircle());
        root.getChildren().add(world.getRoot());

        primaryStage.setTitle("JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}