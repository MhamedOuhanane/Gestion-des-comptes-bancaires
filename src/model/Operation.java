package model;

import java.time.LocalDate;

public abstract class Operation {
    protected String numero;
    protected LocalDate date;
    protected double montant;

    public Operation(String numero, double montant) {
        this.numero = numero;
        this.date = LocalDate.now();
        this.montant = montant;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getNumero() {
        return numero;
    }

    public double getMontant() {
        return montant;
    }

    public LocalDate getDate() {
        return date;
    }

}
