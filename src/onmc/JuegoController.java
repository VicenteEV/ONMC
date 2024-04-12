
package onmc;

import java.awt.event.MouseEvent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JuegoController {
    
    @FXML
    private Button config, salir;
    private GridPane tablero;
    
    @FXML
    public void btn1(ActionEvent event) {
       
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Inicio.fxml"));
            Stage stage = (Stage) salir.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
   
    public void b00(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn0=new casillatabla();
        
        System.out.println(btn0.comprobarCasilla(x, y));
    }
    public void b01(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn1=new casillatabla();
        
        System.out.println(btn1.comprobarCasilla(x, y));
    }
    public void b02(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn2=new casillatabla();
        
        System.out.println(btn2.comprobarCasilla(x, y));
    }
    public void b03(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn3=new casillatabla();
        
        System.out.println(btn3.comprobarCasilla(x, y));
    }
    public void b04(ActionEvent event){
        int x=0,y=0;
       
        casillatabla btn4=new casillatabla();
        
        System.out.println(btn4.comprobarCasilla(x, y));
    }
    public void b10(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn5=new casillatabla();
        
        System.out.println(btn5.comprobarCasilla(x, y));
    }
    public void b11(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn6=new casillatabla();
        
        System.out.println(btn6.comprobarCasilla(x, y));
    }
    public void b12(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn7=new casillatabla();
        
        System.out.println(btn7.comprobarCasilla(x, y));
    }
    public void b13(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn8=new casillatabla();
        
        System.out.println(btn8.comprobarCasilla(x, y));
    }
    public void b14(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn9=new casillatabla();
        
        System.out.println(btn9.comprobarCasilla(x, y));
    }
    public void b20(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn10=new casillatabla();
        
        System.out.println(btn10.comprobarCasilla(x, y));
    }
    public void b21(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn11=new casillatabla();
        
        System.out.println(btn11.comprobarCasilla(x, y));
    }
    public void b22(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn12=new casillatabla();
        
        System.out.println(btn12.comprobarCasilla(x, y));
    }
    public void b23(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn13=new casillatabla();
        
        System.out.println(btn13.comprobarCasilla(x, y));
    }
    public void b24(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn14=new casillatabla();
        
        System.out.println(btn14.comprobarCasilla(x, y));
    }
    public void b30(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn15=new casillatabla();
        
        System.out.println(btn15.comprobarCasilla(x, y));
    }
    public void b31(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn16=new casillatabla();
        
        System.out.println(btn16.comprobarCasilla(x, y));
    }
    public void b32(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn17=new casillatabla();
        
        System.out.println(btn17.comprobarCasilla(x, y));
    }
    public void b33(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn18=new casillatabla();
        
        System.out.println(btn18.comprobarCasilla(x, y));
    }
    public void b34(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn19=new casillatabla();
        
        System.out.println(btn19.comprobarCasilla(x, y));
    }
    public void b40(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn20=new casillatabla();
        
        System.out.println(btn20.comprobarCasilla(x, y));
    }
    public void b41(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn21=new casillatabla();
        
        System.out.println(btn21.comprobarCasilla(x, y));
    }
    public void b42(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn22=new casillatabla();
        
        System.out.println(btn22.comprobarCasilla(x, y));
    }
    public void b43(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn23=new casillatabla();
        
        System.out.println(btn23.comprobarCasilla(x, y));
    }
    public void b44(ActionEvent event){
        int x=0,y=0;
        
        casillatabla btn24=new casillatabla();
        
        System.out.println(btn24.comprobarCasilla(x, y));
    }
    
}
