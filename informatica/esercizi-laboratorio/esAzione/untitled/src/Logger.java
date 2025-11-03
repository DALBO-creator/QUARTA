import java.time.LocalDateTime;

public class Logger {
    private Azione[] azioni;
    private int count; // Numero di azioni memorizzate

    public Logger(int maxAzioni) {
        azioni = new Azione[maxAzioni];
        count = 0;
    }

    public void add(Azione a) {
        if (count < azioni.length) {
            azioni[count] = a;
            count++;
        } else {
            System.out.println("Logger pieno! Impossibile aggiungere altre azioni.");
        }
    }

    public Azione get(int index) {
        if (index >= 0 && index < count) {
            return azioni[index];
        }
        return null;
    }

    public Azione[] getByAttenzione(int livello) {
        if (livello < 1 || livello > 5 || count == 0) {
            return new Azione[0];
        }

        int n = 0;
        for (int i = 0; i < count; i++) {
            if (azioni[i].getLivelloAttenzione() == livello) {
                n++;
            }
        }

        if (n == 0) {
            return new Azione[0];
        }

        Azione[] risultato = new Azione[n];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (azioni[i].getLivelloAttenzione() == livello) {
                risultato[j] = azioni[i];
                j++;
            }
        }

        return risultato;
    }

    public int size() {
        return count;
    }

    // True se non ci sono azioni
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        if (count == 0) {
            return "Nessuna azione registrata.";
        }

        // Conta quante azioni per ogni livello
        int[] livelli = new int[6]; // da 1 a 5
        for (int i = 0; i < count; i++) {
            int livello = azioni[i].getLivelloAttenzione();
            if (livello >= 1 && livello <= 5) {
                livelli[livello]++;
            }
        }

        String risultato = "Numero totale di azioni: " + count + "\n";
        for (int i = 1; i <= 5; i++) {
            risultato = risultato + "Livello " + i + " : " + livelli[i] + " azioni\n";
        }

        LocalDateTime prima = azioni[0].getDataOra();
        LocalDateTime ultima = azioni[count - 1].getDataOra();

        String ora1 = "";
        if (prima.getHour() < 10) ora1 = "0" + prima.getHour();
        else ora1 = "" + prima.getHour();

        String min1 = "";
        if (prima.getMinute() < 10) min1 = "0" + prima.getMinute();
        else min1 = "" + prima.getMinute();

        String sec1 = "";
        if (prima.getSecond() < 10) sec1 = "0" + prima.getSecond();
        else sec1 = "" + prima.getSecond();

        String ora2 = "";
        if (ultima.getHour() < 10) ora2 = "0" + ultima.getHour();
        else ora2 = "" + ultima.getHour();

        String min2 = "";
        if (ultima.getMinute() < 10) min2 = "0" + ultima.getMinute();
        else min2 = "" + ultima.getMinute();

        String sec2 = "";
        if (ultima.getSecond() < 10) sec2 = "0" + ultima.getSecond();
        else sec2 = "" + ultima.getSecond();

        risultato = risultato +
                "Le azioni sono state memorizzate a partire dalle ore " +
                ora1 + ":" + min1 + ":" + sec1 +
                " del " + prima.toLocalDate() + "\n";

        risultato = risultato +
                "fino alle ore " +
                ora2 + ":" + min2 + ":" + sec2 +
                " del " + ultima.toLocalDate();

        return risultato;
    }
}