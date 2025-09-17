package model;

public class Versement extends Operation{
    private String source;

    public Versement(String numero, double montant, String source) {
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
