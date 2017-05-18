package com.kadasoftware;

public interface Apostador {

    void anadirCarta(Carta carta);

    void imprimirCartas(boolean juegoActivo);

    int getPuntuacion();

    void setPuntuacion(int puntuacion);

}
