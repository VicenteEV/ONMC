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

/**
 *
 * @author Usuario
 */
public class PerfilController {
    
    @FXML
    private Button config, puntuacion, jugar, jugarSolo;
    
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
    public void btnPuntuacion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Inicio.fxml"));
            Stage stage = (Stage) puntuacion.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    public void btnJugar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Juego.fxml"));
            Stage stage = (Stage) jugar.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    public void btnJugarSolo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Escenas/Juego.fxml"));
            Stage stage = (Stage) jugarSolo.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setFullScreen(true);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
}
