package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private Text actiontarget;

    @FXML
    private javafx.scene.control.TextField login;


    @FXML
    private javafx.scene.control.TextField password;

    ManageUsers manager = new ManageUsers();
    List<UsersEntity> users = new ArrayList<UsersEntity>();



    @FXML
    public void handleSubmitButtonAction(ActionEvent actionEvent) {

        for (UsersEntity user : users) {
            if (user.getLogin().equals(login.getText().toString())){
                if (user.getPassword().equals(password.getText().toString())){
                    actiontarget.setText("You are logged in");
                }else {
                    actiontarget.setText("Password does not match");
                }
            } else {
                actiontarget.setText("Login does not match");
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        users = manager.listOfUsers();
    }
}
