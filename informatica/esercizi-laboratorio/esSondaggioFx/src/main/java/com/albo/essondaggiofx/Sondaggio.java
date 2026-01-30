package com.albo.essondaggiofx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sondaggio {
    private List<String> opzioni;
    private Map<String, Integer> votazioni;

    public Sondaggio(){
        opzioni = new ArrayList<>();
        votazioni = new HashMap<>();
    }

    public void aggiungiOpzione(String o){
        opzioni.add(o);
        votazioni.put(o, 0);
    }

    public void vota(String o){
        int voti_attuali = votazioni.get(o);
        votazioni.put(o, voti_attuali + 1);
    }

    @Override
    public String toString(){
        String s = "Risultato sondaggio: \n";
        for(String o : opzioni){
            s += o + " -> " + votazioni.get(o) + "\n";
        }
        return s;
    }
}
