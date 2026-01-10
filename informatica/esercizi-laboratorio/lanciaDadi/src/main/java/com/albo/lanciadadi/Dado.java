package com.albo.lanciadadi;

import java.util.Random;

public class Dado {

    private int facce;
    private int valore;
    private static final Random random = new Random();

    public Dado() {
        this(6);
    }

    public Dado(int facce) {
        if (facce < 2 || facce == 3) {
            this.facce = 6;
        } else {
            this.facce = facce;
        }
    }

    public void setFacce(int facce) {
        this.facce = facce;
    }

    public Dado(Dado altro) {
        this.facce = altro.facce;
        this.valore = altro.valore;
    }

    public int lancia() {
        valore = random.nextInt(facce) + 1;
        return valore;
    }

    public int getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return "" + valore;
    }
}
