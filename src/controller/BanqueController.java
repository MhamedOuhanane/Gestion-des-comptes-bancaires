package controller;

import model.Client;
import model.Compte;
import service.CompteService;

import java.util.HashMap;
import java.util.Scanner;

public class BanqueController {
    private Client client;
    private Compte compte;

    public BanqueController(Client client) {
        this.client = client;
    }

    public void menuGeneral() {
        HashMap<String, Compte> accounts = this.client.getComptes();
        CompteService compteService = new CompteService(client);
        CompteController compteController = new CompteController(client, compteService);
        OperationController operationController = new OperationController();
        Scanner scanner = new Scanner(System.in);
        boolean connexion = true;

        while (connexion) {
            System.out.println("\n===== MENU BANQUE =====");
            System.out.println("1. Créer un compte");
            System.out.println("2. Effectuer un versement");
            System.out.println("3. Effectuer un retrait");
            System.out.println("4. Effectuer un virement entre comptes");
            System.out.println("5. Consulter solde d’un compte");
            System.out.println("6. Consulter les opérations d’un compte");
            System.out.println("7. Quitter");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    compteController.createCompte();
                    break;

                case 2:
                    System.out.print("Connectez-vous à votre compte: ");
                    String codeCompte = scanner.nextLine();
                    while (this.compte != null) {
                        try {
                            this.compte = this.client.findCompte(codeCompte);
                        } catch (Exception exception) {
                            System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Choix invalide !");

            }

//            scanner.close();
        }
    }
}
