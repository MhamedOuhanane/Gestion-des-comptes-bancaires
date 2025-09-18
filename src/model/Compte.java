package model;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Compte {
    protected ArrayList<Operation> listeOperations;
    protected String code;
    protected double solde;


    public Compte(double solde, String code) {
        this.code = code;
        this.solde = solde;
        this.listeOperations = new ArrayList<Operation>();
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public String getCode() {
        return code;
    }

    public void ajouterOperation(Operation op) {
        this.listeOperations.add(op);
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public abstract void afficherDetails();
    public abstract double calculerInteret();
    public abstract boolean retirer(double montant);
}
