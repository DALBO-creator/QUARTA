public class playlist {
    private String nome;
    private int canzoni;
    private int status;
    private int corrente;

    public playlist(String nome, int N) {
        this.nome = nome;
        this.canzoni = N;
        this.status = 0;
        this.corrente = 1;
    }

    playlist (playlist copiaPlaylist){
        this.nome = copiaPlaylist.nome;
        this.canzoni = copiaPlaylist.canzoni;
        this.status = copiaPlaylist.status;
        this.corrente = copiaPlaylist.corrente;
    }

    public String getNome() {
        return this.nome;
    }
    public int getQuantiBrani() {
        return this.canzoni;
    }

    public void play(){
        this.status = 1;
    }
    public void pause(){
        if (this.status != 0){
            this.status = 2;
        }

    }
    public void stop(){
        if (this.status == 0){
            this.corrente = 1;
        }
        this.status = 0;
    }
    public void branoSuccessivo() {
        if (this.corrente == this.canzoni) {
            this.corrente = 1;
        } else {
            this.corrente++;

        }
    }

    public void branoPrecedente(){
        if (this.corrente == 1) {
            this.corrente = this.canzoni;
        } else {
            this.corrente--;

        }
    }

    @Override
    public String toString() {
        return "Playlist" + this.getNome() + " , " + this.canzoni + " brani, in " + this.status + " , " + this.corrente;
    }





}
