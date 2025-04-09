import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void switchToCustomization() {
        CharacterDesign design = new CharacterDesign();
        Scene scene = design.createScene();
        mainStage.setScene(scene);
    }

    public static void switchToGame() {
        javafx.scene.Group root = new javafx.scene.Group();
        Scene scene = new Scene(root, 800, 600);

        WorldGeneration world = new WorldGeneration(scene);
        Player player = new Player(100, 450, 20, scene, world);

        world.getRoot().getChildren().add(player.getCircle());
        root.getChildren().add(world.getRoot());

        mainStage.setScene(scene);
    }
}
