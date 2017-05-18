package com.kadasoftware;

public class BlackJack {

    private static final int puntuacionGanadora = 21;
    private Baraja baraja;

    public void colocarBaraja() {
        this.baraja = new Baraja();
    }

    public void barajearCartas() {
        this.baraja.barajear();
    }

    public void darCarta(Apostador apostador) {
        apostador.anadirCarta(baraja.obtenerCarta());
    }

    public void imprimirCartas(Apostador apostador, boolean juegoActivo) {
        apostador.imprimirCartas(juegoActivo);
    }

    public void mostrarPuntuacion(Apostador apostador, boolean juegoActivo) {
         if (apostador instanceof Crupier && juegoActivo) {
             Crupier crupier = (Crupier) apostador;
             int totalCartas = crupier.getCartas().size();
             if(totalCartas <= 2) {
                 System.out.println(Utilerias.ANSI_RED + "PUNTUACIÓN: " + Utilerias.ANSI_RESET + "##" );
             } else {
                 System.out.println(Utilerias.ANSI_RED + "PUNTUACIÓN: " + Utilerias.ANSI_RESET + apostador.getPuntuacion());
             }
         } else {
             if(apostador instanceof Jugador) {
                 System.out.println(Utilerias.ANSI_BLUE + "PUNTUACIÓN: " + Utilerias.ANSI_RESET + apostador.getPuntuacion());
             }

             if(apostador instanceof Crupier) {
                 System.out.println(Utilerias.ANSI_RED + "PUNTUACIÓN: " + Utilerias.ANSI_RESET + apostador.getPuntuacion());
             }
         }



    }

    public static int obtenerPuntuacionGanadora() {
        return puntuacionGanadora;
    }

    public boolean verificarGanador(Jugador jugador, Crupier crupier) {
        int puntuacionJugador = jugador.getPuntuacion();
        int puntuacionCrupier = crupier.getPuntuacion();
        boolean ganador = false;

        if(jugador.estaPlantado() && puntuacionCrupier >= Crupier.getPuntuacionLimiteParaSolicitarCartas()) {
            if(puntuacionJugador <= BlackJack.obtenerPuntuacionGanadora() && puntuacionCrupier <= BlackJack.obtenerPuntuacionGanadora()) {
                if(puntuacionJugador > puntuacionCrupier) {
                    jugador.setGanador(true);
                    ganador = true;
                } else if(puntuacionCrupier > puntuacionJugador) {
                    crupier.setGanador(true);
                    ganador = true;
                } else {
                    jugador.setGanador(true);
                    crupier.setGanador(true);
                    ganador = true;
                }

            } else {
                if(puntuacionJugador > BlackJack.obtenerPuntuacionGanadora() && puntuacionCrupier <= BlackJack.obtenerPuntuacionGanadora()) {
                    crupier.setGanador(true);
                    ganador = true;
                }
                if(puntuacionCrupier > BlackJack.obtenerPuntuacionGanadora() && puntuacionJugador <= BlackJack.obtenerPuntuacionGanadora()) {
                    jugador.setGanador(true);
                    ganador = true;
                }

            }
        } else if(puntuacionJugador > BlackJack.obtenerPuntuacionGanadora()) {
            if(puntuacionCrupier <= BlackJack.obtenerPuntuacionGanadora() ) {
                crupier.setGanador(true);
                ganador = true;
            }
        }

        return ganador;
    }
}
