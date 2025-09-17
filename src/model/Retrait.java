package model;

public class Retrait extends Operation{
    private String source;

    public Retrait(String numero, double montant, String source) {
        super(numero, montant);
        this.source = source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
