package com.albo.escodicefiscale;


import java.time.LocalDate;
import java.util.*;

public class CodiceFiscale {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String sesso;
    private String luogo;
    private char controllo;

    public CodiceFiscale ( String nome, String cognome, LocalDate dataNascita, String sesso, String luogo){
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.luogo = luogo;
        this.controllo = 'c';
    }

    public HashSet<Character> vocali = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public String calcolaCognome (String cognome){
        String ris = "";
        for (int i = 0; i < cognome.length() ; i++) {
            if (!vocali.contains(i) && ris.length() < 3) {
                ris += i;
            }
        }
        while (ris.length() < 3){
            for (int i = 0; i < cognome.length() ; i++) {
                if (vocali.contains(i)) {
                    ris += i;
                }
            }
        }

        while (ris.length() < 3){
            ris += "x";
        }

        return ris;
    }

    public String calcolaNome (String nome){
        String ris = "";
        ArrayList<Character> consonanti = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nome.length(); i++) {
            if (!vocali.contains(i)){
                consonanti.add(nome.charAt(i));
                count++;
            }
        }
        if (count >= 4){
            ris += consonanti.get(0);
            ris += consonanti.get(2);
            ris += consonanti.get(3);
        }
        else {
            ris += consonanti.get(0);
            ris += consonanti.get(1);
            ris += consonanti.get(2);
        }
        if (nome.length() < 3){
            ris = "xxx";
        }
        return ris;
    }


}



