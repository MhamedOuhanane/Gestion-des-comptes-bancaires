package model;

import java.util.HashMap;

public class Client {
    private static HashMap<String, Compte> accountes = new HashMap<String, Compte>();

    public void ajouterCompte(Compte compte) {
        try {
            accountes.put(compte.getCode(), compte);
        } catch (Exception exception) {
            System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
        }
    }

    public HashMap<String, Compte> getComptes() {
        return accountes;
    }

    public Compte findCompte(String code) {
        try {
            return accountes.get(code);
        } catch (Exception exception) {
            System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
        }
        return null;
    }

    public void affichierAccountes() {
        if (!accountes.isEmpty()) {
            for (Compte c : accountes.values()) {
                c.afficherDetails();
            }
        } else {
            System.out.println("Il n'y a pas de compte bancaire dans le systeme");
        }
    }
}
