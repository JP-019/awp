package Exe;

import CastleVania.MenuPrincipal;
import CastleVania.Usuario;
import Clases.Usuarios;
import Clases.Ficha;
import Exe.Main;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.abs;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tablero extends JFrame implements ActionListener {

    Random Aleatorio = new Random();
    Color Color2 = new Color(255, 255, 255);
    Color Color1 = new Color(0, 0, 0);
    Usuarios Jugadores[] = new Usuarios[2];
    int Movimientos;
    int Turno;
    int Type;
    ArrayList<Ficha> Fichas = new ArrayList<Ficha>();
    JButton TilesBTN[][] = new JButton[6][6];
    Ficha SelectedTile;
    JButton RetireBTN;
    JButton SpinBTN;
    JLabel MovimientosTXT;
    JLabel RuletaTXT;
    JLabel TurnoTXT;

    public Tablero(Usuarios Rival) {
        Jugadores[0] = new Usuarios("NombreJugador1", "ContraseñaJugador1");
        Jugadores[1] = Rival;
        Movimientos = 1;
        Turno = 0;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel Panel = new JPanel(null);
        Panel.setPreferredSize(new java.awt.Dimension(600, 425));

        JLabel BG = new JLabel();
        BG.setSize(600, 425);
        BG.setIcon(new ImageIcon(getClass().getResource("Imagenes/background.png")));
        /*Este es un btn en codigo*/
        RetireBTN = new JButton();
        RetireBTN.setFont(new java.awt.Font("", java.awt.Font.BOLD, 22));
        RetireBTN.setBorder(BorderFactory.createLineBorder(new Color(60, 63, 65), 4));
        RetireBTN.setBounds(25, 25, 150, 50);
        RetireBTN.setForeground(new Color(179, 179, 54));
        RetireBTN.setBackground(new Color(60, 63, 65, 0));
        RetireBTN.setFocusable(false);
        RetireBTN.setText("Retirarse");
        RetireBTN.addActionListener(this);
        Panel.add(RetireBTN);
        /*Este es un btn en codigo fin */

        MovimientosTXT = new JLabel();
        MovimientosTXT.setFont(new java.awt.Font("", java.awt.Font.BOLD, 14));
        MovimientosTXT.setBounds(175, 25 + (RetireBTN.getHeight() / 2), RetireBTN.getWidth() + 50, RetireBTN.getHeight() / 2);
        MovimientosTXT.setText("Movimientos restantes: " + Movimientos);
        MovimientosTXT.setHorizontalAlignment(JLabel.CENTER);
        MovimientosTXT.setVerticalAlignment(JLabel.CENTER);
        MovimientosTXT.setForeground(Color.WHITE);
        Panel.add(MovimientosTXT);

        TurnoTXT = new JLabel();
        TurnoTXT.setFont(new java.awt.Font("", java.awt.Font.BOLD, 22));
        TurnoTXT.setBounds(175, 25, RetireBTN.getWidth() + 50, RetireBTN.getHeight() / 2);

        //Arreglar linea
        TurnoTXT.setText("Turno de: ");
        TurnoTXT.setHorizontalAlignment(JLabel.CENTER);
        TurnoTXT.setVerticalAlignment(JLabel.CENTER);
        TurnoTXT.setForeground(Color.WHITE);
        Panel.add(TurnoTXT);
        /*Este es un btn en codigo*/

        SpinBTN = new JButton();
        SpinBTN.setFont(new java.awt.Font("", java.awt.Font.BOLD, 22));
        SpinBTN.setBounds(375, 25, 200, RetireBTN.getHeight());
        SpinBTN.setForeground(new Color(179, 179, 54));
        SpinBTN.setBackground(new Color(60, 63, 65, 0));
        SpinBTN.setFocusable(false);
        SpinBTN.setText("¡Girar ruleta!");
        SpinBTN.addActionListener(this);
        Panel.add(SpinBTN);
        /*Este es un btn en codigo fin*/

        RuletaTXT = new JLabel();
        RuletaTXT.setBounds(375, 100, SpinBTN.getWidth(), 200);
        RuletaTXT.setIcon(new ImageIcon(getClass().getResource("Imagenes/WSpin.gif")));
        Panel.add(RuletaTXT);

        for (int Fila = 0; Fila < 6; Fila++) {
            int Restar = 2;
            for (int Col = 0; Col < 6; Col++) {
                TilesBTN[Fila][Col] = new JButton();

                TilesBTN[Fila][Col].setBounds(50 + (Col * 50), TurnoTXT.getY() + TurnoTXT.getHeight() + 25 + (Fila * 50), 50, 50);
                TilesBTN[Fila][Col].setName("F");

                if (Fila == 0 || Fila == 5) {
                    TilesBTN[Fila][Col].setName((Col <= 2) ? Integer.toString(Col) : Integer.toString(Restar));

                    Fichas.add(new Ficha((Col <= 2) ? Col : Restar--,
                            Jugadores[(Fila == 0) ? 0 : 1],
                            Fila,
                            Col));
                }

                TilesBTN[Fila][Col].setFocusable(false);
                TilesBTN[Fila][Col].addActionListener(this);
                Panel.add(TilesBTN[Fila][Col]);
            }
        }
        setTileBG();

        Panel.add(BG);
        add(Panel);
        pack();
        setLocationRelativeTo(null);
    }

    public Tablero(Usuario usuarioSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ImageIcon scaleImage(String url, int width, int height) {
        ImageIcon neocard = new ImageIcon(getClass().getResource(url));
        Image Scalecard = neocard.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(Scalecard);
    }

    public void setTileBG() {

        for (int f = 0; f < TilesBTN.length; f++) {

            for (int c = 0; c < TilesBTN.length; c++) {
                if (TilesBTN[f][c].getIcon() == null) {
                    TilesBTN[f][c].setName("F");
                }

                TilesBTN[f][c].setIcon(null);
                TilesBTN[f][c].setBackground(((f + c) % 2 == 0) ? Color1 : Color2);
                TilesBTN[f][c].setBorder(BorderFactory.createLineBorder(((f + c) % 2 == 0) ? Color2 : Color1, 2));

            }

        }

        ImageIcon MonsterImage = null;
        for (int i = 0; i < Fichas.size(); i++) {

            if (Fichas.get(i) != null) {

                switch (Fichas.get(i).getTipo()) {
                    case 0:
                        MonsterImage = new ImageIcon(getClass().getResource("Imagenes/Hombre-lobo" + ((Fichas.get(i).getJugador() == Jugadores[0]) ? "1" : "2") + ".png"));
                        break;
                    case 1:
                        MonsterImage = new ImageIcon(getClass().getResource("Imagenes/Vampiro" + ((Fichas.get(i).getJugador() == Jugadores[0]) ? "1" : "2") + ".png"));
                        break;
                    case 2:
                        MonsterImage = new ImageIcon(getClass().getResource("Imagenes/Necromante" + ((Fichas.get(i).getJugador() == Jugadores[0]) ? "1" : "2") + ".png"));
                        break;
                    case 3:
                        MonsterImage = new ImageIcon(getClass().getResource("Imagenes/Zombie" + ((Fichas.get(i).getJugador() == Jugadores[0]) ? "1" : "2") + ".png"));
                        break;
                    default:
                        MonsterImage = null;
                }

                TilesBTN[Fichas.get(i).getX()][Fichas.get(i).getY()].setIcon(MonsterImage);

            }

        }

        checkFichas(Movimientos <= 0);
    }

    public String endMessage(String Won, String Time) {
        String Message = Jugadores[(Turno == 0) ? 0 : 1].getNombre().toUpperCase();
        Message += Won;
        Message += Jugadores[(Turno == 1) ? 0 : 1].getNombre().toUpperCase();
        Message += Time;

        return Message;
    }
public  int puntaje(){
    int pun;
    return pun=+3;
}
    public void End(String Won) {
       LocalDate FechaPartida = LocalDate.now();

        String ganador;
        if (Won.equals("jugador")) {
            ganador = "jugador 1"; // Obtener el nombre del jugador si ganó
        } else if (Won.equals("rival")) {
            ganador = "jugador 2";  // Obtener el nombre del rival si ganó
        } else {
            ganador = "Desconocido";  // Manejar caso desconocido (deberías evitar que esto suceda)
        }

        String tiempo = endMessage(Won, ";\n " + FechaPartida.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        String mensaje = "¡El ganador es: " + ganador + "!";
        JOptionPane.showMessageDialog(this, mensaje, "Fin del juego"+tiempo, JOptionPane.INFORMATION_MESSAGE);
    MenuPrincipal menuPrincipal = new MenuPrincipal(-1, null, true, null);
        
        // Hacer visible el MenuPrincipal
        menuPrincipal.setVisible(true);
        
        // Cerrar el formulario actual si es necesario
        this.setVisible(false);
        dispose();  
    }

    public void MovableTile(int X, int Y, String Mark) {
        try {
            TilesBTN[X][Y].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            TilesBTN[X][Y].setBackground(Color.red);
            TilesBTN[X][Y].setName(Mark);
        } catch (Exception e) {
        }
    }

    //Se elige la pieza al azar
    public int getRandomType() {
        Aleatorio.setSeed(Aleatorio.nextInt());
        int Piece = Aleatorio.nextInt();
        Piece %= 3;
        return abs(Piece);
    }

    public void checkFichas(boolean change) {
        int ContFichasJGA = 0;
        int ContFichasJGE = 0;

        for (int i = 0; i < Fichas.size(); i++) {

            if (Fichas.get(i) != null) {

                if (Fichas.get(i).getVida() > 0) {

                    if (Fichas.get(i).getJugador() == Jugadores[Turno] && Fichas.get(i).getTipo() != 3) {
                        ContFichasJGA++;
                    } else {
                        ContFichasJGE++;
                    }

                } else {
                    Fichas.remove(i);
                }

            }

        }

        if (change) {

            if (ContFichasJGA <= 2) {
                Movimientos = 3;
            } else if (ContFichasJGA <= 4) {
                Movimientos = 2;
            } else {
                Movimientos = 1;
            }

        }

        if (ContFichasJGA == 0) {
            End("  sin piezas, ha ganado ");
        } else if (ContFichasJGE == 0) {
            End(" se , ha perdido ");
        }

    }

    public void MovementDone() {
        Movimientos--;
        if (Movimientos <= 0) {
            Turno = (Turno == 0) ? 1 : 0;
            TurnoTXT.setText("Turno de: " + Jugadores[Turno].getNombre());
        }
        setTileBG();
        SpinBTN.setEnabled(true);
        MovimientosTXT.setText("Movimientos restantes: " + Movimientos);
        RuletaTXT.setIcon(new ImageIcon(getClass().getResource("Imagenes/" + ((Turno == 0) ? "W" : "B") + "Spin.gif")));
    }

    public boolean showTypePieces() {
        boolean PiecesFound = false;
        setTileBG();

        for (Ficha Ficha : Fichas) {

            if (Ficha.getTipo() == Type && Ficha.getJugador() == Jugadores[Turno]) {

                TilesBTN[Ficha.getX()][Ficha.getY()].setBackground((Turno == 0) ? Color.black : Color.WHITE);
                TilesBTN[Ficha.getX()][Ficha.getY()].setBorder(BorderFactory.createLineBorder((Turno == 1) ? Color.black : Color.WHITE, 2));

                PiecesFound = true;
            }

        }

        return PiecesFound;
    }

    public Ficha MonsterAt(int X, int Y) {

        for (Ficha Ficha : Fichas) {

            if (Ficha.getX() == X && Ficha.getY() == Y) {
                return Ficha;
            }

        }

        return null;
    }

    public boolean isTileValid(int X, int Y) {

        for (Ficha Ficha : Fichas) {

            if (Ficha.getX() == X && Ficha.getY() == Y && Ficha.getJugador() == Jugadores[Turno]) {

                return false;

            }

        }

        return true;
    }

    public boolean isMyZombie(int X, int Y) {

        for (Ficha Ficha : Fichas) {

            if (Ficha.getX() == X && Ficha.getY() == Y) {

                if (Ficha.getJugador() == Jugadores[Turno] && Ficha.getTipo() == 3) {
                    if (isTileValid(X + 1, Y)) {
                        MovableTile(X + 1, Y, "Z");
                    }
                    if (isTileValid(X - 1, Y)) {
                        MovableTile(X - 1, Y, "Z");
                    }
                    if (isTileValid(X, Y + 1)) {
                        MovableTile(X, Y + 1, "Z");
                    }
                    if (isTileValid(X, Y - 1)) {
                        MovableTile(X, Y - 1, "Z");
                    }
                    if (isTileValid(X + 1, Y + 1)) {
                        MovableTile(X + 1, Y + 1, "Z");
                    }
                    if (isTileValid(X - 1, Y + 1)) {
                        MovableTile(X - 1, Y + 1, "Z");
                    }
                    if (isTileValid(X + 1, Y - 1)) {
                        MovableTile(X + 1, Y - 1, "Z");
                    }
                    if (isTileValid(X - 1, Y - 1)) {
                        MovableTile(X - 1, Y - 1, "Z");
                    }

                    return true;
                }

                return false;
            }

        }
        return false;
    }

    public void Movement(int X, int Y) {

        if (Type == 2) {

            for (int f = 0; f < TilesBTN.length; f++) {

                for (int c = 0; c < TilesBTN.length; c++) {

                    if (TilesBTN[f][c].getIcon() == null) {

                        MovableTile(f, c, (TilesBTN[f][c].getName().equals("F")) ? "I" : TilesBTN[f][c].getName());

                    } else {
                        isMyZombie(f, c);
                    }

                }

            }

        }

        String marca;
        for (int i = 1; i <= ((Type == 1) ? 1 : 2); i++) {
            marca = (i == 1) ? "MA" : "MH";

            if (isTileValid(X + i, Y) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X + i, Y) : true)) {
                MovableTile(X + i, Y, marca);
            }
            if (isTileValid(X - i, Y) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X - i, Y) : true)) {
                MovableTile(X - i, Y, marca);
            }
            if (isTileValid(X, Y + i) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X, Y + i) : true)) {
                MovableTile(X, Y + i, marca);
            }
            if (isTileValid(X, Y - i) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X, Y - i) : true)) {
                MovableTile(X, Y - i, marca);
            }
            if (isTileValid(X + i, Y + i) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X + i, Y + i) : true)) {
                MovableTile(X + i, Y + i, marca);
            }
            if (isTileValid(X - i, Y + i) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X - i, Y + i) : true)) {
                MovableTile(X - i, Y + i, marca);
            }
            if (isTileValid(X + i, Y - i) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X + i, Y - i) : true)) {
                MovableTile(X + i, Y - i, marca);
            }
            if (isTileValid(X - i, Y - i) && ((SelectedTile.getTipo() == 0 && i == 2) ? werewolfMovement(X - i, Y - i) : true)) {
                MovableTile(X - i, Y - i, marca);
            }

        }

    }

    public boolean werewolfMovement(int X, int Y) {
        try {
            return (TilesBTN[X][Y].getIcon() == null && isTileValid(X, Y));
        } catch (Exception e) {
            return false;
        }
    }

    public void ShowMovementOptions(JButton pressed) {

        for (int f = 0; f < TilesBTN.length; f++) {

            for (int c = 0; c < TilesBTN.length; c++) {

                if (TilesBTN[f][c] == pressed) {

                    SelectedTile = MonsterAt(f, c);

                    if (SelectedTile != null) {

                        Movement(f, c);

                    }

                }

            }

        }

    }

    public boolean UsarFicha(JButton pressed) {
        for (int f = 0; f < TilesBTN.length; f++) {

            for (int c = 0; c < TilesBTN.length; c++) {

                if (TilesBTN[f][c] == pressed) {

                    if (TilesBTN[f][c].getIcon() == null) {

                        if (SelectedTile.getTipo() == 2 && !TilesBTN[f][c].getName().equals("MA")) {
                            Fichas.add(new Ficha(3, Jugadores[Turno], f, c));
                            TilesBTN[f][c].setName("3");
                            return true;
                        }

                        TilesBTN[f][c].setName(TilesBTN[SelectedTile.getX()][SelectedTile.getY()].getName());
                        TilesBTN[SelectedTile.getX()][SelectedTile.getY()].setName("F");
                        SelectedTile.setCoords(f, c);
                        return true;

                    } else {

                        if (TilesBTN[f][c].getName().equals("Z")) {

                            MonsterAt(f, c).receiveDamage(1);
                            showAtackInfo(MonsterAt(f, c), 1);
                            return true;

                        } else {

                            switch (SelectedTile.getTipo()) {

                                case 0:
                                    MonsterAt(f, c).receiveDamage(SelectedTile.getAtaque());
                                    showAtackInfo(MonsterAt(f, c), SelectedTile.getAtaque());
                                    if (MonsterAt(f, c).getVida() <= 0) {
                                        Fichas.remove(MonsterAt(f, c));
                                    }

                                    return true;

                                case 1:
                                    try {
                                        Object[] opciones = {"Ataque normal", "Chupar sangre"};
                                        int Damage = 1;
                                        if (JOptionPane.showOptionDialog(this, "Eliga una opcion de ataque: ", "Opciones de ataque", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0) == 0) {

                                            Damage = SelectedTile.getAtaque();

                                        } else {
                                            SelectedTile.chuparSangre();
                                        }
                                        MonsterAt(f, c).receiveDamage(Damage);
                                        showAtackInfo(MonsterAt(f, c), Damage);

                                        if (MonsterAt(f, c).getVida() <= 0) {
                                            Fichas.remove(MonsterAt(f, c));
                                        }
                                        return true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(this, "Por favor eliga una de las habilidades", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        return false;
                                    }
                                case 2:
                                    try {
                                        Object[] opciones = {"Ataque normal", "Usar lanza"};
                                        int Damage = (SelectedTile.getAtaque() / 2);
                                        if (TilesBTN[f][c].getName().equals("MA")) {

                                            if (JOptionPane.showOptionDialog(this, "Eliga una opcion de ataque: ", "Opciones de ataque", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0) == 0) {

                                                Damage = SelectedTile.getAtaque();

                                            }

                                        }

                                        if (Damage == SelectedTile.getAtaque()) {
                                            MonsterAt(f, c).receiveDamage(Damage);
                                        } else {
                                            MonsterAt(f, c).receiveLanza();
                                        }
                                        showAtackInfo(MonsterAt(f, c), Damage);

                                        if (MonsterAt(f, c).getVida() <= 0) {
                                            Fichas.remove(MonsterAt(f, c));
                                        }
                                        return true;
                                    } catch (Exception e) {
                                        return false;
                                    }

                            }

                        }

                    }

                    return false;
                }

            }

        }

        return false;
    }

    public void showAtackInfo(Ficha Atacada, int dmg) {
        String info = Atacada.getNombreFicha() + " de " + Atacada.getJugador().getNombre() + " ha recibido " + dmg + " de daño.\n";
        info += "Vida: " + Atacada.getVida() + "\n";
        info += "Escudo: " + Atacada.getEscudo() + "\n";
        JOptionPane.showMessageDialog(this, info, "Atack log", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RetireBTN) {

            End(" se ha retirado perdiendo la partida contra ");

        } else if (e.getSource() == SpinBTN) {
            SpinBTN.setEnabled(false);
            Type = getRandomType();

            RuletaTXT.setIcon(scaleImage("Imagenes/" + (((Turno == 0) ? "w" : "b") + Type + ".png"), 200, 200));
            if (!showTypePieces()) {
                MovementDone();
            }
        } else if (!SpinBTN.isEnabled()) {

            if (((JButton) e.getSource()).getBackground() == Color.BLACK || ((JButton) e.getSource()).getBackground() == Color.WHITE) {

                showTypePieces();
                ShowMovementOptions((JButton) e.getSource());

            } else if (((JButton) e.getSource()).getBackground() == Color.RED) {

                if (UsarFicha((JButton) e.getSource())) {

                    MovementDone();

                }

            } else {
                JOptionPane.showMessageDialog(this, "una de las casillas marcadas", "Elegir casilla correcta", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "¡Por favor gire la ruleta", "Girar ruleta", JOptionPane.WARNING_MESSAGE);
        }
    }

}
