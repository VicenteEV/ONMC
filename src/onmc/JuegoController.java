/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onmc;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JuegoController {
    
    @FXML
    private Button config, salir;
    
    
    @FXML
    public void btnConfig(ActionEvent event) {
        System.out.println("caca");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Inicio.fxml"));
            Stage stage = (Stage) config.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    public void btnSalir(ActionEvent event) {
        System.out.println("caca");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Inicio.fxml"));
            Stage stage = (Stage) salir.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
}
