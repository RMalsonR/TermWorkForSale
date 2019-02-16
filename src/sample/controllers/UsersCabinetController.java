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


public class UsersCabinetController {

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

    public void takeCredit(ActionEvent actionEvent) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Меню взятия кредита");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/TakeCreditView.fxml"));
        Parent root = loader.load();
        TakeCreditController controller = loader.getController();
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

    public void showCredit(ActionEvent actionEvent) throws IOException {
        User user = UsersRepositories.getUserByLogin(setNameOfClient.getText());
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Мои данные и кредиты");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/ProfileView.fxml"));
        Parent root = loader.load();
        ProfileController controller = loader.getController();
        controller.userLogin.setText(setNameOfClient.getText());
        if (user.getCredit() != null) {
            controller.creditText.setText(user.getCredit().toString());
        }
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

}
