public class Dado {

    private int faccieDado;

    Dado(){
        this.faccieDado = 6;
    }
    Dado(int N){
        if (N<2 || N==3) {
            this.faccieDado = 6;
        }
        else {
            this.faccieDado = N;
        }
    }
    Dado(Dado dadoCopia) {
        this.faccieDado = dadoCopia.faccieDado;
    }

    public int Lancia(){
        return (int) (Math.random() * 10 % this.faccieDado + 1);
    }

    @Override
    public String toString() {
        return "Faccie del dado: " + this.faccieDado;
    }
}
