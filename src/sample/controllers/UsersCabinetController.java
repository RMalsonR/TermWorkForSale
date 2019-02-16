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
import sample.repositories.UsersRepositories;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersCabinetController{
    User user;

    @FXML
    public Text setNameOfClient;

    public void cancelBtn(ActionEvent actionEvent) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Авторизация");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/SignInView.fxml"));
        Parent root = loader.load();
        SignInController controller = loader.getController();
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }



    public void profileActionBtn(ActionEvent actionEvent) {

    }

    public void getCreditActionBtn(ActionEvent actionEvent) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Оформление");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/GetCreditView.fxml"));
        Parent root = loader.load();
        GetCreditController controller = loader.getController();
        controller.loginLabel.setText(setNameOfClient.getText());
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }
}
