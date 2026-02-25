package com.albo.oroscopo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

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
        int scelta = new Random().nextInt(4);
        String ritorno = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/albo/oroscopo/oroscopo.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parti = linea.split("\\|");

                String segnoFile = parti[0];
                int numeroFile = Integer.parseInt(parti[1]);
                String frase = parti[2];

                if (segnoFile.equals(segno) && numeroFile == scelta) {
                    ritorno = frase;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ritorno;
    }


}
