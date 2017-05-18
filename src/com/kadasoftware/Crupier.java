package com.kadasoftware;

import java.util.ArrayList;
import java.util.List;

public class Crupier implements Apostador{

    private List<Carta> cartas;
    private int puntuacion;
    private boolean ganador;
    private static final int MAXIMO_NUMERO_CARTAS_PARA_OCULTAR_PRIMERA_CARTA = 2;
    private static final int PUNTUACION_LIMITE_PARA_SOLICITAR_CARTAS = 17;

    public Crupier() {
        this.cartas = new ArrayList<>();
        this.ganador = false;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public void anadirCarta(Carta carta) {
        this.cartas.add(carta);
        setPuntuacion(carta);
    }

    public int getPuntuacion() { return puntuacion; }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void imprimirCartas(boolean juegoActivo) {
        String impresionCartas = Utilerias.ANSI_RED + "CARTAS DEL CRUPIER: " + Utilerias.ANSI_RESET + "[";
        int totalCartas = this.cartas.size();
        for(int i = 0; i < totalCartas; i++) {
            Carta carta = this.cartas.get(i);
            if(i == 0 && juegoActivo) {
                if(totalCartas > MAXIMO_NUMERO_CARTAS_PARA_OCULTAR_PRIMERA_CARTA) {
                    impresionCartas += carta + ", ";
                }
                else {
                    if(totalCartas == 1) {
                        impresionCartas += "############";
                    }
                    else {
                        impresionCartas += "############, ";
                    }
                }

            } else {
                if(i == totalCartas - 1) {
                    impresionCartas += carta;
                }
                else {
                    impresionCartas += carta + ", ";
                }
            }
        }
        System.out.println(impresionCartas + "]");
    }

    public boolean esGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public static int getPuntuacionLimiteParaSolicitarCartas() {
        return PUNTUACION_LIMITE_PARA_SOLICITAR_CARTAS;
    }

    private void setPuntuacion(Carta carta) {
        int puntuacionTemporal = this.puntuacion;
        int valorMinimoCarta = carta.getValores()[0];
        if(carta.getNombre().equals(TiposCartas.AS.getNombre())) {
            int valorMaximoAs = carta.getValores()[1];
            if(puntuacionTemporal + valorMaximoAs <= BlackJack.obtenerPuntuacionGanadora()) {
                this.puntuacion = puntuacionTemporal + valorMaximoAs;
                carta.setValor(valorMaximoAs);
            } else {
                this.puntuacion = puntuacionTemporal + valorMinimoCarta;
            }
        } else {
            this.puntuacion = puntuacionTemporal + valorMinimoCarta;
        }

    }
}
