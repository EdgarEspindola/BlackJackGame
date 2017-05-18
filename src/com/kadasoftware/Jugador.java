package com.kadasoftware;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Apostador{

    private List<Carta> cartas;
    private int puntuacion;
    private boolean plantado;
    private boolean ganador;

    public Jugador() {
        this.cartas = new ArrayList<>();
        this.plantado = false;
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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void imprimirCartas(boolean juegoActivo) {
        String impresionCartas = Utilerias.ANSI_BLUE + "CARTAS DEL JUGADOR: " + Utilerias.ANSI_RESET + "[";
        for(int i = 0; i < this.cartas.size(); i++) {
            Carta carta = this.cartas.get(i);
            if(i == this.cartas.size() - 1) {
                impresionCartas += carta;
            } else {
                impresionCartas += carta + ", ";
            }
        }
        System.out.println(impresionCartas + "]");
    }

    public boolean estaPlantado() {
        return plantado;
    }

    public void setPlantado(boolean plantado) {
        this.plantado = plantado;
    }

    public boolean esGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
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
