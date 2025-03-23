import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Scene;


public class Player {
    private Circle circle;

    public Player(double x, double y, double radius, Scene scene) { //is the player constructor
        circle = new Circle(x, y, radius); //creates a new circle object
        circle.setFill(Color.BLACK);

        scene.setOnKeyPressed(event -> { //everytime you press a button this resets

            double sceneWidth = scene.getWidth(); //so you need to update the scene width everytime
            double sceneHeight = scene.getHeight();

            double newX = circle.getCenterX();// and you need to update the coordinates of the circle everytime too
            double newY = circle.getCenterY();

            switch (event.getCode()){ // the event.getCode() tells you which key was pressed
                case W -> newY -= 10;
                case S -> newY += 10;
                case A -> newX -= 10;
                case D -> newX += 10;
            }
            if (newX - radius < 0) newX = radius;
            if (newX + radius > sceneWidth) newX = sceneWidth - radius;
            if (newY - radius < 0) newY = radius;
            if (newY + radius > sceneHeight) newY = sceneHeight - radius;
            if (newY + radius > groundTopY) newY = groundTopY - radius;

// Now apply the movement
            circle.setCenterX(newX);
            circle.setCenterY(newY);
        });
    }
    public Circle getCircle() {
        return circle;
    }
}
