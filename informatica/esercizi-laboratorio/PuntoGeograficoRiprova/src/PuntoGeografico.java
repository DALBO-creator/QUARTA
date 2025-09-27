public class PuntoGeografico {
    Angolo latitudine;
    Angolo longitudine;

    public PuntoGeografico(Angolo lat, Angolo longi) {
        this.latitudine = lat;
        this.longitudine = longi;
    }

    public Angolo getLatitudine() {
        return latitudine;
    }

    public Angolo getLongitudine() {
        return longitudine;
    }

    /*public Angolo sottrai(Angolo a1, Angolo a2) {
        int s = a1.getSecondi() - a2.getSecondi();
        int p = a1.getPrimi() - a2.getPrimi();
        int g = a1.getGradi() - a2.getGradi();

        if (s >= 60) {
            s -= 60;
            p += 1;
        }
        if (p >= 60) {
            p -= 60;
            g += 1;
        }
        return new Angolo(g, p, s);
    }*/

    public double distanza(PuntoGeografico altroPunto) {

        double deltaLat = (getLatitudine().toRadianti()) - (altroPunto.getLatitudine().toRadianti());
        double deltaLongi = (getLongitudine().toRadianti()) - (altroPunto.getLongitudine().toRadianti());

        double a = Math.pow(Math.sin(deltaLat / 2), 2) + (Math.cos(this.getLatitudine().toRadianti())) * (Math.cos(altroPunto.getLatitudine().toRadianti())) * (Math.pow(Math.sin(deltaLongi / 2), 2));

        double R = 6371000;

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = R * c;

        return d;

    }

    @Override
    public String toString() {
        String Latitudine = "Latitudine: " + this.getLatitudine().getGradi() + "°" + this.getLatitudine().getPrimi() + "'" + this.getLatitudine().getSecondi() + "''";
        String Longitudine = "Longitudine: " + this.getLongitudine().getGradi() + "°" + this.getLongitudine().getPrimi() + "'" + this.getLongitudine().getSecondi() + "''";
        if (Latitudine.indexOf('-') != -1) {
            Latitudine = Latitudine.replace("-", "");
            Latitudine += " S";
        }
        else{
            Latitudine += " N";
        }

        if (Longitudine.indexOf('-') != -1) {
            Longitudine = Longitudine.replace("-", "");
            Longitudine += " W";
        }
        else{
            Longitudine += " E";
        }

        return Latitudine + "\n" + Longitudine;
    }

}
