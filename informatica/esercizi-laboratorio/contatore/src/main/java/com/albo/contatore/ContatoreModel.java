package com.albo.contatore;

public class ContatoreModel {
    private int contatore = 0;

    public void next(){
        this.contatore++;
    }

    @Override
    public String toString(){
        return "" + contatore;
    }
}

