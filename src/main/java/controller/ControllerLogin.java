package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * Created by Lucas-PC atualizado 11/12/2016.
 */

public class ControllerLogin implements Initializable {
	
	@FXML
	private Button tbCancelar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void tbCancelarAction(ActionEvent event) {
		Platform.exit();
	}
}
