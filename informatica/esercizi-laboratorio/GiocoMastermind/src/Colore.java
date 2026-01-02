public enum Colore {
    BIANCO, NERO, VERDE, GIALLO, ROSSO, ARANCIONE;

    public static Colore getRandom() {
        Colore[] colori = values();
        int index = (int)(Math.random() * colori.length);
        return colori[index];
    }

    public static Colore fromLetter(String lettera) {
        switch(lettera.toUpperCase()) {
            case "B": return BIANCO;
            case "N": return NERO;
            case "V": return VERDE;
            case "G": return GIALLO;
            case "R": return ROSSO;
            case "A": return ARANCIONE;
            default: throw new IllegalArgumentException("Colore non valido");
        }
    }


    @Override
    public String toString() {
        switch(this) {
            case BIANCO: return "B";
            case NERO: return "N";
            case VERDE: return "V";
            case GIALLO: return "G";
            case ROSSO: return "R";
            case ARANCIONE: return "A";
            default: return "?";
        }
    }
}
