
package onmc;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;

public class RegistroController implements Initializable{
    
    @FXML
    Slider volumen;
    
    @FXML
    ToggleButton plst;
    
    @FXML
    audio audioRegistro;
    
    @FXML
    Button config, rAceptar;
    
    @FXML
    TextField rUsuario, rCorreo, rNombre, rApellidos;
    
    @FXML
    DatePicker rNacimiento;
    
    @FXML
    PasswordField rContrasenya;
    
    Gestor_conexion_POSTGRE conection = new Gestor_conexion_POSTGRE("juego", true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        audioRegistro=new audio(volumen, plst);
        audioRegistro.musicaAudio1();
    }
    
    @FXML
    public void btnRAceptar(ActionEvent event) throws Exception {
        
        audioRegistro.musicaOff1();
        
        String consulta;
        String user = "'" + rUsuario.getText()+"'";
        String password = rContrasenya.getText();
        String mail = "'" + rCorreo.getText()+ "'";
        String name =  "'" + rNombre.getText()+ "'";
        String secondName =  "'" + rApellidos.getText() + "'";
        String bData = "'" + rNacimiento.getValue() + "'";
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String sha256 = "'" + DatatypeConverter.printHexBinary(digest).toLowerCase() + "'";
        
        consulta = "insert into usuario (usuario, contrasenya, correo_electronico, nombre, apellidos, fecha_nacimiento) values ("+ user + "," + sha256 + "," + mail + "," + name + "," + secondName + "," + bData + ");";
        Bd.consultaModificacion(conection, consulta);
       
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Inicio.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
}