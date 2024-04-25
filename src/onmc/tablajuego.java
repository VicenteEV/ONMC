
package onmc;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;




public class tablajuego {
    
    @FXML
    private Label vUsuario;
    
    private boolean victoria = false;
    
    public final int[][] TABLA=new int [5][5];
    private final int PS=7,CZ=3;
    int pt=0,turno=15;
    Gestor_conexion_POSTGRE conection = new Gestor_conexion_POSTGRE("juego", true);

    tablajuego(){
    }
    public int getPt() {
        return pt;
    }
    public int getTurno() {
        return turno;
    }

    public boolean isVictoria() {
        return victoria;
    }
    
    
    
    public void pantanoPersonas(){
        Random rnd=new Random();
        int contadorp=0,contadorc=0;

        for (int i=0; i<=TABLA.length; i++){                //Bañistas aleatorios
            for (int j=0; j<=TABLA[0].length; j++){  
                int x=rnd.nextInt(TABLA.length);
                int y=rnd.nextInt(TABLA[0].length);
                if(contadorp < PS && TABLA[x][y]==0){
                    TABLA[x][y]=1;
                    contadorp++;
                }
            }
        }
        for (int i=0; i<TABLA.length; i++){                 //Cazadores aleatorios
            for (int j=0; j<=TABLA[0].length; j++){     
                int x=rnd.nextInt(TABLA.length);
                int y=rnd.nextInt(TABLA[0].length);
                if(contadorc < CZ){
                    if (TABLA[x][y]!=1){
                        TABLA[x][y]=2;
                        contadorc++;
                    }
                }
            }
        }
        
        for (int i=0; i<TABLA.length; i++){                 //Cazadores aleatorios
            for (int j=0; j<TABLA.length; j++){
                System.out.print(TABLA[i][j]);
            }
            System.out.println();
        }
    }

    public int comprobarCasilla(int x, int y){
        int resultado = 0;
        if (TABLA[x][y]==0){resultado=0;}
        else if (TABLA[x][y]==1){resultado=1;}
        else if (TABLA[x][y]==2){resultado=2;}
        return resultado; 
    }
    
    public double barraVida(ProgressBar vida, int x, int y){
      
        if (comprobarCasilla(x,y) == 2){
            return vida.getProgress()-0.33333333333;
        }
        return vida.getProgress();
    }
    
    public int Casilla(Label puntos, Label turnos, Button btn, tablajuego pantano, ProgressBar vida, int x, int y) throws Exception{
        Random rnd=new Random ();    
        int temp = 0;
        
        switch(pantano.comprobarCasilla(x,y)){
            case 0:{                                 
                btn.setVisible(false);
                turno--;
                btn.setDisable(true);
                break;
            }
            case 1:{                                 
                pt=pt+150;
                switch(rnd.nextInt(3)){
                    case 0:
                        btn.setStyle("-fx-background-image: url(\"/img/bañistaA.png\");");
                        break;
                    case 1:
                        btn.setStyle("-fx-background-image: url(\"/img/bañistaB.png\");");
                        break;
                    case 2:
                        btn.setStyle("-fx-background-image: url(\"/img/bañistaC.png\");");
                        break;
                }
                temp = 1;
                btn.setDisable(true);
                break;
            }
            case 2:{                                
                pt=pt-50;
                btn.setDisable(true);
                turno--;
                btn.setStyle("-fx-background-image: url(\"/img/newcaza2.png\");");                               
                break;
            }
        }
        vida.setProgress(barraVida(vida, x, y));
        puntos.setText(pt + "");
        finalizarPartida(pt, vida, turno, pantano);
        turnos.setText(turno + "");
        //Thread.sleep(1000);  
        
        return temp;
    }
    
    public void CambioVictoria () throws Exception{
        
        //String consulta = "update partida set victoria = true";
        //Bd.consultaModificacion(conection, consulta);
        //vUsuario.setText(InicioController.user);
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Victoria.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    public void finalizarPartida (int x, ProgressBar vida, int turno, tablajuego p) throws Exception{
        
        if (vida.getProgress() < 0.33333333333) {
            CambioVictoria();
            String consulta = "update partida set victoria = false";
            Bd.consultaModificacion(conection, consulta);
        }
        if (x >= 950) {
            victoria = true;
            CambioVictoria();
        } 
        if(turno==0){
            
            CambioVictoria();
        }
    }   
}
