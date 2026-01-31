package com.albo.bandierefx;

public class Scelta {

    private String url;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String corretta;

    public Scelta(String url, String op1, String op2, String op3, String op4, String corretta) {
        this.url = url;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.corretta = corretta;
    }

    public String getUrl() { return url; }
    public String getOp1() { return op1; }
    public String getOp2() { return op2; }
    public String getOp3() { return op3; }
    public String getOp4() { return op4; }

    public boolean verifica(String risposta) {
        if (risposta.equals(corretta)) {
            return true;
        } else {
            return false;
        }
    }
}
