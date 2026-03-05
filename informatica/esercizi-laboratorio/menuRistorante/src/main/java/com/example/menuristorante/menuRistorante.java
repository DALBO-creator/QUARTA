package com.example.menuristorante;

public class menuRistorante {

    private double prezzoPizza = 8;
    private double prezzoPasta = 7;
    private double prezzoAcqua = 2;
    private double prezzoBibita = 3;
    private double prezzoDolce = 4;

    public double calcolaTotale(boolean pizza, boolean pasta, boolean acqua, boolean bibita, boolean dolce) {

        double totale = 0;

        if (pizza) {
            totale += prezzoPizza;
        }

        if (pasta) {
            totale += prezzoPasta;
        }

        if (acqua) {
            totale += prezzoAcqua;
        }

        if (bibita) {
            totale += prezzoBibita;
        }

        if (dolce) {
            totale += prezzoDolce;
        }

        return totale;
    }
}