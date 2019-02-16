package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.models.User;
import sample.controllers.SignInController;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersCabinetController implements Initializable {
    public static User user = SignInController.user;
    @FXML
    private Text setNameOfClient;

    public void cancelBtn(ActionEvent actionEvent) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Авторизация");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/SignInView.fxml"));
        Parent root = loader.load();
        SignInController controller = loader.getController();
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setNameOfClient.setText(user.getName() + " " +user.getLastName());
    }

    public void takeCredit(ActionEvent actionEvent) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Меню взятия кредита");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/TakeCreditView.fxml"));
        Parent root = loader.load();
        TakeCreditController controller = loader.getController();
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

    public void showCredit(ActionEvent actionEvent) {
    }
}
