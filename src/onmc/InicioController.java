
package onmc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


public class InicioController {
    
    public static void mostrar (String [][] vec) {
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[0].length; j++) {
                System.out.println(vec[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    @FXML
    private Button registro, inicioSesion, jugarInvitado, config;
    @FXML
    PasswordField iContrasenya;
    TextField iUsuario;
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
        
        //String [][] vec;
        boolean temp = false;
        String consultaUsuario, consultaContrasenya;
        String user =  "'" + iUsuario.getText()+"'";
        String password = "'" + iContrasenya.getText()+"'";
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String sha256 = "'" + DatatypeConverter.printHexBinary(digest).toLowerCase() + "'";
        
        consultaUsuario = "select usuario from usuario where usuario = user";
        consultaContrasenya = "select contrasenya from usuario where contrasenya = sha256";
        
        Bd.consultaSelect(conection, consultaUsuario);
        Bd.consultaSelect(conection, consultaContrasenya);
        //if (vec != null) {
            //mostrar(vec);
        //}
        //System.out.print(vec = );
        if (consultaUsuario != null && consultaContrasenya != null) {
            if (user.equals(consultaUsuario)){
                if (sha256.equals(consultaContrasenya)) {
                    temp = true;
                    System.out.println("Has entrado");
                }
            }
        }
          
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Perfil.fxml"));
            Stage stage = (Stage) inicioSesion.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
       @FXML
    public void btnJugarInvitado(ActionEvent event) {
        tablajuego crearTabla=new tablajuego();
        if(crearTabla.pantanoPersonas()==true){
            System.out.println("Caca");
        }
            
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Juego.fxml"));
            Stage stage = (Stage) jugarInvitado.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true); 
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
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
    
    
}
