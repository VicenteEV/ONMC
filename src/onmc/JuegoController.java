
package onmc;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;

public class JuegoController {
    
    @FXML
    Slider volumen;
    
    @FXML
    ToggleButton plst;
    
    @FXML
    audio audioJuego;
    
    @FXML
    private boolean TurnoJugA = false, TurnoJugB = false;
    
    @FXML
    private int Turno;
    
    @FXML
    private Button a00, a01, a02, a03, a04, a10, a11, a12, a13, a14, a20, a21, a22, a23, a24, a30, a31, a32, a33, a34, a40, a41, a42, a43, a44;
   
    @FXML
    private Button b00, b01, b02, b03, b04, b10, b11, b12, b13, b14, b20, b21, b22, b23, b24, b30, b31, b32, b33, b34, b40, b41, b42, b43, b44;
    
    @FXML
    private tablajuego pantano1, pantano2;
    
    @FXML
    public Button t1 [], t2 [];
    
    @FXML
    private ProgressBar vida1, vida2;
   
    @FXML
    private Label puntoA, puntoB, turnoA, turnoB, usuarioA, usuarioB, idPartida;
    
    @FXML
    String [] nombre = {"Jose", "Dani", "Monica", "Ana", "Mila"};
       
    @FXML
    public void initialize(){
        
        audioJuego=new audio(volumen, plst);
        audioJuego.musicaAudio2();
        
        Random rnd=new Random();
        Turno = rnd.nextInt(2);
       
        pantano1=new tablajuego();
        pantano1.pantanoPersonas();
        turnoA.setText(pantano1.getTurno()+"");
        puntoA.setText(pantano1.getPt()+"");
        usuarioA.setText(InicioController.user);
        
        pantano2=new tablajuego();
        pantano2.pantanoPersonas();
        turnoB.setText(pantano2.getTurno()+"");
        puntoB.setText(pantano2.getPt()+"");
        usuarioB.setText(nombre[rnd.nextInt(5)]);
        
        Button [] temp1 = {a00, a01, a02, a03, a04,a10, a11, a12, a13, a14,a20, a21, a22, a23, a24,a30, a31, a32, a33, a34,a40, a41, a42, a43, a44};
        Button [] temp2 = {b00, b01, b02, b03, b04,b10, b11, b12, b13, b14,b20, b21, b22, b23, b24,b30, b31, b32, b33, b34,b40, b41, b42, b43, b44};
        t1=temp1;
        t2=temp2;
     
        idPartida.setText("Partida: " + InicioController.idPar);
        
        if(Turno==1){
            TurnoJugA=true;
            TurnoJugB=false;
        }
        else {
            TurnoJugA=false;
            TurnoJugB=true;
        }  
    }
    
    @FXML
    public void CambioTurno(){
        if(TurnoJugA==true){
            TurnoJugB=true;
            TurnoJugA=false;
        }
        else {
            TurnoJugB=false;
            TurnoJugA=true;
        }
    }
    
    @FXML
    public void btnSalir(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Perfil.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
        audioJuego.musicaOff2();
    }
   
    
    
    //BOTONES TABLA A
    public void ases(int x, int y) throws Exception{
        String temp = "a" + x + y;
        
        for (int i = 0; i < t1.length; i++) {
            if(temp.equals(t1[i].getId())){
                if(TurnoJugA==true){
                    if(pantano1.Casilla(puntoA,turnoA,t1[i],pantano1,vida1,x,y, audioJuego) != 1){
                        CambioTurno();
                    }
                }                       
            }
        }
    }
    
    @FXML
    public void a00(ActionEvent Event) throws Exception {ases(0,0);}
    
    @FXML
    public void a01(ActionEvent Event) throws Exception {ases(0,1);}
    
    @FXML
    public void a02(ActionEvent Event) throws Exception {ases(0,2);}
    
    @FXML
    public void a03(ActionEvent Event) throws Exception {ases(0,3);}
    
    @FXML
    public void a04(ActionEvent Event) throws Exception {ases(0,4);}
    
    @FXML
    public void a10(ActionEvent Event) throws Exception {ases(1,0);}
    
    @FXML
    public void a11(ActionEvent Event) throws Exception {ases(1,1);}
    
    @FXML
    public void a12(ActionEvent Event) throws Exception {ases(1,2);}
    
    @FXML
    public void a13(ActionEvent Event) throws Exception {ases(1,3);}
    
