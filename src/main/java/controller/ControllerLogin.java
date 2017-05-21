package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Bo.Login;
import model.vo.Usuario;

/**
 * Created by Lucas-PC atualizado 17/05/2017.
 *
 * implemetaçao da class de entraa no sistema
 */

public class ControllerLogin implements Initializable {

	Usuario use = new Usuario();
	Login login = new Login();

	@FXML
	private Button tbCancelar,tbentra;

	@FXML
	private JFXTextField usuario;

	@FXML
	private JFXPasswordField senha;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setTbentraAction(ActionEvent event){

        use.setNome(usuario.getText());
        use.setSenha(senha.getText());
        System.out.print(use.getNome()+use.getSenha());

		login.pesquisaLogin(usuario.getText(),senha.getText());

	}

	public void tbCancelarAction(ActionEvent event) {

		Platform.exit();

	}


}
