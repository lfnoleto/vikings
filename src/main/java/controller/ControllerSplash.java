package controller;

import com.jfoenix.controls.JFXProgressBar;
import connection.ConnectionFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.IIOException;


import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Dao.CreateDatabase;


/**
 * Created by lucas on 31/12/16.
 */
public class ControllerSplash implements Initializable{

    CreateDatabase database = new CreateDatabase();

    @FXML
    private AnchorPane roott;

    @FXML
    private JFXProgressBar teste;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new SplashScreee().start();

    }

    class SplashScreee extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(5000);


                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/visao/login/LoginFXML.fxml"));

                        } catch (IIOException ex) {
                            Logger.getAnonymousLogger(ControllerSplash.class.getName()).log(Level.SEVERE, null, ex);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setResizable(false);
                        stage.show();
                        roott.getScene().getWindow().hide();

                    }

                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

 public void TesteConnection(){

     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;

     if (con!=null){

         if(con!=null){




         }

     }else if (con==null){






     }





 }


}


