package com.albo.bandierefx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Gestore {

    public static List<Scelta> caricaDomande() {

        List<Scelta> lista = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("elenco.txt"));

            String riga = br.readLine();

            while (riga != null) {

                String[] p = riga.split(",");

                if (p.length == 6) {

                    Scelta s = new Scelta(
                            p[0],
                            p[1],
                            p[2],
                            p[3],
                            p[4],
                            p[5]
                    );

                    lista.add(s);
                }

                riga = br.readLine();
            }

            br.close();

        } catch (Exception e) {
            System.out.println("File elenco.txt non trovato");
        }

        return lista;
    }
}
