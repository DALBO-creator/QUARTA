package com.albo.oroscopo;

import java.time.LocalDate;

public class Oroscopo {
    private LocalDate dataNascita;

    public Oroscopo(LocalDate dataNascita){
        this.dataNascita = dataNascita;
    }

    public String getSegnoZodiacale(){
        int giorno = dataNascita.getDayOfMonth();
        int mese = dataNascita.getMonthValue();

        if ((mese == 3 && giorno >= 21) || (mese == 4 && giorno <= 19)) {
            return "Ariete";
        } else if ((mese == 4 && giorno >= 20) || (mese == 5 && giorno <= 20)) {
            return "Toro";
        } else if ((mese == 5 && giorno >= 21) || (mese == 6 && giorno <= 20)) {
            return "Gemelli";
        } else if ((mese == 6 && giorno >= 21) || (mese == 7 && giorno <= 22)) {
            return "Cancro";
        } else if ((mese == 7 && giorno >= 23) || (mese == 8 && giorno <= 22)) {
            return "Leone";
        } else if ((mese == 8 && giorno >= 23) || (mese == 9 && giorno <= 22)) {
            return "Vergine";
        } else if ((mese == 9 && giorno >= 23) || (mese == 10 && giorno <= 22)) {
            return "Bilancia";
        } else if ((mese == 10 && giorno >= 23) || (mese == 11 && giorno <= 21)) {
            return "Scorpione";
        } else if ((mese == 11 && giorno >= 22) || (mese == 12 && giorno <= 21)) {
            return "Sagittario";
        } else if ((mese == 12 && giorno >= 22) || (mese == 1 && giorno <= 19)) {
            return "Capricorno";
        } else if ((mese == 1 && giorno >= 20) || (mese == 2 && giorno <= 18)) {
            return "Acquario";
        } else {
            return "Pesci";
        }
    }
    public String getOroscopo() {
        String segno = getSegnoZodiacale();

        switch (segno) {
            case "Ariete":
                return "Giornata piena di energia. Ottimo momento per iniziare qualcosa di nuovo.";
            case "Toro":
                return "Serve pazienza, ma i risultati arriveranno. Attenzione alle spese.";
            case "Gemelli":
                return "Comunicazione al top. Un confronto chiarirà molte cose.";
            case "Cancro":
                return "Le emozioni guidano le tue scelte. Ascoltati, ma resta con i piedi per terra.";
            case "Leone":
                return "Sei al centro dell’attenzione. Usa il tuo carisma con intelligenza.";
            case "Vergine":
                return "Precisione e organizzazione ti faranno brillare oggi.";
            case "Bilancia":
                return "Cerca equilibrio nelle relazioni. Una decisione va presa.";
            case "Scorpione":
                return "Giornata intensa. Segui l’istinto, ma evita gli eccessi.";
            case "Sagittario":
                return "Voglia di libertà e novità. Ottimo momento per fare progetti.";
            case "Capricorno":
                return "Il lavoro richiede impegno, ma la costanza verrà premiata.";
            case "Acquario":
                return "Idee brillanti e originali. Condividile senza paura.";
            case "Pesci":
                return "Sensibilità accentuata. Creatività e intuizione in primo piano.";
            default:
                return "Le stelle sono confuse oggi… riprova domani!";
        }
    }


}
