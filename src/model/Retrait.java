package model;

import java.util.UUID;

public class Retrait extends Operation {
    private String destination;

    public Retrait(UUID numero, double montant, String destination ) {
        super(numero, montant);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public void afficherDetails() {
        System.out.println(
                "Operation numero " + this.numero +
                " | Date: " + this.date +
                " | Montant: " + this.montant  +
                " | Destination: " + this.destination + " |"
        );
    }
}
