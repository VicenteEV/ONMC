
package onmc;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PerfilController {
    
    @FXML
    private Button config, puntuacion, jugar, jugarSolo;
    
    @FXML
    public void btnConfig(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Inicio.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    @FXML
    public void btnPuntuacion(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Inicio.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    @FXML
    public void btnJugar(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Juego.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    @FXML
    public void btnJugarSolo(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Juego.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
}
