public class Frazione {
    private int numeratore;
    private int denominatore;

    public Frazione() {
        this.numeratore = 0;
        this.denominatore = 1;
    }

    public Frazione(int numeratore, int denominatore) {
        if (denominatore == 0) denominatore = 1;
        this.numeratore = numeratore;
        this.denominatore = denominatore;
        riduci();
    }

    public Frazione(Frazione altra) {
        this.numeratore = altra.numeratore;
        this.denominatore = altra.denominatore;
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
        riduci();
    }

    public void setDenominatore(int denominatore) {
        if (denominatore != 0) {
            this.denominatore = denominatore;
            riduci();
        }
    }

    public double toDouble() {
        return (double) numeratore / denominatore;
    }

    public Frazione somma(Frazione f) {
        int num = this.numeratore * f.denominatore + f.numeratore * this.denominatore;
        int den = this.denominatore * f.denominatore;
        return new Frazione(num, den);
    }

    public Frazione differenza(Frazione f) {
        int num = this.numeratore * f.denominatore - f.numeratore * this.denominatore;
        int den = this.denominatore * f.denominatore;
        return new Frazione(num, den);
    }

    public Frazione prodotto(Frazione f) {
        int num = this.numeratore * f.numeratore;
        int den = this.denominatore * f.denominatore;
        return new Frazione(num, den);
    }


    public Frazione quoziente(Frazione f) {
        int num = this.numeratore * f.denominatore;
        int den = this.denominatore * f.numeratore;
        return new Frazione(num, den);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Frazione)) return false;
        Frazione f = (Frazione) obj;
        Frazione ridotta1 = new Frazione(this.numeratore, this.denominatore);
        Frazione ridotta2 = new Frazione(f.numeratore, f.denominatore);
        ridotta1.riduci();
        ridotta2.riduci();
        return ridotta1.numeratore == ridotta2.numeratore &&
                ridotta1.denominatore == ridotta2.denominatore;
    }


    @Override
    public String toString() {
        riduci();
        if (denominatore == 1) {
            return String.valueOf(numeratore);
        } else {
            return numeratore + "/" + denominatore;
        }
    }

    private void riduci() {
        int mcd = mcd(Math.abs(numeratore), Math.abs(denominatore));
        numeratore /= mcd;
        denominatore /= mcd;


        if (denominatore < 0) {
            numeratore = -numeratore;
            denominatore = -denominatore;
        }
    }


    private int mcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
