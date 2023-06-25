package juego;

import java.util.Random;
import java.util.Scanner;

abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int nivel;
    protected int experiencia;
    protected static final int VIDA_BASE = 50;
    protected static final int AUMENTO_VIDA_POR_NIVEL = 50;
    protected static final int EXPERIENCIA_SUBIR_NIVEL = 10;

    public Personaje(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = VIDA_BASE + (nivel - 1) * AUMENTO_VIDA_POR_NIVEL;
        this.experiencia = 0;
    }

    public abstract void atacar(Personaje enemigo);
    public abstract void defender(int danio);

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public void recibirExperiencia(int experiencia) {
        this.experiencia += experiencia;
        if (this.experiencia >= EXPERIENCIA_SUBIR_NIVEL) {
            subirNivel();
            this.experiencia -= EXPERIENCIA_SUBIR_NIVEL;
        }
    }

    protected void subirNivel() {
        nivel++;
        puntosVida += AUMENTO_VIDA_POR_NIVEL;
        System.out.println(nombre + " ha subido al nivel " + nivel + " y ha aumentado sus puntos de vida a " + puntosVida + ".");
    }
}

class Guerrero extends Personaje {
    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel);
    }

    @Override
    public void atacar(Personaje enemigo) {
        int danio = generarDanio();
        enemigo.defender(danio);
    }

    @Override
    public void defender(int danio) {
        int danioRecibido = danio / 2;
        puntosVida -= danioRecibido;
    }

    private int generarDanio() {
        Random random = new Random();
        return random.nextInt(11) + nivel * 5;
    }
}

class Mago extends Personaje {
    public Mago(String nombre, int nivel) {
        super(nombre, nivel);
    }

    @Override
    public void atacar(Personaje enemigo) {
        int danio = generarDanio();
        enemigo.defender(danio);
    }

    @Override
    public void defender(int danio) {
        int danioRecibido = danio * 2;
        puntosVida -= danioRecibido;
    }

    private int generarDanio() {
        Random random = new Random();
        return random.nextInt(6) + nivel * 3;
    }
}

class Arquero extends Personaje {
    public Arquero(String nombre, int nivel) {
        super(nombre, nivel);
    }

    @Override
    public void atacar(Personaje enemigo) {
        int danio = generarDanio();
        enemigo.defender(danio);
    }

    @Override
    public void defender(int danio) {
        int danioRecibido = danio;
        puntosVida -= danioRecibido;
    }

    private int generarDanio() {
        Random random = new Random();
        return random.nextInt(9) + nivel * 4;
    }
}

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personaje jugador = seleccionarPersonaje(scanner);
        Personaje enemigo = generarEnemigo(jugador.nivel);
        boolean jugadorActivo = true;

        System.out.println("Comienza el combate:");
        System.out.println(jugador.nombre + " (jugador) vs " + enemigo.nombre + " (enemigo)");

        while (jugador.estaVivo() && enemigo.estaVivo()) {
            if (jugadorActivo) {
                turnoJugador(jugador, enemigo, scanner);
            } else {
                turnoEnemigo(enemigo, jugador);
            }
            jugadorActivo = !jugadorActivo;
        }

        if (jugador.estaVivo()) {
            System.out.println("¡Felicidades! Has derrotado al enemigo. ¡Ganaste!");
        } else {
            System.out.println("¡Has sido derrotado por el enemigo. ¡Perdiste!");
        }
    }

    private static Personaje seleccionarPersonaje(Scanner scanner) {
        System.out.println("Seleccione su personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine();

        switch (opcion) {
            case 1:
                return new Guerrero(nombre, 1);
            case 2:
                return new Mago(nombre, 1);
            case 3:
                return new Arquero(nombre, 1);
            default:
                System.out.println("Opción inválida. Seleccionando Guerrero por defecto.");
                return new Guerrero(nombre, 1);
        }
    }

    private static Personaje generarEnemigo(int nivelJugador) {
        Random random = new Random();
        int nivelEnemigo = nivelJugador + random.nextInt(2) - 1;
        if (nivelEnemigo < 1) {
            nivelEnemigo = 1;
        }

        String nombre = "Enemigo nivel " + nivelEnemigo;
        int tipo = random.nextInt(3);
        switch (tipo) {
            case 0:
                return new Guerrero(nombre, nivelEnemigo);
            case 1:
                return new Mago(nombre, nivelEnemigo);
            case 2:
                return new Arquero(nombre, nivelEnemigo);
            default:
                return new Guerrero(nombre, nivelEnemigo);
        }
    }

    private static void turnoJugador(Personaje jugador, Personaje enemigo, Scanner scanner) {
        System.out.println("Es tu turno, " + jugador.nombre + ".");
        System.out.println("Elige una opción:");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                jugador.atacar(enemigo);
                System.out.println(jugador.nombre + " ha atacado a " + enemigo.nombre + ".");
                break;
            case 2:
                System.out.println(jugador.nombre + " se ha defendido.");
                break;
            default:
                System.out.println("Opción inválida. Seleccionando ataque por defecto.");
                jugador.atacar(enemigo);
                System.out.println(jugador.nombre + " ha atacado a " + enemigo.nombre + ".");
                break;
        }
    }

    private static void turnoEnemigo(Personaje enemigo, Personaje jugador) {
        System.out.println("Turno del enemigo " + enemigo.nombre + ".");
        enemigo.atacar(jugador);
        System.out.println(enemigo.nombre + " ha atacado a " + jugador.nombre + ".");
    }
}
