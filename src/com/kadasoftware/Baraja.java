package com.kadasoftware;

import java.util.*;

public class Baraja {

    private String nombre;
    private List<Palo> palos;
    private Queue<Carta> mazo;
    private static final int PALOS_POR_BARAJA = 4;

    public Baraja() {
        this.nombre = "Baraja Inglesa";
        palos = new ArrayList<>(PALOS_POR_BARAJA);
        iniciarPalos();
    }

    public void barajear() {
        System.out.println(Utilerias.ANSI_GREEN + "Barajeando cartas, espere... " + Utilerias.ANSI_RESET);
        mazo = new ArrayDeque<>();
        Random randomPalo = new Random();
        Random randomCarta = new Random();
        while(mazo.size() != getTotalCartas()) {
            int posicionPalo = randomPalo.nextInt(PALOS_POR_BARAJA);
            int posicionCarta = randomCarta.nextInt(Palo.getTotalCartas());
            Carta carta = this.palos.get(posicionPalo).getCartas().get(posicionCarta);
            if(!mazo.contains(carta)) {
                mazo.add(carta);
            }
        }
        System.out.println(Utilerias.ANSI_GREEN + "Cartas listas" + Utilerias.ANSI_RESET);

    }

    public void imprimirPorPalos() {
        for(Palo palo: palos) {
            System.out.println("Cartas de " + palo.getTipo());
            System.out.println();
            for(Carta carta: palo.getCartas()) {
                String valores = "";
                for(int valor : carta.getValores()) {
                    valores += valor + ", ";
                }
                System.out.println(carta.getNombre() + " -> valores: " + valores);
            }
            System.out.println();
        }
    }

    public void imprimirBarajeada() {
        for (Carta carta : mazo) {
            String valores = "";
            for (int valor : carta.getValores()) {
                valores += valor + ", ";
            }
            System.out.println(carta.getNombre() + " de " + carta.getTipoPalo() + " -> valores: " + valores);
        }

    }

    public Carta obtenerCarta() {
        return this.mazo.poll();
    }

    private void iniciarPalos() {
        for(TiposDePalo tiposDePalo : TiposDePalo.values()) {
            palos.add(new Palo(tiposDePalo));
        }
    }

    private int getTotalCartas() {
        return PALOS_POR_BARAJA * TiposCartas.getTotalCartas();
    }

}
