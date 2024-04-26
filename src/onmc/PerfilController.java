
package onmc;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import static onmc.InicioController.idPar;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;

public class PerfilController {
    
    @FXML
    Slider volumen;
    
    @FXML
    ToggleButton plst;
    
    @FXML
    audio audioPerfil;
    
    @FXML
    private Label usuario;
    
    @FXML
    String [][] vec;
    
    Gestor_conexion_POSTGRE conection = new Gestor_conexion_POSTGRE("juego", true);
    
    @FXML
    public void initialize(){
        audioPerfil=new audio(volumen, plst);
        audioPerfil.musicaAudio4();
        usuario.setText(InicioController.user);
    }
    
    @FXML
    public void btnPuntuacion(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Inicio.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    @FXML
    public void btnJugar(ActionEvent event) throws Exception {
        
        audioPerfil.musicaOff4();
        
        String consulta = "insert into partida (fecha) values (current_timestamp)";
        Bd.consultaModificacion(conection, consulta);
        
        String consultaIdPartida = "select id_partida from partida order by id_partida desc limit 1";
        vec = Bd.consultaSelect(conection, consultaIdPartida);
        idPar = vec[0][0];
        
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Juego.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    @FXML
    public void btnJugarSolo(ActionEvent event) throws Exception {
        
        audioPerfil.musicaOff4();
        
        String consulta = "insert into partida (fecha) values (current_timestamp)";
        Bd.consultaModificacion(conection, consulta);
        
        String consultaIdPartida = "select id_partida from partida order by id_partida desc limit 1";
        vec = Bd.consultaSelect(conection, consultaIdPartida);
        idPar = vec[0][0];
        
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/JuegoPC.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    } 
}
