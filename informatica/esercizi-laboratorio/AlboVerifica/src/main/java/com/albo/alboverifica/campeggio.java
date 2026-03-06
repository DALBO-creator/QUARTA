package com.albo.alboverifica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class campeggio {

    private String[] prenotazioni = new String[31];
    public double calcolaPrezzo(LocalDate inizio, LocalDate fine, String tipo, boolean animali, int adulti, int bambini){
        long giorni = ChronoUnit.DAYS.between(inizio,fine);
        boolean alta = inizio.getMonthValue() >= 6 && inizio.getMonthValue() <= 8;
        double prezzoPiazzola = 0;

        if(tipo.equals("BASIC")){
            if(alta) {
                prezzoPiazzola = 42.50;
            }
            else{
                prezzoPiazzola = 36.50;
            }
        }

        if(tipo.equals("COMFORT")){
            if(alta) {
                prezzoPiazzola = 45.00;
            }
            else{
                prezzoPiazzola = 40.50;
            }
        }

        if(tipo.equals("COMFORT PLUS")){
            if(alta) {
                prezzoPiazzola = 50.00;
            }
            else{
                prezzoPiazzola = 43.00;
            }
        }

        double persone = giorni * (adulti * 12 + bambini * 7);
        double totale = prezzoPiazzola + persone;

        if(animali){
            totale += 5;
        }
        return totale;
    }

    public boolean aggiungiPrenotazione(String nome, int piazzola){
        if(piazzola < 1 || piazzola > 30){
            return false;
        }
        if(prenotazioni[piazzola] != null){
            return false;
        }
        prenotazioni[piazzola] = nome;
        return true;
    }

    public String visualizzaPrenotazioni(){

        String risultato = "";
        for(int i = 1; i <= 30; i++){
            if(prenotazioni[i] != null){
                risultato += "Piazzola " + i + " - " + prenotazioni[i] + "\n";
            }
        }
        if(risultato.equals("")){
            risultato = "Nessuna prenotazione";
        }
        return risultato;
    }
}
