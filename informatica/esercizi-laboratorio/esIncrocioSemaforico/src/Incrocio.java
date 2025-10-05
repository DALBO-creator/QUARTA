public class Incrocio {
    private Semaforo nord;
    private Semaforo sud;
    private Semaforo est;
    private Semaforo ovest;

    public Incrocio() {
        nord = new Semaforo();
        sud = new Semaforo();
        est = new Semaforo();
        ovest = new Semaforo();
    }

    public void accendi(){
        nord.accendi();
        sud.accendi();
        est.accendi();
        ovest.accendi();
        for (int i = 0; i < 2; i++) {
            nord.avanza();
            sud.avanza();
        }
    }

    public void spegni(){
        nord.spegni();
        sud.spegni();
        est.spegni();
        ovest.spegni();
    }

    public boolean isAcceso() {
        return nord.isAcceso() || sud.isAcceso() || est.isAcceso() || ovest.isAcceso();
    }


    public void avanza(char p){
        if (!isAcceso()) return;
        p = Character.toUpperCase(p);
        switch (p) {
            case 'N':
                if (!nord.getColore().equals("rosso") && !est.getColore().equals("verde") || !ovest.getColore().equals("verde")) {
                    nord.avanza();
                }
                break;
            case 'S':
                if (!sud.getColore().equals("rosso") && !est.getColore().equals("verde") || !ovest.getColore().equals("verde")) {
                    sud.avanza();
                }
                break;
            case 'E':
                if (!est.getColore().equals("rosso") && !nord.getColore().equals("verde") || !sud.getColore().equals("verde")) {
                    est.avanza();
                }
                break;
            case 'O':
                if (!ovest.getColore().equals("rosso") && !nord.getColore().equals("verde") || !sud.getColore().equals("verde")) {
                    ovest.avanza();
                }
                break;
            default:
                break;
        }

    }
    public String getColore(char p) {
        if (!isAcceso()) return "";

        p = Character.toUpperCase(p);

        switch (p) {
            case 'N': return nord.getColore();
            case 'S': return sud.getColore();
            case 'E': return est.getColore();
            case 'O': return ovest.getColore();
            default: return "";
        }
    }
    private String coloreSimbolo(Semaforo s){
            switch (s.getColore()) {
                case "verde":
                    return "V";
                case "giallo":
                    return "G";
                case "rosso":
                    return "R";
                default:
                    return " ";
            }
        }

        @Override
    public String toString() {
        String ritorno = "";
        ritorno += "        |     N |\n" +
                   "        |       |\n" +
                   "        |" + coloreSimbolo(nord)+ "      |\n" +
                "-------            -------\n" +
                "                   "+ coloreSimbolo(ovest) + "       \n"+
                "E                      O\n"+
                "     " + coloreSimbolo(est) + "                  \n" +
                "-------            -------\n" +
                   "        |      " + coloreSimbolo(sud)+ "|\n" +
                   "        |       |\n" +
                   "        |     S |\n";

                return ritorno;

    }

}
