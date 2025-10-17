public class Ascensore {
    private int N;
    private int attuale;
    private boolean aperte;
    public Ascensore(int n) {
        if (n < 2) {
            n = 2;
        }
        this.N = n;
        this.attuale = 0;
        this.aperte = false;
    }
    public int getPiano(){
        return this.attuale;
    }
    public int getPiani(){
        return this.N;
    }
    public void Apri(){
        this.aperte=true;
    }
    public void Chiudi(){
        this.aperte=false;
    }
    public boolean Sali(){
        if (this.aperte){
            return false;
        }
        if (this.attuale==this.N){
            this.attuale=0;
            return true;
        }
        else{
            this.attuale++;
            return true;
        }
    }
    public boolean Scendi(){
        if (this.aperte||this.attuale==0){
            return false;
        }
        else{
            this.attuale--;
            return true;
        }
    }
    public boolean vaiAlPiano(int p){
        if (p<0||p>N||this.aperte){
            return false;
        }
        else{
            this.attuale=p;
            return true;
        }
    }

    @Override
    public String toString(){
        String stato ="";
        String piano = "";
        if (this.aperte){
            stato += "aperte";
        }
        else{
            stato += "chiuse";
        }
        if (this.getPiano()==0){
            piano += "terra";
        }
        else{
            piano += this.getPiano();
        }

        return "L'ascensore serve " + this.getPiani() + " piani, attualmente si trova al piano " + piano + " e le porte sono " + stato;
    }


}
