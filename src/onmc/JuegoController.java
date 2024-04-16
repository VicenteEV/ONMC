
package onmc;

import java.io.IOException;
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
    private Button a00, a01, a02, a03, a04, a10, a11, a12, a13, a14, a20, a21, a22, a23, a24, a30, a31, a32, a33, a34, a40, a41, a42, a43, a44;
   
    @FXML
    private final Button[][] TABLA1= {{a00, a01, a02, a03, a04},{a10, a11, a12, a13, a14},{a20, a21, a22, a23, a24},{a30, a31, a32, a33, a34},{a40, a41, a42, a43, a44}};
   
    @FXML
    private Button b00, b01, b02, b03, b04, b10, b11, b12, b13, b14, b20, b21, b22, b23, b24, b30, b31, b32, b33, b34, b40, b41, b42, b43, b44;
   
    @FXML
    private final Button[][] TABLA2= {{b00, b01, b02, b03, b04},{b10, b11, b12, b13, b14},{b20, b21, b22, b23, b24},{b30, b31, b32, b33, b34},{b40, b41, b42, b43, b44}};
    
    @FXML
    private tablajuego pantano1, pantano2;
  
    @FXML
    private Button config, salir;
    
    @FXML
    private ProgressBar vida1, vida2;
   
    @FXML
    private Label puntoA, puntoB;
    
    @FXML
    private int pt1=0, pt2=0;
    
    @FXML
    public void initialize(){
        pantano1=new tablajuego();
        pantano1.pantanoPersonas();
        pantano1.pantanoCazadores();
        pantano2=new tablajuego();
        pantano2.pantanoPersonas();
        pantano2.pantanoCazadores();
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

    public void Casilla(int x, int y, char z){
        if(z=='a'){
            pantano1.casillaTabla(pantano1, vida1, x, y);
            pt1= pantano1.puntuacion(x, y, pt1);
            puntoA.setText(pt1 + " pt.");
        }
        if(z=='b'){
            pantano2.casillaTabla(pantano2, vida2, x, y);
            pt2= pantano1.puntuacion(x, y, pt2);
            puntoB.setText(pt2 + " pt.");
        }
    }
   
    //BOTONES TABLA
    
    @FXML
    public void a00(){
        int x=0,y=0;
        char z='a';
        if(pantano1.comprobarCasilla(x,y)==0){
            a00.setVisible(false);
        }
        pantano1.casillaTabla(pantano1, vida1, x, y);
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a01(){
        int x=0,y=1;
        char z='a';
        if(pantano1.comprobarCasilla(x,y)==0){
            a01.setVisible(false);
        }
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a02(){
        int x=0,y=2;
        char z='a';
        if(pantano1.comprobarCasilla(x,y)==0){
            a02.setVisible(false);
        }
        Casilla(x, y, z); 
    }
    
    @FXML
    public void a03(){
        int x=0,y=3;
        char z='a';
        if(pantano1.comprobarCasilla(x,y)==0){
            a03.setVisible(false);
        }
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a04(){
        int x=0,y=4;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a10(){
        int x=1,y=0;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a11(){
        int x=1,y=1;
        char z='a';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void a12(){
        int x=1,y=2;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a13(){
        int x=1,y=3;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a14(){
        int x=1,y=4;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a20(){
        int x=2,y=0;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a21(){
        int x=2,y=1;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a22(){
        int x=2,y=2;
        char z='a';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void a23(){
        int x=2,y=3;
        char z='a';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void a24(){
        int x=2,y=4;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a30(){
        int x=3,y=0;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a31(){
        int x=3,y=1;
        char z='a';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void a32(){
        int x=3,y=2;
        char z='a';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void a33(){
        int x=3,y=3;
        char z='a';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void a34(){
        int x=3,y=4;
        char z='a';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void a40(){
        int x=4,y=0;
        char z='a';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void a41(){
        int x=4,y=1;
        char z='a';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void a42(){
        int x=4,y=2;
        char z='a';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void a43(){
        int x=4,y=3;
        char z='a';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void a44(){
        int x=4,y=4;
        char z='a';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void b00(){
        int x=0,y=0;
        char z='b';
        Casilla(x, y, z);
         System.out.println("TABLA1"); 
    }
    
    @FXML
    public void b01(){
        int x=0,y=1;
        char z='b';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void b02(){
        int x=0,y=2;
        char z='b';
        Casilla(x, y, z);
    }
    
    @FXML
    public void b03(){
        int x=0,y=3;
        char z='b';
        Casilla(x, y, z);
    }
    
    @FXML
    public void b04(){
        int x=0,y=4;
        char z='b';
        Casilla(x, y, z);
    }
    
    @FXML
    public void b10(){
        int x=1,y=0;
        char z='b';
        Casilla(x, y, z);
    }
    
    @FXML
    public void b11(){
        int x=1,y=1;
        char z='b';
        Casilla(x, y, z);
    }
    
    @FXML
    public void b12(){
        int x=1,y=2;
        char z='b';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void b13(){
        int x=1,y=3;
        char z='b';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void b14(){
        int x=1,y=4;
        char z='b';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void b20(){
        int x=2,y=0;
        char z='b';
        Casilla(x, y, z);    
    }
    
    @FXML
    public void b21(){
        int x=2,y=1;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b22(){
        int x=2,y=2;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b23(){
        int x=2,y=3;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b24(){
        int x=2,y=4;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b30(){
        int x=3,y=0;
        char z='b';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void b31(){
        int x=3,y=1;
        char z='b';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void b32(){
        int x=3,y=2;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b33(){
        int x=3,y=3;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b34(){
        int x=3,y=4;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b40(){
        int x=4,y=0;
        char z='b';
        Casilla(x, y, z);  
    }
    
    @FXML
    public void b41(){
        int x=4,y=1;
        char z='b';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void b42(){
        int x=4,y=2;
        char z='b';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void b43(){
        int x=4,y=3;
        char z='b';
        Casilla(x, y, z);   
    }
    
    @FXML
    public void b44(){
        int x=4,y=4;
        char z='b';
        Casilla(x, y, z);  
    }
}
