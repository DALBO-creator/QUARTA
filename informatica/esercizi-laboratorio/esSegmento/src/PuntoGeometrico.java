public class PuntoGeometrico {
    private double x;
    private double y;

    public PuntoGeometrico () {
        this.x=0.0;
        this.y=0.0;
    }

    public PuntoGeometrico (double x1, double y1){
        this.x=x1;
        this.y=y1;
    }

    public PuntoGeometrico (PuntoGeometrico puntoCopia){
        this.x=puntoCopia.x;
        this.y=puntoCopia.y;
    }

    public double Distanza(PuntoGeometrico p1, PuntoGeometrico p2){
        double distanza = Math.sqrt(Math.pow(((Math.max(p1.x,p2.x))-(Math.min(p1.x,p2.x))), 2)+Math.pow(((Math.max(p1.y,p2.y))-(Math.min(p1.y,p2.y))), 2));
        return distanza;
    }

    public PuntoGeometrico PuntoMedio(PuntoGeometrico p2) {
        double m1 = (this.x + p2.x) / 2;
        double m2 = (this.y + p2.y) / 2;

        PuntoGeometrico pm = new PuntoGeometrico();
        pm.x = m1;
        pm.y = m2;

        return pm;
    }

    /* per rutotare un angolo rispetto all'origine si usa:
    {x′=x⋅cos(α)−y⋅sin(α)
    {y′=x⋅sin(α)+y⋅cos(α)

    alpha va trasformato da gradi a radianti (uso la funzione Math.toRadians()

    */
    public void ruota(double alphaGradi) {
        double alphaRadianti = Math.toRadians(alphaGradi);

        double nuovoX = x * Math.cos(alphaRadianti) - y * Math.sin(alphaRadianti);
        double nuovoY = x * Math.sin(alphaRadianti) + y * Math.cos(alphaRadianti);

        this.x = nuovoX;
        this.y = nuovoY;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override

    public String toString(){
        return "coordinate: (" + this.x + ";" +this.y +")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PuntoGeometrico)) {
            return false;
        }
        PuntoGeometrico other = (PuntoGeometrico) obj;
        return this.x == other.getX() && this.y == other.getY();
    }

}

