package controller;

import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;
import service.CompteService;
import util.Validation;


public class CompteController {
    private final CompteService compteService;
    private final Client client;

    public CompteController(Client client, CompteService compteService) {
        this.compteService = compteService;
        this.client = client;
    }

    public void createCompte() {
        boolean condition = true;

        while (condition) {
            System.out.println("\n===== Create Compte =====");
            System.out.println("1. Créer un Compte Courant");
            System.out.println("2. Créer un Compte Epargne");
            System.out.println("3. Retour");
            System.out.print("Choix : ");

            int choix = Validation.getIntegerInput();

            switch (choix) {
                case 1:
                    System.out.print("\nSaisir solde qui va entrer: ");
                    double solde1 = Validation.getMontantInput();
                    String code1 = this.compteService.genererCodeCompte();
                    CompteCourant compteCourant = new CompteCourant(solde1, code1);
                    this.compteService.createCompte(compteCourant);
                    try {
                        Compte compte = this.client.findCompte(code1);
                        System.out.println("Les informations de votre Compte sont:");
                        compte.afficherDetails();
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                        break;
                    }

                    System.out.println("4. Termine");
                    System.out.print("Choix : ");
                    int choix2 = Validation.getIntegerInput();
                    if (choix2 == 4) condition = false;
                    break;

                case 2:
                    System.out.print("\nSaisir solde qui va entrer: ");
                    double solde2 = Validation.getMontantInput();
                    String code2 = this.compteService.genererCodeCompte();
                    CompteEpargne compteEpargne = new CompteEpargne(solde2, code2);
                    this.compteService.createCompte(compteEpargne);
                    try {
                        Compte compte = this.client.findCompte(code2);
                        System.out.println("Les informations de votre Compte sont:");
                        compte.afficherDetails();
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                        break;
                    }

                    System.out.println("4. Termine");
                    System.out.print("Choix : ");
                    int choix3 = Validation.getIntegerInput();
                    if (choix3 == 4) condition = false;
                    break;

                case 3:
                    condition = false;
                    break;

                default:
                    System.out.println("Choix invalide !");

            }
        }
    }
}
