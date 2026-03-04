package com.albo.escodicefiscale;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        String datastr = "2008-11-17";

        LocalDate data =  LocalDate.parse(datastr);
        CodiceFiscale cf = new CodiceFiscale("davide", "albo", data , "maschio");
        System.out.println(cf.calcolaCognome());
        System.out.println(cf.calcolaNome());
        System.out.println(cf.calcolaAnno());
        System.out.println(cf.calcolaMese());
        System.out.println(cf.calcoloGiornoSesso());
        System.out.println(cf.calcoloComune());
        System.out.println(cf.calcoloControllo());

    }


}
