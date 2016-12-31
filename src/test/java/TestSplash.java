import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Lucas on 28/12/2016.
 */
public class TestSplash extends Application{


    @Override
    public void start(Stage stage) throws Exception {

        Parent parent =  FXMLLoader.load(getClass().getResource("visao/splash/SplashFXML.fxml"));
        Image applicationIcon = new Image(getClass().getResourceAsStream("imagens/Logo.png"));
        stage.getIcons().add(applicationIcon);
        Scene scene = new Scene(parent);
        scene.setFill(null);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }
}
