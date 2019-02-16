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
import sample.models.User;
import sample.repositories.UsersRepositories;
import sample.repositories.UsersRepositories;

import java.io.IOException;
import java.util.ArrayList;

public class SignInController {
    //    public static User user;
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    public void helpBtnAction(ActionEvent actionEvent) {
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
        SignUpController controller = loader.getController();
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

    private void loginAndPasswordExeption() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Пользователь не найден");
        alert.setContentText("Проверьте введённые Вами данные.");
        alert.showAndWait();
    }

    public void btnSignIn(ActionEvent actionEvent) throws IOException {
        ArrayList<User> allUsers = UsersRepositories.getAllUsers();
        boolean cheker = false;
        int i;
        for (i = 0; i < allUsers.size(); i++) {
            if (loginField.getText().equals(allUsers.get(i).getLogin()) && passwordField.getText().equals(allUsers.get(i).getPassword())) {

                Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setTitle("Личный кабинет");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/UsersCabinet.fxml"));
                Parent root = loader.load();
                UsersCabinetController controller = loader.getController();
                stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));

//                controller.user = allUsers.get(i);
                controller.setNameOfClient.setText(allUsers.get(i).getLogin());
//                controller.user = user;
                cheker = true;
            }
        }
        if (!cheker) loginAndPasswordExeption();
    }
}
