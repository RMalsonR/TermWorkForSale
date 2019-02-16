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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    final ComboBox<String> comboCitizen = new ComboBox<>(FXCollections.observableArrayList(
            "Российская Федерация", "Страны СНГ", "Другие страны"));

//    {
//        ObservableList<String> listCitizen = FXCollections.observableArrayList(
//                "Российская Федерация", "Страны СНГ", "Другие страны");
//        comboCitizen = new ComboBox<>(listCitizen);
//        comboCitizen.setValue("Российская Федерация");
//    }

    public void helpPhoneBtnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Это поле для ввода даты рождения");
        alert.setContentText("Введите дату вашего рождения в формате ГГГГ-ММ-ДД (Год-месяц-день)");
        alert.showAndWait();
    }

    public void cancelBtnAction(ActionEvent actionEvent) throws IOException{
            Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            stage.setTitle("Авторизация");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/SignInView.fxml"));
            Parent root = loader.load();
            SignInController controller = loader.getController();
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }
}
