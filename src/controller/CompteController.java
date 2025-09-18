package controller;

import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;
import service.CompteService;

import java.util.HashMap;
import java.util.Scanner;


public class CompteController {
    private CompteService compteService;
    private Client client;

    public CompteController(Client client, CompteService compteService) {
        this.compteService = compteService;
        this.client = client;
    }

    public void createCompte() {
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            System.out.println("\n===== Create Compte =====");
            System.out.println("1. Créer un Compte Courant");
            System.out.println("2. Créer un Compte Epargne");
            System.out.println("3. Retour");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("\nSaisir solde qui va entrer: ");
                    double solde1 = scanner.nextDouble();
                    String code1 = this.compteService.genererCodeCompte();
                    CompteCourant compteCourant = new CompteCourant(solde1, code1);
                    this.compteService.createCompte(compteCourant);

                    System.out.println("4. Termine");
                    System.out.print("Choix : ");
                    int choix2 = scanner.nextInt();
                    if (choix2 == 4) condition = false;
                    break;

                case 2:
                    System.out.print("\nSaisir solde qui va entrer: ");
                    double solde2 = scanner.nextDouble();
                    String code2 = this.compteService.genererCodeCompte();
                    CompteEpargne compteEpargne = new CompteEpargne(solde2, code2);
                    this.compteService.createCompte(compteEpargne);


                    System.out.println("4. Termine");
                    System.out.print("Choix : ");
                    int choix3 = scanner.nextInt();
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
