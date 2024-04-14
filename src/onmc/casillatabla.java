
package onmc;

public class casillatabla extends tablajuego {
     public int comprobarCasilla(int x, int y){
        int rs = 0;
        if (PANTANO[x][y]==0){
            rs=0;
        }
        else if (PANTANO[x][y]==1){
            rs=1;
        }
        else if (PANTANO[x][y]==2){
            rs=2;
        }
        return rs; 
    }
}
