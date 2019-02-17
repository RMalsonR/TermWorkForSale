package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.User;
import sample.repositories.UsersRepositories;

import java.io.IOException;

public class SignUpController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField patronymicField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField citizenField;

    @FXML
    private TextField pointField;

    @FXML
    private TextField salaryField;

    public void helpPhoneBtnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Это поле для ввода даты рождения");
        alert.setContentText("Введите дату вашего рождения в формате ГГГГ-ММ-ДД (Год-месяц-день)");
        alert.showAndWait();
    }

    public void helpCitizenBtnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Это поле для ввода гражданства");
        alert.setContentText("Введите 'РФ' если вы имеете граждаство в России или 'Другое' если нет");
        alert.showAndWait();
    }

    public void cancelBtnAction(ActionEvent actionEvent) throws IOException{
            swapStage(actionEvent);
    }

    public User signUpBtnAction(ActionEvent actionEvent) throws IOException {
        try {

            if (UsersRepositories.getUserByLogin(loginField.getText()) != null){
                throw new IllegalArgumentException();
            }

            String prevHash = nameField.getText() + surnameField.getText() + passwordField.getText();
            User newUser = new User(
                    prevHash.hashCode(),
                    loginField.getText(),
                    passwordField.getText(),
                    nameField.getText(),
                    patronymicField.getText(),
                    surnameField.getText(),
                    dateField.getText(),
                    citizenField.getText(),
                    cityField.getText(),
                    Integer.parseInt(salaryField.getText()),
                    pointField.getText(),
                    numberField.getText()
            );

            UsersRepositories.write(newUser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Успешно");
            alert.setHeaderText("Поздравляем!");
            alert.setContentText("Вы были успешно зарегестрированы!");
            alert.showAndWait();

            swapStage(actionEvent);

            return newUser;

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Что-то пошло не так");
            alert.setContentText("Ошибка при регистрации");
            alert.showAndWait();
        }
        return null;
    }

    public void swapStage(ActionEvent actionEvent) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Авторизация");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/SignInView.fxml"));
        Parent root = loader.load();
        SignInController controller = loader.getController();
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }
}
