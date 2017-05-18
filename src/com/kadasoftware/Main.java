package com.kadasoftware;

import java.util.Scanner;

public class Main {

    private static BlackJack blackJack;
    private static Crupier crupier;
    private static Jugador jugador;
    private static Scanner scanner;

    public static void main(String[] args) {
        boolean seguirJugando = true;

        while(seguirJugando) {
            int opcion;
            boolean juegoActivo = true;
            scanner = new Scanner(System.in);

            crupier = new Crupier();
            jugador = new Jugador();
            blackJack = new BlackJack();

            iniciar();

            while(!verificarGanador()) {
                if (!jugador.estaPlantado()) {
                    System.out.println();
                    opcion = mostrarOpcionesJugador();
                    switch (opcion) {
                        case 1:
                            blackJack.darCarta(jugador);
                            imprimirCartasYMostrarPuntuaciones(juegoActivo);
                            break;
                        case 2:
                            jugador.setPlantado(true);
                            break;
                    }
                } else if (jugador.estaPlantado()) {
                    System.out.println();
                    imprimirCartasYMostrarPuntuaciones(juegoActivo);
                    blackJack.darCarta(crupier);
                }
            }

            juegoActivo = false;

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(Utilerias.ANSI_CYAN_BACKGROUND + Utilerias.ANSI_RED + "#####################                   PUNTUACION FINAL                  ####################" + Utilerias.ANSI_RESET);
            System.out.println();
            imprimirCartasYMostrarPuntuaciones(juegoActivo);
            imprimirGanador();
            System.out.println();


            System.out.println();
            System.out.println("¿Seguir jugando?");
            System.out.println("1.- SI");
            System.out.println("2.- NO");
            int opcionSeguirJugando = scanner.nextInt();
            scanner.nextLine();
            if(opcionSeguirJugando == 2) {
                seguirJugando = false;
            }
        }

    }

    private static void iniciar() {
        System.out.println();
        blackJack.colocarBaraja();
        blackJack.barajearCartas();

        System.out.println();
        System.out.println("REPARTIENDO CARTAS, ESPERE.....");
        System.out.println();
        blackJack.darCarta(jugador);
        imprimirCartasYMostrarPuntuacion(jugador, true);

        blackJack.darCarta(crupier);
        imprimirCartasYMostrarPuntuacion(crupier, true);

        System.out.println();
        blackJack.darCarta(jugador);
        imprimirCartasYMostrarPuntuacion(jugador, true);

        blackJack.darCarta(crupier);
        imprimirCartasYMostrarPuntuacion(crupier, true);

        System.out.println("CARTAS INICIALES REPARTIDAS");
    }

    private static int mostrarOpcionesJugador() {
        System.out.println("*********************************");
        System.out.println("* JUGADOR SELECCIONE UNA OPCION *");
        System.out.println("*                               *");
        System.out.println("* 1.- Pedir                     *");
        System.out.println("* 2.- Plantarse                 *");
        System.out.println("*                               *");
        System.out.println("*********************************");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;

    }

    private static boolean verificarGanador() {
        return blackJack.verificarGanador(jugador, crupier);
    }

    private static void imprimirGanador() {
        if(jugador.esGanador() && crupier.esGanador()) {
            System.out.println(Utilerias.ANSI_CYAN_BACKGROUND + Utilerias.ANSI_RED + "\t\t\t\t\t\tEMPATE, AMBOS GANAN" + "\t\t\t\t\t\t\t" + Utilerias.ANSI_RESET);
        }

        if(jugador.esGanador() && !crupier.esGanador()) {
            System.out.println(Utilerias.ANSI_CYAN_BACKGROUND + Utilerias.ANSI_RED + "\t\t\t\t\t\tJUGADOR GANA" + "\t\t\t\t\t\t\t" + Utilerias.ANSI_RESET);
        }

        if(!jugador.esGanador() && crupier.esGanador()) {
            System.out.println(Utilerias.ANSI_CYAN_BACKGROUND + Utilerias.ANSI_RED + "\t\t\t\t\t\tLA CASA GANA" + "\t\t\t\t\t\t\t" + Utilerias.ANSI_RESET);
        }

    }

    private static void imprimirCartasYMostrarPuntuaciones(boolean juegoActivo){
        imprimirCartasYMostrarPuntuacion(jugador, juegoActivo);
        imprimirCartasYMostrarPuntuacion(crupier, juegoActivo);
    }

    private static void imprimirCartasYMostrarPuntuacion(Apostador apostador, boolean juegoActivo) {
        blackJack.imprimirCartas(apostador, juegoActivo);
        blackJack.mostrarPuntuacion(apostador, juegoActivo);
        System.out.println();
    }

}
