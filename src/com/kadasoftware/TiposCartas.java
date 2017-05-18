package com.kadasoftware;

public enum TiposCartas {
    AS("AS", 1, 11),
    DOS("2", 2),
    TRES("3", 3),
    CUATRO("4", 4),
    CINCO("5", 5),
    SEIS("6", 6),
    SIETE("7", 7),
    OCHO("8", 8),
    NUEVE("9", 9),
    DIEZ("10", 10),
    J("CABALLERO", 10),
    Q("REYNA", 10),
    K("REY", 10);

    private final String nombre;
    private final int[] valores;
    private static final int totalCartas = 13;

    TiposCartas(String nombre, int... valores) {
        this.nombre = nombre;
        this.valores = valores;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getValores() {
        return valores;
    }

    public static int getTotalCartas() {
        return totalCartas;
    }

}
