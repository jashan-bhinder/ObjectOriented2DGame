import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Scene;


public class Player {
    private Circle circle;

    public Player(double x, double y, double radius, Scene scene) {
        circle = new Circle(x, y, radius);
        circle.setFill(Color.BLACK);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case W -> circle.setCenterY(circle.getCenterY() - 10);
                case A -> circle.setCenterX(circle.getCenterX() - 10);
                case S -> circle.setCenterY(circle.getCenterY() + 10);
                case D -> circle.setCenterX(circle.getCenterX() + 10);
            }
        });
    }
    public Circle getCircle() {
        return circle;
    }


}
