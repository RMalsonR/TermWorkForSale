package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.User;
import sample.repositories.UsersRepositories;

import java.io.IOException;

public class ProfileController{

    @FXML
    public Label userLogin;
    @FXML
    public Label creditText;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField targerField;
    @FXML
    private TextField salaryField;


    public void backButcton(ActionEvent actionEvent) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Личный кабинет");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/UsersCabinet.fxml"));
        Parent root = loader.load();
        UsersCabinetController controller = loader.getController();
        controller.setNameOfClient.setText(userLogin.getText());
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

    public void changeButton(ActionEvent actionEvent) throws IOException {
        try {
            if(loginField.getText()!=null && passwordField.getText()!=null && targerField.getText()!=null && Integer.parseInt(salaryField.getText())!=0) {
                User user = UsersRepositories.getUserByLogin(userLogin.getText());
                user.setLogin(loginField.getText());
                user.setPassword(passwordField.getText());
                user.setCreditTarget(targerField.getText());
                user.setSalary(Integer.parseInt(salaryField.getText()));
                UsersRepositories.update(user);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверные данные.");
            alert.setContentText("При изменениине не оставляйте пустых полей");
            alert.showAndWait();
        }
    }

}
