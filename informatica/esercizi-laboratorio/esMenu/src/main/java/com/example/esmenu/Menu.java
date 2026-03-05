package com.example.esmenu;

import java.util.HashMap;
import java.util.Random;

public class Menu {

    private HashMap<String, Float> piatti = new HashMap<>();
    private HashMap<String, Float> bevande = new HashMap<>();

    public Menu() {
        Random rd = new Random();

        piatti.put("Pasta al pomodoro", rd.nextFloat() * 20);
        piatti.put("Pizza margherita", rd.nextFloat() * 20);
        piatti.put("Risotto ai funghi", rd.nextFloat() * 20);
        piatti.put("Bistecca alla griglia", rd.nextFloat() * 20);

        bevande.put("Acqua naturale", rd.nextFloat() * 10);
        bevande.put("Acqua frizzante", rd.nextFloat() * 10);
        bevande.put("Coca Cola", rd.nextFloat() * 10);
        bevande.put("Birra", rd.nextFloat() * 10);
    }

    public HashMap<String, Float> getPiatti() {
        return piatti;
    }

    public HashMap<String, Float> getBevande() {
        return bevande;
    }
}