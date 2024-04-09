
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
    public void btnConfig(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Inicio.fxml"));
            Stage stage = (Stage) config.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    public void btnRAceptar(ActionEvent event) {
        
        String consulta;
        String user = "'" + rUsuario.getText()+"'";
        String password = "'" + rContrasenya.getText()+"'";
        String mail = "'" + rCorreo.getText()+ "'";
        String name =  "'" + rNombre.getText()+ "'";
        String secondName =  "'" + rApellidos.getText()+ "'";
        
        
        consulta = "insert into usuario (usuario, contrasenya, correo_electronico, nombre, apellidos) values ("+ user + "," + password + "," + mail + "," + name + "," + secondName + ");";
        
        Bd.consultaModificacion(conection, consulta);
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Inicio.fxml"));
            Stage stage = (Stage) rAceptar.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
            
        }catch (IOException io){
            io.printStackTrace();
        }
        
    }
    

}
