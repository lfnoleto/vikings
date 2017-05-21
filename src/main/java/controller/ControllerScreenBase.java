package controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by noleto on 20/05/2017.
 */
public class ControllerScreenBase implements Initializable {


    @FXML
    private JFXHamburger selectMenu;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane root;
    @FXML
    private Button bt_Exist;

    public  static AnchorPane rootP;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rootP = root;

        try {
            VBox box = FXMLLoader.load(getClass().getResource("/visao/Menu/Menu.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(ControllerScreenBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(selectMenu);
        transition.setRate(-1);
        selectMenu.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();

            if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
        });


    }


    public void tbCancelarAction(ActionEvent event) {

        Platform.exit();

    }




}
