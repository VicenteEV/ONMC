
package onmc;
import java.util.Random;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class tablajuego {
    public final int[][] TABLA=new int [5][5];
    private final int PS=7;
    private final int CZ=3;
    int pt=0,turno=15;

    public int getPt() {
        return pt;
    }

    public int getTurno() {
        return turno;
    }
    
    
    tablajuego(){
    }
    
    public void pantanoPersonas(){
        Random rnd=new Random();
        int contador=0;

        for (int i=0; i<=TABLA.length; i++){                //Bañistas aleatorios
            for (int j=0; j<=TABLA[0].length; j++){  
                int x=rnd.nextInt(TABLA.length);
                int y=rnd.nextInt(TABLA[0].length);
                if(contador < PS && TABLA[x][y]==0){
                    TABLA[x][y]=1;
                    contador++;
                }
            }
        }
    }
    
    public void pantanoCazadores(){
        Random rnd=new Random();
        int contador=0;

        for (int i=0; i<TABLA.length; i++){                //Cazador aleatorios
            for (int j=0; j<=TABLA[0].length; j++){     
                int x=rnd.nextInt(TABLA.length);
                int y=rnd.nextInt(TABLA[0].length);
                if(contador < CZ){
                    if (TABLA[x][y]!=1){
                        TABLA[x][y]=2;
                        contador++;
                    }
                }
            }
        }
        
        for (int i = 0; i < TABLA.length; i++) {
            for (int j = 0; j < TABLA[0].length; j++) {
                System.out.print(TABLA[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public int comprobarCasilla(int x, int y){
        int resultado = 0;
        if (TABLA[x][y]==0){
            resultado=0;
        }
        else if (TABLA[x][y]==1){
            resultado=1;
        }
        else if (TABLA[x][y]==2){
            resultado=2;
        }
        return resultado; 
    }
    
    public double barraVida(ProgressBar vida, int x, int y){
      
        if (comprobarCasilla(x,y) == 2){
            return vida.getProgress()-0.33333333333;
        }
        return vida.getProgress();
    }
    
    public void Casilla(Label puntos,Label turnos, Button btn, tablajuego pantano, ProgressBar vida, int x, int y) throws Exception{
            
        switch(pantano.comprobarCasilla(x,y)){
            case 0:{                                 
                btn.setVisible(false);
                turno--;
                break;
            }
            case 1:{                                 
                pt=pt+150;
                turno--;
                btn.setStyle("-fx-background-image: url(\"/img/personita1.png\");");
                break;
            }
            case 2:{                                
                pt=pt-50;
                turno--;
                btn.setStyle("-fx-background-image: url(\"/img/caza.png\");");
                break;
            }
        }
        vida.setProgress(barraVida(vida, x, y));
        puntos.setText(pt + "");
        finalizarPartida(pt, vida, turno);
        turnos.setText(turno + "");
    }
    
    public void finalizarPartida (int x, ProgressBar vida, int turno) throws Exception{
        
        if (vida.getProgress() < 0.33333333333) {
            System.out.println("Fin partida vida");
            Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Victoria.fxml"));
            ONMC.stage.getScene().setRoot(loader);
            ONMC.stage.show();
        }
        if (x >= 350) {
            System.out.println("Fin partida pt");
            Platform.setImplicitExit(true);
            Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Victoria.fxml"));
            ONMC.stage.getScene().setRoot(loader);
            ONMC.stage.show();
        } 
        if(turno==0){
            System.out.println("Fin partida turnos");
            Platform.setImplicitExit(true);
            Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Victoria.fxml"));
            ONMC.stage.getScene().setRoot(loader);
            ONMC.stage.show();
        }
    }
}
