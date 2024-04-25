
package onmc;

import java.nio.file.Paths;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class audio{
    
    ToggleButton plst;
    Slider volumen;
    Media audio1 = new Media(Paths.get("src/audio/cocodrilo.wav").toUri().toString());
    MediaPlayer aud1=new MediaPlayer(audio1);

    Media audio2 = new Media(Paths.get("src/audio/cocodrilo2.wav").toUri().toString());
    MediaPlayer aud2=new MediaPlayer(audio2);

    Media audio3 = new Media(Paths.get("src/audio/Chipi.wav").toUri().toString());
    MediaPlayer aud3=new MediaPlayer(audio3); 
    
    audio(Slider volumen, ToggleButton plst){
        this.plst= plst;
        this.volumen= volumen;
    } 

    public void musicaAudio1(){
        aud1.play();
        volumen.setValue(aud1.getVolume() * 50);
        volumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                aud1.setVolume(volumen.getValue() / 100);
            } 
        });
        plst.setOnAction(reproductor ->{
            if(plst.isSelected()){
                aud1.stop();  
            } 
            else {
                aud1.play(); 
            }
        });
    }
    public void musicaAudio2(){
        aud2.play();
        volumen.setValue(aud2.getVolume() * 50);
        volumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                aud2.setVolume(volumen.getValue() / 100);
            } 
        });
        plst.setOnAction(reproductor ->{
            if(plst.isSelected()){
                aud2.stop();  
            } 
            else {
                aud2.play(); 
            }
        });
    }
    public void musicaAudio3(){
        aud3.play();
        volumen.setValue(aud3.getVolume() * 50);
        volumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                aud1.setVolume(volumen.getValue() / 100);
            } 
        });
        plst.setOnAction(reproductor ->{
            if(plst.isSelected()){
                aud3.stop();  
            } 
            else {
                aud3.play(); 
            }
        });
    }
}
