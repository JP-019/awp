package Clases;

public class Ficha {
    private final String nombreFicha;
    private final Usuarios jugador;
    private final int tipo;
    private int vida;
    private int ataque;
    private int escudo;

    private int x;
    private int y;

    
    public Ficha(int tipo, Usuarios jugador, int x, int y) {
        this.jugador = jugador;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        switch (tipo) {
            case 0:
                nombreFicha = "Hombre lobo";
                ataque = 5;
                vida = 5;
                escudo = 2;
                break;
            case 1:
                nombreFicha = "Vampiro";
                ataque = 3;
                vida = 4;
                escudo = 5;
                break;
            case 2:
                nombreFicha = "Necromancer";
                ataque = 4;
                vida = 3;
                escudo = 1;
                break;
            case 3:
                nombreFicha = "Zombie";
                ataque = 1;
                vida = 1;
                escudo = 0;
                break;
            default:
                throw new IllegalArgumentException("Invalid Ficha type: " + tipo);
        }
    }

    public String getNombreFicha() {
        return nombreFicha;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getEscudo() {
        return escudo;
    }

    public int getVida() {
        return vida;
    }

    public int getTipo() {
        return tipo;
    }

    public Usuarios getJugador() {
        return jugador;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

   
    public boolean chuparSangre() {
        if (tipo == 1) {
            vida++;
            return true;
        }
        return false;
    }

 
    public void receiveLanza() {
        vida -= 2;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void receiveDamage(int damage) {
        if (escudo > 0) {
            if (escudo >= damage) {
                escudo -= damage;
            } else {
                damage -= escudo;
                escudo = 0;
                vida -= damage;
            }
        } else {
            vida -= damage;
        }
        if (vida < 0) {
            vida = 0;
        }
    }
}
