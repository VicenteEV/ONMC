
package onmc;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilidades.bbdd.Bd;
import static utilidades.bbdd.Bd.crearBBDD;
import utilidades.bbdd.Gestor_conexion_POSTGRE;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javafx.scene.Parent;



public class RegistroController {
    
    @FXML
    Button config, rAceptar;
    @FXML
    TextField rUsuario, rCorreo, rNombre, rApellidos;
    @FXML
    DatePicker rNacimiento;
    @FXML
    PasswordField rContrasenya;
    
    Gestor_conexion_POSTGRE conection = new Gestor_conexion_POSTGRE("juego", true);
    
    @FXML
    public void btnRAceptar(ActionEvent event) throws Exception {
        
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
        System.out.println("Te has registrado");
        
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Inicio.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
   
    }
}