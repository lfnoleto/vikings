package controller;

import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

//import Notificacao;
import mascaras.Notificacao;
import model.Bo.CadastroUsuario;
import model.vo.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lucas on 03/01/17.
 */
public class ControllerUsuario implements Initializable {


    Notificacao notificacao = new Notificacao();
    CadastroUsuario cadastroUsuario = new CadastroUsuario();
    Usuario usuario = new Usuario();


    @FXML
    private JFXPasswordField senha,conSenha;
    @FXML
    private Button confimar,cancelar,fecha;

    private String nome = "Adminitrado";


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btConfimarAction(ActionEvent evt) {

        if (senha.getText().trim().equals(conSenha.getText()) && senha.getText()!=null){

            usuario.setNome(this.nome);
            usuario.setSenha(this.senha.getText());
            cadastroUsuario.salva(usuario);

            this.senha.setText(null);
            this.conSenha.setText(null);

            System.out.println("passo em controlle");


        }else{

            notificacao.notificacao(1);
            this.senha.setText(null);
            this.conSenha.setText(null);




        }




    }

    public void btCancelarAction(ActionEvent evt) {

        System.exit(0);


    }
}
