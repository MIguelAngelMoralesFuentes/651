package juegogato;
import java.util.Scanner;

public class JuegoGato {
    public static void main(String[] args) {
        char[] tablero = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char jugadorActual = 'X';
        String estadoActual = "jugando";
        int turno = 1;
        imprimirInstrucciones();

        while (true) {
            System.out.printf("Es el turno del jugador %c%n", jugadorActual);
            int posicion = obtenerPosicion(tablero);

            if (posicion >= 0 && posicion < 9) {
                if (tablero[posicion] != ' ') {
                    System.out.printf("La posición %d ya está ocupada, elija otra%n", posicion + 1);
                    continue;
                } else {
                    tablero[posicion] = jugadorActual;
                    turno++;
                }
            } else {
                System.out.println("Posición no válida");
                continue;
            }

            dibujarTablero(tablero);
            estadoActual = estadoJuego(tablero);

            if (estadoActual.equals("jugando")) {
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
            } else if (estadoActual.equals("ganador")) {
                System.out.printf("El jugador %c es el GANADOR%n", jugadorActual);
                break;
            }

            if (turno >= 9) {
                System.out.println("Ya no hay más casillas, juego empatado");
                break;
            }
        }
    }

    public static void imprimirInstrucciones() {
        System.out.println("Vamos a jugar al gato");
        System.out.println("El tablero tiene la siguiente estructura");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9 ");
    }

    public static void dibujarTablero(char[] tablero) {
        System.out.printf(" %c | %c | %c %n", tablero[0], tablero[1], tablero[2]);
        System.out.println("---+---+---");
        System.out.printf(" %c | %c | %c %n", tablero[3], tablero[4], tablero[5]);
        System.out.println("---+---+---");
        System.out.printf(" %c | %c | %c %n", tablero[6], tablero[7], tablero[8]);
    }

    public static String estadoJuego(char[] tablero) {
        if (tablero[0] == tablero[1] && tablero[1] == tablero[2] && tablero[0] != ' ') {
            return "ganador";
        } else if (tablero[3] == tablero[4] && tablero[4] == tablero[5] && tablero[3] != ' ') {
            return "ganador";
        } else if (tablero[6] == tablero[7] && tablero[7] == tablero[8] && tablero[6] != ' ') {
            return "ganador";
        } else if (tablero[0] == tablero[3] && tablero[3] == tablero[6] && tablero[0] != ' ') {
            return "ganador";
        } else if (tablero[1] == tablero[4] && tablero[4] == tablero[7] && tablero[1] != ' ') {
            return "ganador";
        } else if (tablero[2] == tablero[5] && tablero[5] == tablero[8] && tablero[2] != ' ') {
            return "ganador";
        } else if (tablero[0] == tablero[4] && tablero[4] == tablero[8] && tablero[0] != ' ') {
            return "ganador";
        } else if (tablero[6] == tablero[4] && tablero[4] == tablero[2] && tablero[6] != ' ') {
            return "ganador";
        } else {
            return "jugando";
        }
    }

    public static int obtenerPosicion(char[] tablero) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija la posición a jugar (1-9): ");
        int posicion = scanner.nextInt() - 1;
        return posicion;
    }
}
