package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by noleto on 20/05/2017.
 */
public class ControlerMenu implements Initializable {

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton b4;
    @FXML
    private JFXButton exit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }



    @FXML
    private void changeColor(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch(btn.getText())
        {
            case "Color 1":ControllerScreenBase.rootP.setStyle("-fx-background-color:#00FF00");
                break;
            case "Color 2":ControllerScreenBase.rootP.setStyle("-fx-background-color:#0000FF");
                break;
            case "Color 3":ControllerScreenBase.rootP.setStyle("-fx-background-color:#FF0000");
                break;
            case "Color 4":ControllerScreenBase.rootP.setStyle("-fx-background-color:#FF0000");
                break;
            case "Color 5":ControllerScreenBase.rootP.setStyle("-fx-background-color:#FF0000");
                break;
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
}
