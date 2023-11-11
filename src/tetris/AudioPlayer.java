/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @FENNY JONG - 535210001
 */
public class AudioPlayer {
    private String soundsFolder = "tetrissounds" + File.separator;
    private String ClearLinePath = soundsFolder + "line.wav";
    private String gameoverPath = soundsFolder + "success.wav";
    
    private Clip clearLineSound, gameoverSound;
    
    public AudioPlayer(){
        try {
            clearLineSound = AudioSystem.getClip();
            gameoverSound = AudioSystem.getClip();
            
            clearLineSound.open(AudioSystem.getAudioInputStream(new File(ClearLinePath).getAbsoluteFile() ) );
           
            gameoverSound.open(AudioSystem.getAudioInputStream(new File(gameoverPath).getAbsoluteFile() ) );
            
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    public void playClearLine(){
        clearLineSound.setFramePosition(0);
        clearLineSound.start();
    }
    
    public void playGameover(){
        gameoverSound.setFramePosition(0);
        gameoverSound.start();
    }
}