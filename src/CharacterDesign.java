import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.animation.RotateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CharacterDesign {

    public Scene createScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        // Example: animated character preview
        Circle characterPreview = new Circle(50);
        characterPreview.setStyle("-fx-fill: #4444ff");

        RotateTransition rotate = new RotateTransition(Duration.seconds(2), characterPreview);
        rotate.setByAngle(360);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.play();

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> {
            try {
                SceneManager.switchToGame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        layout.getChildren().addAll(characterPreview, startButton);
        return new Scene(layout, 800, 600);
    }
}

