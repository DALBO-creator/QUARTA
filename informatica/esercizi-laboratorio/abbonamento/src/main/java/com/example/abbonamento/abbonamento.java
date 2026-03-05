package com.example.abbonamento;

import java.time.LocalDate;

public class abbonamento {

    public LocalDate calcolaFine(LocalDate inizio, int mesi){

        if(inizio == null){
            return null;
        }

        return inizio.plusMonths(mesi);
    }
}