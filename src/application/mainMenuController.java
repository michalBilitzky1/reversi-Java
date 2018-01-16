package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import reversiapp.Board;
import reversiapp.Game;

public class mainMenuController {
    @FXML
    protected void exit(javafx.event.ActionEvent event) {

    }
    @FXML
    protected void play(javafx.event.ActionEvent event){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("reversiGame.fxml"));
            Scene scene = new Scene(parent,720,600);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Reversi game");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void settings(javafx.event.ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("settings.fxml"));
            Scene scene = new Scene(parent,426,640);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setTitle("Settings");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}