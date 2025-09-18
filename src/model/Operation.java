package model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Operation {
    protected UUID numero;
    protected LocalDate date;
    protected double montant;

    public Operation(UUID numero, double montant) {
        this.numero = numero;
        this.date = LocalDate.now();
        this.montant = montant;
    }

    public void setDate(LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public abstract void afficherDetails();

}
