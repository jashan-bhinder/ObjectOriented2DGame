package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    @FXML
    private Button GoToGame;

    @FXML
    public void initialize() {
        // Optional: runs when the scene loads
    }

    @FXML
    private void onPlayClicked() {
        System.out.println("Play button clicked!");
        // You can trigger scene switch or game start logic here
    }
}