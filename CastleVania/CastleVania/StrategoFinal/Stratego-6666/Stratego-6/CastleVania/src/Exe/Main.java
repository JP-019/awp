package Exe;

import Clases.Usuarios;
import javax.sound.sampled.*;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        // Reproducir el sonido al inicio usando Clip
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

        // Crear jugadores
        Usuarios jugador1 = new Usuarios("Jugador1");
        Usuarios jugador2 = new Usuarios("Jugador2");

        // Crear y mostrar el tablero
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tablero(jugador2).setVisible(true);
            }
        });
    }
}
