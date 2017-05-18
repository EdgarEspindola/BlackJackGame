package com.kadasoftware;

public class Carta {

    private TiposCartas tipoCarta;
    private TiposDePalo tipoPalo;
    private static final int POSICION_VALOR_DEFAULT = 0;
    private int valor;

    public Carta(TiposCartas tipoCarta, TiposDePalo nombrePalo) {
        this.tipoCarta = tipoCarta;
        this.tipoPalo = nombrePalo;
        this.valor = tipoCarta.getValores()[POSICION_VALOR_DEFAULT];
    }

    public String getNombre() {
        return this.tipoCarta.getNombre();
    }

    public void setTipoCarta(TiposCartas tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public TiposDePalo getTipoPalo() {
        return tipoPalo;
    }

    public void setTipoPalo(TiposDePalo tipoPalo) {
        this.tipoPalo = tipoPalo;
    }

    public int[] getValores() {
        return this.tipoCarta.getValores();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.getNombre() + " de " + this.getTipoPalo() + " (" + this.getValor() + ")";
    }
}
