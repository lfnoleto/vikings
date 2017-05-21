package model.Bo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mascaras.Notificacao;
import model.Dao.UsuarioDao;
import model.vo.Usuario;

/**
 * Created by noleto on 18/05/2017.
 */
public class Login {

    Notificacao notificacao = new Notificacao();
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario i = new Usuario();


    public  void pesquisaLogin(String i,String y ) {

        if (usuarioDao.checkLogin(i,y)) {


            try {
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("/visao/Screen_base/Screen_base.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setResizable(false);
                stage.show();

            }catch (Exception e){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro ao chama ");
                alert.setHeaderText(null);
                alert.setContentText("To Flame Screen contact me with support err <--- T1000 --->");
                alert.show();

            }


        } else {

            notificacao.notificacao(1);


        }


    }


}
