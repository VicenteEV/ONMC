/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onmc;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class JuegoPCController implements Initializable {

     @FXML
    private boolean TurnoJugA = false;
    private boolean TurnoJugB = false;
    private int Turno;
    //private InicioController nom = new InicioController();
    
    @FXML
    private Button a00, a01, a02, a03, a04, a10, a11, a12, a13, a14, a20, a21, a22, a23, a24, a30, a31, a32, a33, a34, a40, a41, a42, a43, a44;
   
    @FXML
    private final Button[][] TABLA1= {{a00, a01, a02, a03, a04},{a10, a11, a12, a13, a14},{a20, a21, a22, a23, a24},{a30, a31, a32, a33, a34},{a40, a41, a42, a43, a44}};
   
    @FXML
    private Button b00, b01, b02, b03, b04, b10, b11, b12, b13, b14, b20, b21, b22, b23, b24, b30, b31, b32, b33, b34, b40, b41, b42, b43, b44;
   
    @FXML
    public final Button[] TABLA2 = {b00, b01, b02, b03, b04,b10, b11, b12, b13, b14,b20, b21, b22, b23, b24,b30, b31, b32, b33, b34,b40, b41, b42, b43, b44};
    
    @FXML
    private tablajuego pantano1, pantano2;
  
    @FXML
    private Button config, salir;
    
    @FXML
    private ProgressBar vida1, vida2;
   
    @FXML
    private Label puntoA, puntoB, turnoA, turnoB, usuarioA, usuarioB;
    @FXML
    String [] nombre = {"Jose", "Dani", "Monica", "Ana", "Mila"};
    
    @FXML
    public void initialize(){
        
    }
    
    
    
    @FXML
    public void CambioTurno(){
        
        if(TurnoJugA==true){
            TurnoJugB=true;
            TurnoJugA=false;
        }else {
            TurnoJugB=false;
            TurnoJugA=true;
        }
    }
    
    @FXML
    public void btnSalir(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Perfil.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
   
    //BOTONES TABLA

    
    @FXML
    public void a00(ActionEvent Event) throws Exception{
        int x=0,y=0;
        
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a00,pantano1,vida1,x,y) != 1)
            CambioTurno();
        }
    }
    
    @FXML
    public void a01(ActionEvent Event) throws Exception{
        int x=0,y=1;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a01,pantano1,vida1,x,y) != 1)
            CambioTurno();
        }  
    }
    
    @FXML
    public void a02(ActionEvent Event) throws Exception{
        int x=0,y=2;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a02,pantano1,vida1,x,y) != 1)
            CambioTurno();
        }
    }
    
    @FXML
    public void a03(ActionEvent Event) throws Exception{
        int x=0,y=3;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a03,pantano1,vida1,x,y) != 1)
            CambioTurno();
        }
    }
    
    @FXML
    public void a04(ActionEvent Event) throws Exception{
        int x=0,y=4;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a04,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a10(ActionEvent Event) throws Exception{
        int x=1,y=0;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a10,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a11(ActionEvent Event) throws Exception{
        int x=1,y=1;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a11,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a12(ActionEvent Event) throws Exception{
        int x=1,y=2;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a12,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a13(ActionEvent Event) throws Exception{
        int x=1,y=3;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a13,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a14(ActionEvent Event) throws Exception{
        int x=1,y=4;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a14,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a20(ActionEvent Event) throws Exception{
        int x=2,y=0;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a20,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a21(ActionEvent Event) throws Exception{
        int x=2,y=1;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a21,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a22(ActionEvent Event) throws Exception{
        int x=2,y=2;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a22,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a23(ActionEvent Event) throws Exception{
        int x=2,y=3;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a23,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a24(ActionEvent Event) throws Exception{
        int x=2,y=4;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a24,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a30(ActionEvent Event) throws Exception{
        int x=3,y=0;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a30,pantano1,vida1,x,y) != 1)
            CambioTurno();
        }
    }
    
    @FXML
    public void a31(ActionEvent Event) throws Exception{
        int x=3,y=1;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a31,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a32(ActionEvent Event) throws Exception{
        int x=3,y=2;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a32,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a33(ActionEvent Event) throws Exception{
        int x=3,y=3;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a33,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a34(ActionEvent Event) throws Exception{
        int x=3,y=4;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a34,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a40(ActionEvent Event) throws Exception{
        int x=4,y=0;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a40,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a41(ActionEvent Event) throws Exception{
        int x=4,y=1;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a41,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a42(ActionEvent Event) throws Exception{
        int x=4,y=2;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a42,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a43(ActionEvent Event) throws Exception{
        int x=4,y=3;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a43,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }
    
    @FXML
    public void a44(ActionEvent Event) throws Exception{
        int x=4,y=4;
        if(TurnoJugA==true){
            if(pantano1.Casilla(puntoA,turnoA,a44,pantano1,vida1,x,y) != 1)
            CambioTurno();
        } 
    }

    @FXML
    public void b00(ActionEvent Event) throws Exception{
        int x=0,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b00,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b01(ActionEvent Event) throws Exception{
        int x=0,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b01,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b02(ActionEvent Event) throws Exception{
        int x=0,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b02,pantano2,vida2,x,y) != 1)  
            CambioTurno();
        } 
    }
    
    @FXML
    public void b03(ActionEvent Event) throws Exception{
        int x=0,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b03,pantano2,vida2,x,y) != 1)  
            CambioTurno();
        }
    }
    
    @FXML
    public void b04(ActionEvent Event) throws Exception{
        int x=0,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b04,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        } 
    }
    
    @FXML
    public void b10(ActionEvent Event) throws Exception{
        int x=1,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b10,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        } 
    }
    
    @FXML
    public void b11(ActionEvent Event) throws Exception{
        int x=1,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b11,pantano2,vida2,x,y) != 1)  
            CambioTurno();
        }
    }
    
    @FXML
    public void b12(ActionEvent Event) throws Exception{
        int x=1,y=2;
       if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b12,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b13(ActionEvent Event) throws Exception{
        int x=1,y=3;
       if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b13,pantano2,vida2,x,y) != 1)  
            CambioTurno();
        }
    }
    
    @FXML
    public void b14(ActionEvent Event) throws Exception{
        int x=1,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b14,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        } 
    }
    
    @FXML
    public void b20(ActionEvent Event) throws Exception{
        int x=2,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b20,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b21(ActionEvent Event) throws Exception{
        int x=2,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b21,pantano2,vida2,x,y) != 1)  
            CambioTurno();
        }
    }
    
    @FXML
    public void b22(ActionEvent Event) throws Exception{
        int x=2,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b22,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b23(ActionEvent Event) throws Exception{
        int x=2,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b23,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b24(ActionEvent Event) throws Exception{
        int x=2,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b24,pantano2,vida2,x,y) != 1)  
            CambioTurno();
        }
    }
    
    @FXML
    public void b30(ActionEvent Event) throws Exception{
        int x=3,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b30,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b31(ActionEvent Event) throws Exception{
        int x=3,y=1;
       if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b31,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        } 
    }
    
    @FXML
    public void b32(ActionEvent Event) throws Exception{
        int x=3,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b32,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        } 
    }
    
    @FXML
    public void b33(ActionEvent Event) throws Exception{
        int x=3,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b33,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b34(ActionEvent Event) throws Exception{
        int x=3,y=4;
        if(TurnoJugB==true){
           if(pantano2.Casilla(puntoB,turnoB,b34,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b40(ActionEvent Event) throws Exception{
        int x=4,y=0;
          if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b40,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        } 
    }
    
    @FXML
    public void b41(ActionEvent Event) throws Exception{
        int x=4,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b41,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b42(ActionEvent Event) throws Exception{
        int x=4,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b42,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        }
    }
    
    @FXML
    public void b43(ActionEvent Event) throws Exception{
        int x=4,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b43,pantano2,vida2,x,y) != 1) 
            CambioTurno();
        } 
    }
    
    @FXML
    public void b44(ActionEvent Event) throws Exception{
        int x=4,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b44,pantano2,vida2,x,y) != 1)  
            CambioTurno();
        } 
    }
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rnd=new Random();
        
        Turno = rnd.nextInt(2);
       
        pantano1=new tablajuego();
        pantano1.pantanoPersonas();
        pantano1.pantanoCazadores();
        turnoA.setText(pantano1.getTurno()+"");
        puntoA.setText(pantano1.getPt()+"");
        usuarioA.setText(InicioController.user);
        
        pantano2=new tablajuego();
        pantano2.pantanoPersonas();
        pantano2.pantanoCazadores();
        turnoB.setText(pantano2.getTurno()+"");
        puntoB.setText(pantano2.getPt()+"");
        usuarioB.setText(nombre[rnd.nextInt(5)]);
        //pantano2.jugadorBot(TABLA2);
        
        
        if(Turno==1){
            TurnoJugA=true;
            TurnoJugB=false;
        }else {
            TurnoJugA=false;
            TurnoJugB=true;
        }  
        
    }    
    
}