    @FXML
    public void a14(ActionEvent Event) throws Exception {ases(1,4);}
    
    @FXML
    public void a20(ActionEvent Event) throws Exception {ases(2,0);}
    
    @FXML
    public void a21(ActionEvent Event) throws Exception {ases(2,1);}
    
    @FXML
    public void a22(ActionEvent Event) throws Exception {ases(2,2);}
    
    @FXML
    public void a23(ActionEvent Event) throws Exception {ases(2,3);}
    
    @FXML
    public void a24(ActionEvent Event) throws Exception {ases(2,4);}
    
    @FXML
    public void a30(ActionEvent Event) throws Exception {ases(3,0);}
    
    @FXML
    public void a31(ActionEvent Event) throws Exception {ases(3,1);}
    
    @FXML
    public void a32(ActionEvent Event) throws Exception {ases(3,2);}
    
    @FXML
    public void a33(ActionEvent Event) throws Exception {ases(3,3);}
    
    @FXML
    public void a34(ActionEvent Event) throws Exception {ases(3,4);}
    
    @FXML
    public void a40(ActionEvent Event) throws Exception {ases(4,0);}
    
    @FXML
    public void a41(ActionEvent Event) throws Exception {ases(4,1);}
    
    @FXML
    public void a42(ActionEvent Event) throws Exception {ases(4,2);}
    
    @FXML
    public void a43(ActionEvent Event) throws Exception {ases(4,3);}
    
    @FXML
    public void a44(ActionEvent Event) throws Exception {ases(4,4);}
    
    
    
    //BOTONES TABLA B
    public void bses(int x, int y) throws Exception{
        String temp = "b" + x + y;
        
        for (int i = 0; i < t2.length; i++) {
            if(temp.equals(t2[i].getId())){
                if(TurnoJugB==true){
                    if(pantano2.Casilla(puntoB,turnoB,t2[i],pantano2,vida2,x,y, audioJuego) != 1){
                        CambioTurno();
                    }
                }                       
            }
        }
    }

    @FXML
    public void b00(ActionEvent Event) throws Exception {bses(0, 0);}
    
    @FXML
    public void b01(ActionEvent Event) throws Exception {bses(0, 1);}
    
    @FXML
    public void b02(ActionEvent Event) throws Exception {bses(0, 2);}
    
    @FXML
    public void b03(ActionEvent Event) throws Exception {bses(0, 3);}
    
    @FXML
    public void b04(ActionEvent Event) throws Exception {bses(0, 4);}
    
    @FXML
    public void b10(ActionEvent Event) throws Exception {bses(1, 0);}
    
    @FXML
    public void b11(ActionEvent Event) throws Exception {bses(1, 1);}
    
    @FXML
    public void b12(ActionEvent Event) throws Exception {bses(1, 2);}
    
    @FXML
    public void b13(ActionEvent Event) throws Exception {bses(1, 3);}
    
    @FXML
    public void b14(ActionEvent Event) throws Exception {bses(1, 4);}
    
    @FXML
    public void b20(ActionEvent Event) throws Exception {bses(2, 0);}
    
    @FXML
    public void b21(ActionEvent Event) throws Exception {bses(2, 1);}
    
    @FXML
    public void b22(ActionEvent Event) throws Exception {bses(2, 2);}
    
    @FXML
    public void b23(ActionEvent Event) throws Exception {bses(2, 3);}
    
    @FXML
    public void b24(ActionEvent Event) throws Exception {bses(2, 4);}
    
    @FXML
    public void b30(ActionEvent Event) throws Exception {bses(3, 0);}
    
    @FXML
    public void b31(ActionEvent Event) throws Exception {bses(3, 1);}
    
    @FXML
    public void b32(ActionEvent Event) throws Exception {bses(3, 2);}
    
    @FXML
    public void b33(ActionEvent Event) throws Exception {bses(3, 3);}
    
    @FXML
    public void b34(ActionEvent Event) throws Exception {bses(3, 4);}
    
    @FXML
    public void b40(ActionEvent Event) throws Exception {bses(4, 0);}
    
    @FXML
    public void b41(ActionEvent Event) throws Exception {bses(4, 1);}
    
    @FXML
    public void b42(ActionEvent Event) throws Exception {bses(4, 2);}
    
    @FXML
    public void b43(ActionEvent Event) throws Exception {bses(4, 3);}
    
    @FXML
    public void b44(ActionEvent Event) throws Exception {bses(4, 4);}
}