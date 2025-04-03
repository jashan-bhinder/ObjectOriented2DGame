import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import java.util.HashSet;
import java.util.Set;
//this class has mostly been about designing and learning how to do movement however instead I will start splitting this class
public class Player {
    private Circle circle;
    private double velocityY = 0;
    private final double gravity = 0.5;
    private final double jumpStrength = -10;
    private Set<KeyCode> pressedKeys = new HashSet<>();
    private boolean jumpPressedLastFrame = false;

    public Player(double x, double y, double radius, Scene scene, WorldGeneration world) {
        circle = new Circle(x, y, radius);
        circle.setFill(Color.BLACK);

        scene.setOnKeyPressed(event -> pressedKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                double newX = circle.getCenterX();
                double newY = circle.getCenterY() + velocityY;
                double radius = circle.getRadius();

                double sceneWidth = scene.getWidth();
                double sceneHeight = scene.getHeight();

                // Horizontal movement
                if (pressedKeys.contains(KeyCode.A)) {
                    newX -= 5;
                }
                if (pressedKeys.contains(KeyCode.D)) {
                    newX += 5;
                }

                // Jump (mid-air allowed)
                boolean jumpPressedNow = pressedKeys.contains(KeyCode.W);
                if (jumpPressedNow && !jumpPressedLastFrame) {
                    velocityY = jumpStrength;
                }
                jumpPressedLastFrame = jumpPressedNow;

                // Apply gravity
                velocityY += gravity;

                // Clamp to window vertically (so player doesn't fall off screen)
                if (newY - radius < 0) {
                    newY = radius;
                    velocityY = 0;
                } else if (newY + radius > sceneHeight) {
                    newY = sceneHeight - radius;
                    velocityY = 0;
                }

                // Clamp horizontally
                if (newX - radius < 0) newX = radius;
                if (newX + radius > sceneWidth) newX = sceneWidth - radius;

                circle.setCenterX(newX);
                circle.setCenterY(newY);
            }
        }.start();
    }

    public Circle getCircle() {
        return circle;
    }
}
