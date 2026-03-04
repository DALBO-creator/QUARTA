package com.albo.escodicefiscale;


import java.time.LocalDate;
import java.util.*;

public class CodiceFiscale {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String sesso;
    private Character controllo;

    public CodiceFiscale ( String nome, String cognome, LocalDate dataNascita, String sesso){
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.controllo = 'c';
    }

    public HashSet<Character> vocali = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public String calcolaCognome() {
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


    public String calcolaNome() {
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

    public String calcolaAnno() {
    int anno = dataNascita.getYear();
    return String.valueOf(anno).substring(2);
    }

    public String calcolaMese() {
        String[] corrispondenza = {"A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S", "T"};
        int mese = dataNascita.getMonthValue();
        return corrispondenza[mese - 1];

    }

    public String calcoloGiornoSesso(){
        Integer giorno = dataNascita.getDayOfMonth();
        String giornoStr = giorno.toString();

        if (sesso.equals("mascio")) {
            return String.format("%02d", giorno);
        }
        else {
            giorno += 40;
            return giorno.toString();
        }

    }

    public String calcoloComune(){
        return "B157";
    }

    public String generaPrimi15() {
        return calcolaCognome()
                + calcolaNome()
                + calcolaAnno()
                + calcolaMese()
                + calcoloGiornoSesso()
                + calcoloComune();
    }
    public char calcoloControllo() {
        String primi15 = generaPrimi15().toUpperCase();
        int somma = 0;

        // Tabelle ufficiali Agenzia delle Entrate
        int[] dispari = {1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23};
        int[] pari = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};

        for (int i = 0; i < 15; i++) {
            char c = primi15.charAt(i);
            int index;

            if (Character.isDigit(c)) {
                index = c - '0';
            } else {
                index = c - 'A';
            }

            // i=0 è la prima posizione (dispari per l'algoritmo, che conta da 1)
            if ((i + 1) % 2 == 0) {
                somma += pari[index];
            } else {
                somma += dispari[index];
            }
        }

        return (char) ('A' + (somma % 26));
    }






    

}



