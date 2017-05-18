package com.kadasoftware;

import java.util.ArrayList;
import java.util.List;

public class Palo {

    private String color;
    private TiposDePalo tipo;
    private List<Carta> cartas;
    private static final int CARTAS_POR_PALO = TiposCartas.getTotalCartas();

    public Palo(TiposDePalo tipo) {
        this.tipo = tipo;
        this.color = "rojo";
        cartas = new ArrayList<>(CARTAS_POR_PALO);
        inicializarCartas();
    }

    public Palo(String color, TiposDePalo tipo) {
        this.color = color;
        this.tipo = tipo;
        inicializarCartas();
    }

    private void inicializarCartas() {
        for(TiposCartas nombreCarta  : TiposCartas.values()) {
            cartas.add(new Carta(nombreCarta, tipo));
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TiposDePalo getTipo() {
        return tipo;
    }

    public void setTipo(TiposDePalo tipo) {
        this.tipo = tipo;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public static int getTotalCartas() {
        return CARTAS_POR_PALO;
    }

}
