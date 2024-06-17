/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CastleVania;

import Exe.Main;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jaymar Y Jafet
 */
public class main {
      public static void main(String[] args) {
          try {
            URL url = Main.class.getResource("/Exe/001_Opening.wav");
            if (url != null) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else {
                System.err.println("No se pudo encontrar el archivo de sonido.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

          //Llamamos inicialmentee al menu inicial
          MenuInicial ObjetoMenuInicial = new MenuInicial(null,null);
          ObjetoMenuInicial.setVisible(true);
      }
}
