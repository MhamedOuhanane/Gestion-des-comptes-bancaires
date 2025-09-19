package service;

import model.Client;
import model.Compte;

import java.util.HashMap;
import java.util.Random;

public class CompteService {
    private Client client;

    public CompteService(Client client) {
        this.client = client;
    }

    public void createCompte(Compte compte) {
        try {
            this.client.ajouterCompte(compte);
        } catch (Exception exception) {
            System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
        }
    }

    public String genererCodeCompte() {
        Random random = new Random();
        int initialRang = random.nextInt(90000) + 10000;
        String code = "CPT-" + initialRang;
        HashMap<String, Compte> accounts = this.client.getComptes();

        while (accounts.containsKey(code)) {
            int rang = random.nextInt(90000) + 10000;
            code = "CPT-" + rang;
        }
        return code;
    }
}
