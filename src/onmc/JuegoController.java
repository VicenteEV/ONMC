
package onmc;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    public void initialize(){
        pantano1=new tablajuego();
        pantano1.pantanoPersonas();
        pantano1.pantanoCazadores();
        pantano2=new tablajuego();
        pantano2.pantanoPersonas();
        pantano2.pantanoCazadores();
    }
   @FXML
    public void btnConfig(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Inicio.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    @FXML
    public void btnSalir(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Perfil.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
   
    //BOTONES TABLA
    
    @FXML
    public void a00(ActionEvent Event){
        int x=0,y=0;
        pantano1.Casilla(puntoA,a00,pantano1,vida1,x,y);
    }
    
    @FXML
    public void a01(ActionEvent Event){
        int x=0,y=1;
        pantano1.Casilla(puntoA,a01,pantano1,vida1,x,y);  
    }
    
    @FXML
    public void a02(ActionEvent Event){
        int x=0,y=2;
        pantano1.Casilla(puntoA,a02,pantano1,vida1,x,y);
    }
    
    @FXML
    public void a03(ActionEvent Event){
        int x=0,y=3;
        pantano1.Casilla(puntoA,a03,pantano1,vida1,x,y);
    }
    
    @FXML
    public void a04(ActionEvent Event){
        int x=0,y=4;
        pantano1.Casilla(puntoA,a04,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a10(ActionEvent Event){
        int x=1,y=0;
        pantano1.Casilla(puntoA,a10,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a11(ActionEvent Event){
        int x=1,y=1;
        pantano1.Casilla(puntoA,a11,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a12(ActionEvent Event){
        int x=1,y=2;
        pantano1.Casilla(puntoA,a12,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a13(ActionEvent Event){
        int x=1,y=3;
        pantano1.Casilla(puntoA,a13,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a14(ActionEvent Event){
        int x=1,y=4;
        pantano1.Casilla(puntoA,a14,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a20(ActionEvent Event){
        int x=2,y=0;
        pantano1.Casilla(puntoA,a20,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a21(ActionEvent Event){
        int x=2,y=1;
        pantano1.Casilla(puntoA,a21,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a22(ActionEvent Event){
        int x=2,y=2;
        pantano1.Casilla(puntoA,a22,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a23(ActionEvent Event){
        int x=2,y=3;
        pantano1.Casilla(puntoA,a23,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a24(ActionEvent Event){
        int x=2,y=4;
        pantano1.Casilla(puntoA,a24,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a30(ActionEvent Event){
        int x=3,y=0;
        pantano1.Casilla(puntoA,a30,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a31(ActionEvent Event){
        int x=3,y=1;
        pantano1.Casilla(puntoA,a31,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a32(ActionEvent Event){
        int x=3,y=2;
        pantano1.Casilla(puntoA,a32,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a33(ActionEvent Event){
        int x=3,y=3;
        pantano1.Casilla(puntoA,a33,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a34(ActionEvent Event){
        int x=3,y=4;
        pantano1.Casilla(puntoA,a34,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a40(ActionEvent Event){
        int x=4,y=0;
        pantano1.Casilla(puntoA,a40,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a41(ActionEvent Event){
        int x=4,y=1;
        pantano1.Casilla(puntoA,a41,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a42(ActionEvent Event){
        int x=4,y=2;
        pantano1.Casilla(puntoA,a42,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a43(ActionEvent Event){
        int x=4,y=3;
        pantano1.Casilla(puntoA,a43,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void a44(ActionEvent Event){
        int x=4,y=4;
        pantano1.Casilla(puntoA,a44,pantano1,vida1,x,y); 
    }
    
    @FXML
    public void b00(ActionEvent Event){
        int x=0,y=0;
        pantano2.Casilla(puntoB,b00,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b01(ActionEvent Event){
        int x=0,y=1;
        pantano2.Casilla(puntoB,b01,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b02(ActionEvent Event){
        int x=0,y=2;
        pantano2.Casilla(puntoB,b02,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b03(ActionEvent Event){
        int x=0,y=3;
        pantano2.Casilla(puntoB,b03,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b04(ActionEvent Event){
        int x=0,y=4;
        pantano2.Casilla(puntoB,b04,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b10(ActionEvent Event){
        int x=1,y=0;
        pantano2.Casilla(puntoB,b10,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b11(ActionEvent Event){
        int x=1,y=1;
        pantano2.Casilla(puntoB,b11,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b12(ActionEvent Event){
        int x=1,y=2;
        pantano2.Casilla(puntoB,b12,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b13(ActionEvent Event){
        int x=1,y=3;
        pantano2.Casilla(puntoB,b13,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b14(ActionEvent Event){
        int x=1,y=4;
        pantano2.Casilla(puntoB,b14,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b20(ActionEvent Event){
        int x=2,y=0;
        pantano2.Casilla(puntoB,b20,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b21(ActionEvent Event){
        int x=2,y=1;
        pantano2.Casilla(puntoB,b21,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b22(ActionEvent Event){
        int x=2,y=2;
        pantano2.Casilla(puntoB,b22,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b23(ActionEvent Event){
        int x=2,y=3;
        pantano2.Casilla(puntoB,b23,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b24(ActionEvent Event){
        int x=2,y=4;
        pantano2.Casilla(puntoB,b24,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b30(ActionEvent Event){
        int x=3,y=0;
        pantano2.Casilla(puntoB,b30,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b31(ActionEvent Event){
        int x=3,y=1;
        pantano2.Casilla(puntoB,b31,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b32(ActionEvent Event){
        int x=3,y=2;
        pantano2.Casilla(puntoB,b32,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b33(ActionEvent Event){
        int x=3,y=3;
        pantano2.Casilla(puntoB,b33,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b34(ActionEvent Event){
        int x=3,y=4;
        pantano2.Casilla(puntoB,b34,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b40(ActionEvent Event){
        int x=4,y=0;
        pantano2.Casilla(puntoB,b40,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b41(ActionEvent Event){
        int x=4,y=1;
        pantano2.Casilla(puntoB,b41,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b42(ActionEvent Event){
        int x=4,y=2;
        pantano2.Casilla(puntoB,b42,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b43(ActionEvent Event){
        int x=4,y=3;
        pantano2.Casilla(puntoB,b43,pantano2,vida2,x,y); 
    }
    
    @FXML
    public void b44(ActionEvent Event){
        int x=4,y=4;
        pantano2.Casilla(puntoB,b44,pantano2,vida2,x,y); 
    }
}