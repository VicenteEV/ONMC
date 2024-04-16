
package onmc;

import java.io.IOException;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class JuegoController {

    @FXML
    private Button b00, b01, b02, b03, b04, b10, b11, b12, b13, b14, b20, b21, b22, b23, b24, b30, b31, b32, b33, b34, b40, b41, b42, b43, b44;
   
    private final Button[][] TABLA1= {{b00, b01, b02, b03, b04},{b10, b11, b12, b13, b14},{b20, b21, b22, b23, b24},{b30, b31, b32, b33, b34},{b40, b41, b42, b43, b44}};
    private tablajuego pantano1;
    
    @FXML
    private Button config, salir;
    
    @FXML
    private ProgressBar vida1;
    
    @FXML
    private ProgressBar vida2;
   
    @FXML
    private Label puntoA;
    
    @FXML
    private Label puntoB;
    
    @FXML
    private int pt = 0;
    
    @FXML
    public void initialize(){
        pantano1=new tablajuego();
        pantano1.pantanoPersonas();
        pantano1.pantanoCazadores();
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
    
    @FXML
    public void btnSalir(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Perfil.fxml"));
            Stage stage = (Stage) salir.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    public double barraVida(ProgressBar vida, int x, int y){
       
        if (pantano1.comprobarCasilla(x,y) == 2){
            pantano1.restaurarCasilla(x,y);
            pantano1.pantanoCazadores();
            
            return vida.getProgress()-0.33333333333;
        }
        return vida.getProgress();
    }
    
    public void Casilla(int x, int y){
        
        Button actual = TABLA1[x][y];
        switch(pantano1.comprobarCasilla(x,y)){
            case 0:{                                  //Desaparece el boton
                System.out.println("Agua"); 
                b00.setVisible(false);
                break;
            }
            case 1:{                                 //Cambia el boton por una imagen de las mismas dimensiones
               System.out.println("Bañista"); 
               break;
            }
            case 2:{                                //Cambia el boton por una imagen de las mismas dimensiones
               System.out.println("Cazador");
               break;
            }
        }
        pt=pantano1.puntuacion(x, y, pt);
        puntoA.setText(pt + " pt.");
        vida1.setProgress(barraVida(vida1,x,y));     
    }
   
    //BOTONES TABLA
    
    @FXML
    public void b00(){
        int x=0,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void b01(){
        int x=0,y=1;
        Casilla(x, y);
    }
    @FXML
    public void b02(){
        int x=0,y=2;
        Casilla(x, y);
    }
    @FXML
    public void b03(){
        int x=0,y=3;
        Casilla(x, y);
    }
    @FXML
    public void b04(){
        int x=0,y=4;
        Casilla(x, y);
    }
    @FXML
    public void b10(){
        int x=1,y=0;
        Casilla(x, y);
    }
    @FXML
    public void b11(){
        int x=1,y=1;
        Casilla(x, y);
    }
    @FXML
    public void b12(){
        int x=1,y=2;
        Casilla(x, y);
    }
    @FXML
    public void b13(){
        int x=1,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void b14(){
        int x=1,y=4;
        Casilla(x, y);
    }
    
    @FXML
    public void b20(){
        int x=2,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void b21(){
        int x=2,y=1;
        Casilla(x, y);
    }
    
    @FXML
    public void b22(){
        int x=2,y=2;
        Casilla(x, y);
    }
    
    @FXML
    public void b23(){
        int x=2,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void b24(){
        int x=2,y=4;
        Casilla(x, y);
    }
    
    @FXML
    public void b30(){
        int x=3,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void b31(){
        int x=3,y=1;
        Casilla(x, y);
    }
    
    @FXML
    public void b32(){
        int x=3,y=2;
        Casilla(x, y);
    }
    
    @FXML
    public void b33(){
        int x=3,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void b34(){
        int x=3,y=4;
        Casilla(x, y);
    }
    
    @FXML
    public void b40(){
        int x=4,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void b41(){
        int x=4,y=1;
        Casilla(x, y);
    }
    
    @FXML
    public void b42(){
        int x=4,y=2;
        Casilla(x, y);
    }
    
    @FXML
    public void b43(){
        int x=4,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void b44(){
        int x=4,y=4;
        Casilla(x, y);
    }
    
    @FXML
    public void a00(){
        int x=0,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void a01(){
        int x=0,y=1;
        Casilla(x, y);
    }
    @FXML
    public void a02(){
        int x=0,y=2;
        Casilla(x, y);
    }
    @FXML
    public void a03(){
        int x=0,y=3;
        Casilla(x, y);
    }
    @FXML
    public void a04(){
        int x=0,y=4;
        Casilla(x, y);
    }
    @FXML
    public void a10(){
        int x=1,y=0;
        Casilla(x, y);
    }
    @FXML
    public void a11(){
        int x=1,y=1;
        Casilla(x, y);
    }
    @FXML
    public void a12(){
        int x=1,y=2;
        Casilla(x, y);
    }
    @FXML
    public void a13(){
        int x=1,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void a14(){
        int x=1,y=4;
        Casilla(x, y);
    }
    
    @FXML
    public void a20(){
        int x=2,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void a21(){
        int x=2,y=1;
        Casilla(x, y);
    }
    
    @FXML
    public void a22(){
        int x=2,y=2;
        Casilla(x, y);
    }
    
    @FXML
    public void a23(){
        int x=2,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void a24(){
        int x=2,y=4;
        Casilla(x, y);
    }
    
    @FXML
    public void a30(){
        int x=3,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void a31(){
        int x=3,y=1;
        Casilla(x, y);
    }
    
    @FXML
    public void a32(){
        int x=3,y=2;
        Casilla(x, y);
    }
    
    @FXML
    public void a33(){
        int x=3,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void a34(){
        int x=3,y=4;
        Casilla(x, y);
    }
    
    @FXML
    public void a40(){
        int x=4,y=0;
        Casilla(x, y);
    }
    
    @FXML
    public void a41(){
        int x=4,y=1;
        Casilla(x, y);
    }
    
    @FXML
    public void a42(){
        int x=4,y=2;
        Casilla(x, y);
    }
    
    @FXML
    public void a43(){
        int x=4,y=3;
        Casilla(x, y);
    }
    
    @FXML
    public void a44(){
        int x=4,y=4;
        Casilla(x, y);
    }
}
