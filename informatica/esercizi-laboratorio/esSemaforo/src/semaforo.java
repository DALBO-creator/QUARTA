public class semaforo {
    private boolean stato;
    private int luce;

    public semaforo() {
        this.stato = false;

    }
    public void accendi(){
        this.stato = true;
        this.luce = 1;
    }

    public void spegni(){
        this.stato = false;
    }

    public void toggle(){
        if (this.stato==true){
            this.stato = false;
        }
        else{
            this.stato=true;
        }
    }

    public void avanza(){
        if (this.stato==true) {
            this.luce += 1;
            if (this.luce>3){
                this.luce = 1;
            }
        }
    }

    public boolean isAcceso(){
        return this.stato;
    }

    public String getColore() {
        String colore = "";
        if (this.luce == 1) {
            colore += "verde";
        } else if (this.luce == 2) {
            colore += "giallo";
        } else if (this.luce == 3) {
            colore += "rosso";
        }
        return colore;
    }

    @Override
    public String toString(){
        String ritorno="";
        if (this.stato==true){
            ritorno += ("il semaforo è acceso sul " + this.getColore());
        }
        else{
            ritorno += ("il semaforo è spento");
        }

        return ritorno;
    }



}
