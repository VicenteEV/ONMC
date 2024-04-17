
package onmc;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class tablajuego {
    public final int[][] TABLA=new int [5][5];
    private final int PS=7;
    private final int CZ=3;
    int pt;
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
    
    public void Casilla(Label lb, Button btn, tablajuego pantano, ProgressBar vida, int x, int y){
            
            switch(pantano.comprobarCasilla(x,y)){
                case 0:{                                  //Desaparece el boton
                        System.out.println("Agua");
                        btn.setVisible(false);
                        break;
                }
                case 1:{                                 //Cambia el boton por una imagen de las mismas dimensiones
                        System.out.println("Bañista");
                        pt=pt+150;
                        btn.setText("");
                        btn.setStyle("-fx-background-image: url(\"/img/personita1.png\");");
                        break;
                }
                case 2:{                                //Cambia el boton por una imagen de las mismas dimensiones
                   System.out.println("Cazador");
                   pt=pt-50;
                        btn.setText("");
                        btn.setStyle("-fx-background-image: url(\"/img/caza.png\");");
                        break;
                }
            }
            vida.setProgress(barraVida(vida, x, y));
            lb.setText(pt +" pt.");
    }
    
    public void finalizarPartida (int x, ProgressBar vida){
        
        if (vida.getProgress() < 0.33333333333) {
            System.out.println("Fin partida");
        }
        if (x >= 1000) {
            System.out.println("Fin partida");
        }

        
        
    }
   
}
