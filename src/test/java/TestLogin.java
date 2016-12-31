import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Lucas on 28/12/2016.
 */
public class TestLogin extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Parent parent =  FXMLLoader.load(getClass().getResource("visao/login/LoginFXML.fxml"));
        //stage.getIcons().add(new Image(getClass().getResourceAsStre("img/icone.png"<img src="">));
        Scene scene = new Scene(parent);
        scene.setFill(null);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

}
