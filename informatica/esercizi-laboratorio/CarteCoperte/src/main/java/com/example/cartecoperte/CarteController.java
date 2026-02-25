package com.example.cartecoperte;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarteController {

    @FXML
    private Label lblMessaggio;

    @FXML
    private ImageView imgCarta1;
    @FXML
    private ImageView imgCarta2;
    @FXML
    private ImageView imgCarta3;

    @FXML
    private Button btnShuffle;

    private List<Image> listaImmagini = new ArrayList<>();
    private List<String> listaNomi = new ArrayList<>();

    private int indiceAsso;
    private boolean partitaAttiva = false;

    private Image imgDorso;


    @FXML
    public void initialize() {

        imgDorso = new Image(getClass().getResourceAsStream("/imgs/dorso.jpg"));

        listaImmagini.add(new Image(getClass().getResourceAsStream("/imgs/asso.jpg")));
        listaImmagini.add(new Image(getClass().getResourceAsStream("/imgs/donna.jpg")));
        listaImmagini.add(new Image(getClass().getResourceAsStream("/imgs/re.png")));

        listaNomi.add("asso");
        listaNomi.add("donna");
        listaNomi.add("re");

        mostraCarteScoperte();
        lblMessaggio.setText("Osserva le carte e premi \"Mescola\"");
    }


    @FXML
    protected void shuffle() {

        List<Integer> indici = new ArrayList<>();
        indici.add(0);
        indici.add(1);
        indici.add(2);

        Collections.shuffle(indici);

        List<Image> immaginiMescolate = new ArrayList<>();
        List<String> nomiMescolati = new ArrayList<>();

        for (int i : indici) {
            immaginiMescolate.add(listaImmagini.get(i));
            nomiMescolati.add(listaNomi.get(i));
        }

        listaImmagini = immaginiMescolate;
        listaNomi = nomiMescolati;

        indiceAsso = listaNomi.indexOf("asso");

        mostraDorsi();
        lblMessaggio.setText("Trova l'Asso!");
        partitaAttiva = true;
    }


    @FXML
    protected void mostraCarta1() { verificaScelta(0); }

    @FXML
    protected void mostraCarta2() { verificaScelta(1); }

    @FXML
    protected void mostraCarta3() { verificaScelta(2); }


    private void verificaScelta(int scelta) {

        if (!partitaAttiva) return;

        mostraCarteScoperte();

        if (scelta == indiceAsso) {
            lblMessaggio.setText("Bravo! Hai trovato l'Asso!");
        } else {
            lblMessaggio.setText("Sbagliato! L'Asso era in posizione " + (indiceAsso + 1));
        }

        partitaAttiva = false;
    }


    private void mostraCarteScoperte() {
        imgCarta1.setImage(listaImmagini.get(0));
        imgCarta2.setImage(listaImmagini.get(1));
        imgCarta3.setImage(listaImmagini.get(2));
    }

    private void mostraDorsi() {
        imgCarta1.setImage(imgDorso);
        imgCarta2.setImage(imgDorso);
        imgCarta3.setImage(imgDorso);
    }
}
