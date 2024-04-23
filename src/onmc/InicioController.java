
package onmc;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


public class InicioController implements Initializable{
    Media audioInicio = new Media(Paths.get("src/audio/cocodrilo.wav").toUri().toString());
    MediaPlayer cocodrilo=new MediaPlayer(audioInicio);
    @FXML
    private Button registro, inicioSesion, jugarInvitado, config;
    @FXML
    PasswordField iContrasenya;
    @FXML
    TextField iUsuario;
    @FXML
    public static String user;
    private String password;
    
    Gestor_conexion_POSTGRE conection = new Gestor_conexion_POSTGRE("juego", true);
    
    
    @FXML
    public void btnRegistro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Registro.fxml"));
            Stage stage = (Stage) registro.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    public void btnInicioSesion(ActionEvent event) throws Exception{
        
        boolean temp = false;
        String consultaUsuario;
        user = iUsuario.getText();
        password = iContrasenya.getText();
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
        
        consultaUsuario = "select usuario, contrasenya from usuario where usuario= " + "'" + user + "'" + "and" + " contrasenya="+ "'" + sha256 + "'";
            
        
        if (Bd.consultaSelect(conection, consultaUsuario) != null) {
            temp = true;
        }

        if (temp == true){     
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Perfil.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
        
        }

    }
    
    @FXML
    public void btnJugarInvitado(ActionEvent event) throws Exception {
        
        
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/JuegoPC.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //cocodrilo.play();
      //cocodrilo.stop();
    }
}
