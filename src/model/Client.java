package model;

import java.util.HashMap;

public class Client {
    private static HashMap<String, Compte> accountes = new HashMap<String, Compte>();

    public void ajouterCompte(Compte compte) throws IllegalAccessException {
        if (!accountes.containsKey(compte.getCode())) {
            accountes.put(compte.getCode(), compte);
            System.out.println("\nLe compte est enregitré avec success");
        } else throw new IllegalAccessException("Erreur lors de la création du compte");
    }

    public HashMap<String, Compte> getComptes() {
        return accountes;
    }

    public Compte findCompte(String code) throws IllegalAccessException {
        if (accountes.containsKey(code)) return accountes.get(code);
        else throw new IllegalAccessException("Ce compte n'existe pas");
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
