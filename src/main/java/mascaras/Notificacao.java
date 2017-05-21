package mascaras;

import model.vo.Usuario;
import org.controlsfx.control.Notifications;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.util.Duration;

/**
 * Created by lucas on 03/01/17.
 */
public class Notificacao {

    public void notificacao(int x){

        Usuario usuario = new Usuario();

        switch (x){

            case 1:



                Notifications erro1= Notifications.create()
                        .title("ERRO LOGIN")
                        .text("Nome de Usuário ou Senha Está Incorreto, ou Você Não Tem Permissões"+ usuario.getNome()+ usuario.getSenha())
                        .graphic(null)
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.BASELINE_LEFT)
                        .onAction(new EventHandler<javafx.event.ActionEvent>() {
                            @Override
                            public void handle(javafx.event.ActionEvent event) {


                            }

                        });

                erro1.showConfirm();



                break;


        }


    }




}
