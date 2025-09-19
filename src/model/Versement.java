package model;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Versement extends Operation{
    private String source;

    public Versement(UUID numero, double montant, String source) {
        super(numero, montant);
        this.source = source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    @Override
    public void afficherDetails() {
        System.out.println(
                "Operation numero " + this.numero +
                        " | Date: " + this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                        " | Montant: " + this.montant  +
                        " | Source : " + this.source + " |"
        );
    }
}
