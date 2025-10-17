public class Televisore {
    private final int MAX_CANALE = 999;
    private int attuale;
    private boolean acceso;
    private int volume;

    public Televisore() {
        this.attuale = 1;
        this.acceso = false;
        this.volume = 10;
    }

    public boolean accendi() {
        this.acceso = true;
        return true;
    }

    public boolean spegni() {
        this.acceso = false;
        return true;
    }

    public boolean isAcceso() {
        return this.acceso;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getCanale() {
        return this.attuale;
    }

    public boolean setVolume(int vol) {
        if (this.acceso && vol >= 0 && vol <= 100) {
            this.volume = vol;
            return true;
        }
        return false;
    }

    public boolean canaleSuccessivo() {
        if (!this.acceso) return false;

        if (this.attuale == MAX_CANALE) {
            this.attuale = 1;
        } else {
            this.attuale++;
        }
        return true;
    }

    public boolean canalePrecedente() {
        if (!this.acceso) return false;

        if (this.attuale == 1) {
            this.attuale = MAX_CANALE;
        } else {
            this.attuale--;
        }
        return true;
    }

    public boolean selezionaCanale(int canale) {
        if (this.acceso && canale >= 1 && canale <= MAX_CANALE) {
            this.attuale = canale;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.acceso) {
            return "Il televisore è acceso, sul canale " + this.attuale + " con il volume a " + this.volume;
        } else {
            return "Il televisore è spento";
        }
    }
}
