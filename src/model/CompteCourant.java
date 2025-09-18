package model;

import java.util.Random;

public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant(double solde, String code) {
        super(solde, code);
        this.decouvert = genererDecouvert(1000, 3000);
    }

    public double genererDecouvert(int min, int max) {
        Random random = new Random();
        int range = ((max - min) / 100) + 1;
        int multiple = random.nextInt(range);
        return min + (multiple * 100);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte Courant " + this.code + " | Solde: " + this.solde + " | Découvert: " + this.decouvert );
    }

    @Override
    public double calculerInteret() {
        return 0;
    }

    @Override
    public boolean retirer(double montant) {
        if (this.solde - montant >= -decouvert) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + " effectué du compte " + this.code + " .");
            return true;
        } else {
            System.out.println("Retrait refusé : dépassement du découvert.");
            return false;
        }
    }

    public double getDecouvert() {
        return decouvert;
    }
}
