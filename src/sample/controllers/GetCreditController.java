package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.Credit;
import sample.models.User;
import sample.repositories.UsersRepositories;

import java.io.IOException;
import java.util.Date;

public class GetCreditController {
    @FXML
    public Label loginLabel;

    @FXML
    private TextField sumOfreditField;

    @FXML
    private TextField countOfAgeField;

    public void getCreditAction(ActionEvent actionEvent) throws IOException {
        try {
            User user = UsersRepositories.getUserByLogin(loginLabel.getText());
            int countOfAge = Integer.parseInt(countOfAgeField.getText());
            int sumOfCredit = Integer.parseInt(sumOfreditField.getText());
            int sumByMounth = (int) ((sumOfCredit + sumOfCredit * 0.1) / (countOfAge * 12));
            String[] parseUser = user.getbDate().split("-");
            int age = 2019 - Integer.parseInt(parseUser[0]);

            if (UsersRepositories.checkCreditHistory(user)){
                getAlert("У вас уже имеется кредит");
                cancelBtnAction(actionEvent);
                return;
            }

            if (sumByMounth <= user.getSalary()/2 && countOfAge <= 15 && user.getCitizen().equals("РФ") && age > 21){
                Credit credit = new Credit(sumOfCredit, String.valueOf(countOfAge), sumByMounth);
                user.setCredit(credit);
                System.out.println(user.getCredit().toString());
                UsersRepositories.writeCreditHistory(user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Поздравляем!");
                alert.setHeaderText("Ваш кредит успешно одобрен");
                alert.setContentText("Уже скоро наш специалист свяжется с вами и даст дальнейшие инструкции");
                alert.showAndWait();
                cancelBtnAction(actionEvent);
            } else {
                getAlert("Кредит не одобрен");
                cancelBtnAction(actionEvent);
            }
        } catch (Exception e) {
            getAlert("Ошибка при выдаче кредита");
            e.printStackTrace();
        }
    }

    private void getAlert(String alertText){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Что-то пошло не так");
        alert.setContentText(alertText);
        alert.showAndWait();
    }

    private void cancelScene(ActionEvent actionEvent, String login) throws IOException {
        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Личный кабинет");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/UsersCabinet.fxml"));
        Parent root = loader.load();
        UsersCabinetController controller = loader.getController();
        controller.setNameOfClient.setText(login);
        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

    public void cancelBtnAction(ActionEvent actionEvent) throws IOException {
        cancelScene(actionEvent, loginLabel.getText());
    }


}
