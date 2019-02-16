package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    public void helpBtnAction(ActionEvent actionEvent){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информация");
            alert.setHeaderText("Вы находитесь на стадии авторизации");
            alert.setContentText("На этой страницей вы можете зайти в свою учетную запись " +
                    "или зарегестрировать нового пользователя");
            alert.showAndWait();
    }

    public void registrationBtnAction(ActionEvent actionEvent) throws IOException {
            Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            stage.setTitle("Регистрация");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/SignUpView.fxml"));
            Parent root = loader.load();
            SignUpController controller =  loader.getController();
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

}
