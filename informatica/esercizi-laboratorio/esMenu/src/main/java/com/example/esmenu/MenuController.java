package com.example.esmenu;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class MenuController {

    @FXML private CheckBox pChe0,pChe1,pChe2,pChe3;
    @FXML private CheckBox bChe0,bChe1,bChe2,bChe3;

    @FXML private Label pLbl0,pLbl1,pLbl2,pLbl3;
    @FXML private Label bLbl0,bLbl1,bLbl2,bLbl3;

    @FXML private Label lblPrezzo;

    private Menu menu = new Menu();

    private ArrayList<CheckBox> pCheck = new ArrayList<>();
    private ArrayList<CheckBox> bCheck = new ArrayList<>();

    private ArrayList<Label> pLbl = new ArrayList<>();
    private ArrayList<Label> bLbl = new ArrayList<>();

    private ArrayList<String> nomiPiatti;
    private ArrayList<String> nomiBevande;

    private ArrayList<Float> prezziPiatti;
    private ArrayList<Float> prezziBevande;

    @FXML
    public void initialize(){

        // checkbox
        pCheck.add(pChe0);
        pCheck.add(pChe1);
        pCheck.add(pChe2);
        pCheck.add(pChe3);

        bCheck.add(bChe0);
        bCheck.add(bChe1);
        bCheck.add(bChe2);
        bCheck.add(bChe3);

        // label
        pLbl.add(pLbl0);
        pLbl.add(pLbl1);
        pLbl.add(pLbl2);
        pLbl.add(pLbl3);

        bLbl.add(bLbl0);
        bLbl.add(bLbl1);
        bLbl.add(bLbl2);
        bLbl.add(bLbl3);

        // nomi e prezzi
        nomiPiatti = new ArrayList<>(menu.getPiatti().keySet());
        nomiBevande = new ArrayList<>(menu.getBevande().keySet());

        prezziPiatti = new ArrayList<>(menu.getPiatti().values());
        prezziBevande = new ArrayList<>(menu.getBevande().values());

        for(int i=0;i<4;i++){
            pCheck.get(i).setText(nomiPiatti.get(i));
            pLbl.get(i).setText(String.format("%.2f €",prezziPiatti.get(i)));

            bCheck.get(i).setText(nomiBevande.get(i));
            bLbl.get(i).setText(String.format("%.2f €",prezziBevande.get(i)));
        }
    }

    @FXML
    private void onCalcolaButtonClick(){

        float totale = 0;

        for(int i=0;i<4;i++){

            if(pCheck.get(i).isSelected())
                totale += prezziPiatti.get(i);

            if(bCheck.get(i).isSelected())
                totale += prezziBevande.get(i);
        }

        lblPrezzo.setText(String.format("%.2f €",totale));
    }
}