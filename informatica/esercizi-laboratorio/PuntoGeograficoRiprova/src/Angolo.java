public class Angolo {
    private double gradi;
    private double primi;
    private double secondi;


    public Angolo(double gradi, double primi, double secondi) {
        this.gradi = gradi;
        this.primi = primi;
        this.secondi = secondi;
    }

    public double getGradi(){
        return gradi;
    }
    public double getPrimi(){
        return primi;
    }
    public double getSecondi() {
        return secondi;
    }

    public double toDecimali(){
        return gradi+(primi/60)+(secondi/3600);
        }
    public double toRadianti(){
        return Math.toRadians(toDecimali());
    }


}

