package model;

import java.util.Random;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(double solde, String code) {
        super(solde, code);
        this.tauxInteret = genererTauxInterer(1, 5);
    }

    public double genererTauxInterer(int min, int max) {
        Random random = new Random();
        int range = (int) ((max - min) + 1);
        int multiple = random.nextInt(range);
        return (double) (min + multiple) / 100;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte Epargne " + this.code + " | Solde: " + this.solde + " | Le taux D'Interet: " + this.tauxInteret);
    }

    @Override
    public double calculerInteret() {
        return (this.solde * this.tauxInteret);
    }

    @Override
    public boolean retirer(double montant) {
        if (this.solde - montant >= 0) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + " effectué du compte " + this.code + " .");
            return true;
        } else {
            System.out.println("Retrait refusé : ce montant n'est pas sur votre compte.");
            return false;
        }
    }
}
