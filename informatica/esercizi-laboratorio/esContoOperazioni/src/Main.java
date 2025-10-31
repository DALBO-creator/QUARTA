public class Main {
    public static void main(String[] args) {
        ContoCorrente conto = new ContoCorrente("Mario", "Rossi", "IT60X0542811101000000123456");

        conto.eseguiOperazione(new Operazione("Primo deposito", 2000, 2));
        conto.eseguiOperazione(new Operazione("Prelievo bancomat", 300, 1));
        conto.eseguiOperazione(new Operazione("Bonifico stipendio", 1200, 2));
        conto.eseguiOperazione(new Operazione("Affitto mensile", 1000, 1));
        conto.eseguiOperazione(new Operazione("Tentativo prelievo eccessivo", 10000, 1)); // non eseguita

        System.out.println("=== DATI CONTO ===");
        System.out.println(conto);

        System.out.println("\n=== OPERAZIONE [1] ===");
        Operazione op = conto.getOperazione(1);
        if (op != null) System.out.println(op);

        System.out.println("\nNumero operazioni eseguite: " + conto.getNumeroOperazioni());

        System.out.println("\n=== PRELIEVI ===");
        Operazione[] prelievi = conto.getPrelievi();
        for (int i = 0; i < prelievi.length; i++) {
            System.out.println(prelievi[i]);
        }

        System.out.println("\n=== DEPOSITI ===");
        Operazione[] depositi = conto.getDepositi();
        for (int i = 0; i < depositi.length; i++) {
            System.out.println(depositi[i]);
        }

        System.out.println("\n=== OPERAZIONI IMPORTANTI (>1000€) ===");
        Operazione[] importanti = conto.getOperazioniImportanti();
        for (int i = 0; i < importanti.length; i++) {
            System.out.println(importanti[i]);
        }

        System.out.println("\n=== OPERAZIONI NON ESEGUITE ===");
        Operazione[] nonEseg = conto.getOperazioniNonEseguite();
        for (int i = 0; i < nonEseg.length; i++) {
            System.out.println(nonEseg[i]);
        }

        System.out.println("\n=== OPERAZIONI DEL MESE CORRENTE ===");
        int meseCorrente = java.time.LocalDate.now().getMonthValue();
        Operazione[] mese = conto.getOperazioniMese(meseCorrente);
        for (int i = 0; i < mese.length; i++) {
            System.out.println(mese[i]);
        }

        System.out.println("\n=== OPERAZIONI DELL'ANNO CORRENTE ===");
        int annoCorrente = java.time.LocalDate.now().getYear();
        Operazione[] anno = conto.getOperazioniAnno(annoCorrente);
        for (int i = 0; i < anno.length; i++) {
            System.out.println(anno[i]);
        }
    }
}
