package com.albo.lanciadadi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LanciaDadiController {

    private Dado current;
    private int number;


    @FXML
    public void initialize() {
        current = new Dado();
        number = 0;
    }

    @FXML
    private Label lblRisultato;
    @FXML
    private Label lblType;
    @FXML
    private Label lblNumber;

    @FXML
    private Button sixButton;
    @FXML
    private Button tenButton;
    @FXML
    private Button twentyButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;

    public void onLanciaButtonClick() {
        int sum = 0;
        for (int i = 0; i < this.number; i++) {
            sum+=current.lancia();
        }
        lblRisultato.setText("" + sum);
    }

    public void onSixButtonClick() {
        lblType.setText(sixButton.getText());
        current.setFacce(6);
    }

    public void onTenButtonClick() {
        lblType.setText(tenButton.getText());
            current.setFacce(10);
    }

    public void onTwentyButtonClick(ActionEvent actionEvent) {
        lblType.setText(twentyButton.getText());
        current.setFacce(20);
    }

    public void onOneButtonClick() {
        lblNumber.setText(oneButton.getText());
        this.number = 1;
    }

    public void onTwoButtonClick(ActionEvent actionEvent) {
        lblNumber.setText(twoButton.getText());
        this.number = 2;

    }

    public void onThreeButtonClick(ActionEvent actionEvent) {
        lblNumber.setText(threeButton.getText());
        this.number = 3;

    }
}