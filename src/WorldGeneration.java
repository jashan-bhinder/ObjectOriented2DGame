import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;

public class WorldGeneration {
    private Group root;

    public WorldGeneration(Scene scene) {
        root = new Group();

        double groundY = 500;

        Rectangle ground = new Rectangle(0, groundY, 800, 100);
        ground.setFill(Color.GREEN);

        ground.widthProperty().bind(scene.widthProperty());
        ground.heightProperty().bind(scene.heightProperty().subtract(groundY));

        root.getChildren().add(ground);
    }

    public Group getRoot() {
        return root;  // Return the world as a JavaFX node
    }
}
