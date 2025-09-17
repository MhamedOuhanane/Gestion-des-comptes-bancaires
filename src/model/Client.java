package model;

import java.util.HashMap;

public class Client {
    private static HashMap<String, Compte> accountes = new HashMap<String, Compte>();

    public void ajouterCompte(Compte compte) {
        accountes.put(compte.getCode(), compte);
    }

    public HashMap<String, Compte> getComptes() {
        return accountes;
    }

    public Compte findCompte(String code) {
        return accountes.get(code);
    }

    public void affichierAccountes() {
        for (Compte c : accountes.values()) {
            c.afficherDetails();
        };
    }
}
