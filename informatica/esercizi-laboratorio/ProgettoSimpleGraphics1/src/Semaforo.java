import graphics.*;

public class Semaforo {
    private boolean stato;
    private int luce; // 1 = verde, 2 = giallo, 3 = rosso
    private Rectangle box;
    private Ellipse rosso, giallo, verde;

    public Semaforo() {
        this.stato = false;
        this.luce = 1;

        this.box = new Rectangle(180, 10, 120, 300);
        this.box.setColor(Color.BLACK);
        this.box.fill();

        this.rosso = new Ellipse(200, 30, 80, 80);
        this.giallo = new Ellipse(200, 120, 80, 80);
        this.verde = new Ellipse(200, 210, 80, 80);

        this.rosso.setColor(Color.GRAY);
        this.giallo.setColor(Color.GRAY);
        this.verde.setColor(Color.GRAY);
        this.rosso.fill();
        this.giallo.fill();
        this.verde.fill();
    }

    public void accendi() {
        this.stato = true;
        this.luce = 1;
        aggiornaColori();
    }

    public void spegni() {
        this.stato = false;
        this.rosso.setColor(Color.GRAY);
        this.giallo.setColor(Color.GRAY);
        this.verde.setColor(Color.GRAY);
        this.rosso.fill();
        this.giallo.fill();
        this.verde.fill();
    }

    public void toggle() {
        this.stato = !this.stato;
        if (!this.stato) {
            spegni();
        } else {
            aggiornaColori();
        }
    }

    public void avanza() {
        if (this.stato) {
            this.luce++;
            if (this.luce > 3) {
                this.luce = 1;
            }
            aggiornaColori();
        }
    }

    private void aggiornaColori() {
        this.rosso.setColor(Color.GRAY);
        this.giallo.setColor(Color.GRAY);
        this.verde.setColor(Color.GRAY);

        if (this.luce == 1) this.verde.setColor(Color.GREEN);
        else if (this.luce == 2) this.giallo.setColor(Color.YELLOW);
        else if (this.luce == 3) this.rosso.setColor(Color.RED);

        this.rosso.fill();
        this.giallo.fill();
        this.verde.fill();
    }

    public boolean isAcceso() {
        return this.stato;
    }

    public String getColore() {
        if (!this.stato) return "spento";
        if (this.luce == 1) return "verde";
        else if (this.luce == 2) return "giallo";
        else return "rosso";
    }

    @Override
    public String toString() {
        if (this.stato)
            return "Il semaforo è acceso sul " + getColore();
        else
            return "Il semaforo è spento";
    }
}
