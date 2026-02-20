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

    public String calcolaCognome(String cognome) {
    StringBuilder ris = new StringBuilder();
    cognome = cognome.toLowerCase();

    
    for (int i = 0; i < cognome.length(); i++) {
        char c = cognome.charAt(i);
        if (!vocali.contains(c) && Character.isLetter(c)) {
            ris.append(Character.toUpperCase(c));
        }
        if (ris.length() == 3) break;
    }

    
    if (ris.length() < 3) {
        for (int i = 0; i < cognome.length(); i++) {
            char c = cognome.charAt(i);
            if (vocali.contains(c)) {
                ris.append(Character.toUpperCase(c));
            }
            if (ris.length() == 3) break;
        }
    }

    
    while (ris.length() < 3) {
        ris.append("X");
    }

    return ris.toString();
    }


    public String calcolaNome(String nome) {
    StringBuilder ris = new StringBuilder();
    nome = nome.toLowerCase();

    ArrayList<Character> consonanti = new ArrayList<>();
    ArrayList<Character> vocaliNome = new ArrayList<>();

    for (int i = 0; i < nome.length(); i++) {
        char c = nome.charAt(i);
        if (Character.isLetter(c)) {
            if (!vocali.contains(c)) {
                consonanti.add(c);
            } else {
                vocaliNome.add(c);
            }
        }
    }

    
    if (consonanti.size() >= 4) {
        ris.append(Character.toUpperCase(consonanti.get(0)));
        ris.append(Character.toUpperCase(consonanti.get(2)));
        ris.append(Character.toUpperCase(consonanti.get(3)));
    } else {
        for (char c : consonanti) {
            ris.append(Character.toUpperCase(c));
        }
        for (char c : vocaliNome) {
            if (ris.length() < 3)
                ris.append(Character.toUpperCase(c));
        }
    }

    while (ris.length() < 3) {
        ris.append("X");
    }

    return ris.toString();
    }

    public String calcolaAnno(LocalDate data) {
    int anno = data.getYear();
    return String.valueOf(anno).substring(2);
    }

    

}



