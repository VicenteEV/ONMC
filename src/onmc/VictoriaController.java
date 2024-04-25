
package onmc;

import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class VictoriaController {
    
    @FXML
    private Label vUsuario;
    
    public void initialize() {
        
        if (JuegoPCController.pantano1.isVictoria() == true) {
            vUsuario.setText(InicioController.user);
        } else {
            vUsuario.setText("Profe WIN");
        }
        
    }
}
