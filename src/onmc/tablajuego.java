
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
    /*
    public void Casilla(tablajuego pantano, ProgressBar vida, int x, int y){
      
        if(z=='a'){
            Button actual = TABLA1[x][y];
            switch(pantano.comprobarCasilla(x,y)){
                case 0:{                                  //Desaparece el boton
                    System.out.println("Agua"); 
                    .setVisible(false);
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
            pt=pantano.puntuacion(x, y, pt1);
            puntoA.setText(pt1 + " pt.");
            vida1.setProgress(barraVida(vida1,x,y,z));     
        }
        if(z=='b'){
            Button actual = TABLA2[x][y];
            switch(pantano1.comprobarCasilla(x,y)){
                case 0:{                                  //Desaparece el boton
                    System.out.println("Agua"); 
                    actual.setVisible(false);
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
            pt2=pantano2.puntuacion(x, y, pt2);
            puntoB.setText(pt2 + " pt.");
            vida2.setProgress(barraVida(vida2,x,y,z));     
        }
    }*/
   
}
