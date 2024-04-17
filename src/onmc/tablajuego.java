
package onmc;
import java.util.Random;
import javafx.scene.control.ProgressBar;


public class tablajuego {
    public final int[][] TABLA=new int [5][5];
    private final int PS=7;
    private final int CZ=1;
    


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
    
    public void restaurarCasilla(int x, int y){
        TABLA[x][y]=0;
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
    
    public int puntuacion(int x, int y, int puntuacion){

        if (comprobarCasilla(x,y)==1){
            puntuacion=puntuacion+235;
        }
        if (comprobarCasilla(x,y)==2){
            puntuacion=puntuacion -50;
        }
        
        return puntuacion;
    }
    
    public double barraVida(ProgressBar vida, int x, int y){
      
        if (comprobarCasilla(x,y) == 2){
            restaurarCasilla(x,y);
            pantanoCazadores();

            return vida.getProgress()-0.33333333333;
        }
        return vida.getProgress();
    }
    
    public void casillaTabla(tablajuego pantano, ProgressBar vida, int x, int y){
        
            switch(pantano.comprobarCasilla(x,y)){
                case 0:{                                  //Desaparece el boton
                    System.out.println("Agua"); 
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
            vida.setProgress(barraVida(vida,x,y));         
        
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
