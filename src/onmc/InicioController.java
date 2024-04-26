
package onmc;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;

public class InicioController implements Initializable{
    
    @FXML
    Slider volumen;
    
    @FXML
    ToggleButton plst;
    
    @FXML
    audio audioInicio;
            
    @FXML
    private Button registro;
    
    @FXML
    PasswordField iContrasenya;
    
    @FXML
    TextField iUsuario;
    
    @FXML
    public static String user;
    private String password;
    
    @FXML
    public static String idPar;
    public String [][] vec;
    
    Gestor_conexion_POSTGRE conection = new Gestor_conexion_POSTGRE("juego", true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        audioInicio=new audio(volumen, plst);
        audioInicio.musicaAudio1();
    }
  
    @FXML
    public void btnRegistro(ActionEvent event) {
        audioInicio.musicaOff1();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Registro.fxml"));
            Stage stage = (Stage) registro.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    public void btnInicioSesion(ActionEvent event) throws Exception{
        
        audioInicio.musicaOff1();
        
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
}
