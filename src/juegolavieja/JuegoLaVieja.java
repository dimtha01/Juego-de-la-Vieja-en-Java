package juegolavieja;

import java.util.Scanner;

public class JuegoLaVieja {
    private static char[] tablero = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private static char jugador = 'X';

    public static void tableroJuego() {
        System.out.println(" ");
        System.out.println("|" + tablero[0] + " | " + tablero[1] + " | " + tablero[2] + "|");
        System.out.println("|--|---|--|");
        System.out.println("|" + tablero[3] + " | " + tablero[4] + " | " + tablero[5] + "|");
        System.out.println("|--|---|--|");
        System.out.println("|" + tablero[6] + " | " + tablero[7] + " | " + tablero[8] + "|");
        System.out.println("|--|---|--|");
    }

    public static boolean verificarGanador() {
        if ((tablero[0] == tablero[1] && tablero[1] == tablero[2]) ||
                (tablero[3] == tablero[4] && tablero[4] == tablero[5]) ||
                (tablero[6] == tablero[7] && tablero[7] == tablero[8]) ||
                (tablero[0] == tablero[3] && tablero[3] == tablero[6]) ||
                (tablero[1] == tablero[4] && tablero[4] == tablero[7]) ||
                (tablero[2] == tablero[5] && tablero[5] == tablero[8]) ||
                (tablero[0] == tablero[4] && tablero[4] == tablero[8]) ||
                (tablero[2] == tablero[4] && tablero[4] == tablero[6])) {
            return true;
        } else {
            return false;
        }
    }

    public static void juegolavieja() {
        int jugadasRestantes = 9;
        Scanner input = new Scanner(System.in);
        while (jugadasRestantes > 0) {
            tableroJuego();
            System.out.println("Turno de " + jugador);

            System.out.print("Elige una casilla de de(1-9) : ");
            int posicion = input.nextInt();
            while (true) {
                if (posicion >= 1 && posicion <= 9) {
                    break;
                } else {
                    System.out.print("Elige una casilla de de(1-9) : ");
                    posicion = input.nextInt();
                }
            }
            if (tablero[posicion - 1] == 'X' || tablero[posicion - 1] == 'O') {
                System.out.print("Elige otra Casilla esta Ocupadada : ");
                continue;
            }
            tablero[posicion - 1] = jugador;
            if (verificarGanador()) {
                tableroJuego();
                System.out.println("Eljugador " + jugador + " ha ganado");
                break;
            }
            if (jugador == 'X') {
                jugador = 'O';

            } else {
                jugador = 'X';

            }
            jugadasRestantes--;
        }
        if (jugadasRestantes == 0) {
            tableroJuego();
            System.out.println("!Empate No hay ganador");

        }
    }

}
