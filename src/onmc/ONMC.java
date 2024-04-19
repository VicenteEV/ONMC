
package onmc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ONMC extends Application {
    
    public static Stage stage;
    
    static void getStage(Stage s){stage=s;}
    
    @Override
    public void start(Stage stage) throws Exception {
        getStage(stage);

        Parent root = FXMLLoader.load(getClass().getResource("Escenas/Inicio.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
