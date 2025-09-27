public class Punto {
    private Angolo latitudine;
    private Angolo longitudine;

    Punto(Angolo lat, Angolo longi) {

    }

    public double distanza(Punto altroPunto) {

        public Angolo sottrai(Angolo a1, Angolo a2)



        Angolo deltaLat = differenzaA(this.latitudine, altroPunto.latitudine);
        Angolo deltaLongi= differenzaA(this.longitudine, altroPunto.longitudine);

        double a = Math.pow(Math.sin(deltaLat / 2), 2) + (Math.cos(this.latitudine))*(Math.cos(altroPunto.latitudine)) * (Math.pow(Math.sin(deltaLongi / 2), 2));

        double R = 6371000;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = R * c;

        return d;
    }
}
