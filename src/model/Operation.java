package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    protected UUID numero;
    protected LocalDateTime date;
    protected double montant;

    public Operation(UUID numero, double montant) {
        this.numero = numero;
        this.date = LocalDateTime.now();
        this.montant = montant;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setNumero(UUID numero) {
        this.numero = numero;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public UUID getNumero() {
        return numero;
    }

    public double getMontant() {
        return montant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public abstract void afficherDetails();

}
