public class Segmento {
    private PuntoGeometrico a;
    private PuntoGeometrico b;
    public Segmento(PuntoGeometrico p1, PuntoGeometrico p2){
        this.a = p1;
        this.b=p2;
    }
    public Segmento (Segmento copia){
        this.a = copia.a;
        this.b= copia.b;
    }

    private int orientamento(PuntoGeometrico p, PuntoGeometrico q, PuntoGeometrico r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (Math.abs(val) < 1e-10) return 0; // collineari
        return (val > 0) ? 1 : 2; // 1 = orario, 2 = antiorario
    }

    private boolean onSegment(PuntoGeometrico p, PuntoGeometrico q, PuntoGeometrico r) {
        return q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
                q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY());
    }

    public boolean Interseca(Segmento s) {
        PuntoGeometrico p1 = this.a;
        PuntoGeometrico q1 = this.b;
        PuntoGeometrico p2 = s.a;
        PuntoGeometrico q2 = s.b;

        int o1 = orientamento(p1, q1, p2);
        int o2 = orientamento(p1, q1, q2);
        int o3 = orientamento(p2, q2, p1);
        int o4 = orientamento(p2, q2, q1);

        // Caso generale
        if (o1 != o2 && o3 != o4)
            return true;

        // Casi speciali (collineari + sovrapposizione)
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false; // Nessuna intersezione
    }

    public void ruotaOrigine(double alphaGradi) {
        this.a.ruota(alphaGradi);
        this.b.ruota(alphaGradi);
    }

    public void ruotaEstremo(double alphaGradi, int estremo) {
        if (estremo == 1) {

            double dx = b.getX() - a.getX();
            double dy = b.getY() - a.getY();

            double rad = Math.toRadians(alphaGradi);
            double xRuotato = dx * Math.cos(rad) - dy * Math.sin(rad);
            double yRuotato = dx * Math.sin(rad) + dy * Math.cos(rad);

            b = new PuntoGeometrico(a.getX() + xRuotato, a.getY() + yRuotato);
        } else if (estremo == 2) {

            double dx = a.getX() - b.getX();
            double dy = a.getY() - b.getY();

            double rad = Math.toRadians(alphaGradi);
            double xRuotato = dx * Math.cos(rad) - dy * Math.sin(rad);
            double yRuotato = dx * Math.sin(rad) + dy * Math.cos(rad);

            a = new PuntoGeometrico(b.getX() + xRuotato, b.getY() + yRuotato);
        }

    }

    @Override
    public String toString() {
        return "{" + a.toString() + ", " + b.toString() + "}";
    }

}
