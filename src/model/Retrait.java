package model;

public class Retrait extends Operation {
    private String destination;

    public Retrait(String numero, double montant, String destination ) {
        super(numero, montant);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
