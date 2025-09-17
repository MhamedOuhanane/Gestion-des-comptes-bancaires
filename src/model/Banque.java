package model;

import java.util.HashMap;
import java.util.Map;

public class Banque {
    private Map<String, Compte> comptes;

    public void Banque() {
        this.comptes = new HashMap<>();
    }

    public void ajouterCompte(Compte compte) {
        this.comptes.put(compte.getCode(), compte);
    }

    public Map<String, Compte> getComptes() {
        return comptes;
    }

    public Compte findCompte(String code) {
        return this.comptes.get(code);
    }

    public void affichierComptes() {
        for (Compte c : comptes.values()) {
            c.afficherDetails();
        };
    }
}
