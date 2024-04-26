
package onmc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;

public class VictoriaController implements Initializable{
    @FXML
    Slider volumen;
    
    @FXML
    ToggleButton plst;
    
    @FXML
    audio audioVictoria;
    
    @FXML
    private Label vUsuario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        audioVictoria=new audio(volumen, plst);
        audioVictoria.musicaAudio3();
        initializeUsuario();
    }
    
    @FXML
    public void initializeUsuario() {
        
        if (JuegoPCController.pantano1.isVictoria() == true) {
            vUsuario.setText(InicioController.user);
        } 
        else {
            vUsuario.setText("Profe WIN");
        } 
    }
    
    @FXML
    public void btnvljugar(ActionEvent event) throws Exception {
        audioVictoria.musicaOff3();
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Perfil.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
}
