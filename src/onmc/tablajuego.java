
package onmc;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;




public class tablajuego {
    public final int[][] TABLA=new int [5][5];
    private final int PS=7;
    private final int CZ=3;
    int pt=0,turno=15;
    Gestor_conexion_POSTGRE conection = new Gestor_conexion_POSTGRE("juego", true);

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
    
    public int Casilla(Label puntos,Label turnos, Button btn, tablajuego pantano, ProgressBar vida, int x, int y) throws Exception{
        Random rnd=new Random ();    
        int temp = 0;
        
            switch(pantano.comprobarCasilla(x,y)){
                case 0:{                                 
                    btn.setVisible(false);
                    turno--;
                    break;
                }
                case 1:{                                 
                    pt=pt+150;
                    switch(rnd.nextInt(3)){
                        case 0:
                            btn.setStyle("-fx-background-image: url(\"/img/bañista1.png\");");
                            System.out.println("AAAAAAaa");
                            break;
                        case 1:
                            btn.setStyle("-fx-background-image: url(\"/img/bañista3.png\");");
                            System.out.println("BBBBBBBB");
                            break;
                        case 2:
                            btn.setStyle("-fx-background-image: url(\"/img/personita1.png\");");
                            System.out.println("CCCCCCCC");
                            break;
                    }
                    temp = 1;
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
            
            return temp;
    }
    
    public void finalizarPartida (int x, ProgressBar vida, int turno) throws Exception{
        
        if (vida.getProgress() < 0.33333333333) {
            System.out.println("Fin partida vida");
            CambioVictoria();
            String consulta = "update partida set victoria = false";
            Bd.consultaModificacion(conection, consulta);
        }
        if (x >= 350) {
            System.out.println("Fin partida pt");
            CambioVictoria();
        } 
        if(turno==0){
            System.out.println("Fin partida turnos");
            CambioVictoria();
        }
    }
    
    public void CambioVictoria () throws Exception{
        
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
        //String consulta = "update partida set victoria = true";
        //Bd.consultaModificacion(conection, consulta);
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Victoria.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
    
    
    public void jugadorBot (Label puntos,Label turnos, tablajuego pantano, ProgressBar vida, Button [] tabla) throws Exception {
        Random rnd=new Random();
        JuegoPCController turn = new JuegoPCController();
        int x = rnd.nextInt(5);
        int y = rnd.nextInt(5);
        
        String boton = "b" + x + y;

       for (int i = 0; i < tabla.length; i++) {
           if(tabla [i] != null) {
               if (tabla[i].getId().equals(boton)) {
                   if (Casilla(puntos, turnos, tabla[i], pantano, vida, x, y) != 1) {
                       System.out.println("¡turnoactiuvcado");
                       
                       turn.setTurnoJugA(true);
                       turn.setTurnoJugB(false);
                       jugadorBot(puntos, turnos, pantano, vida, tabla);
                   }
                   System.out.println("¡Botón activado!");
                }
           }
        }
    }     
}
