package controller;

import model.Client;
import model.Compte;
import model.Operation;
import service.CompteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BanqueController {
    private Client client;

    public BanqueController(Client client) {
        this.client = client;
    }

    public void menuGeneral() {
        HashMap<String, Compte> accounts = this.client.getComptes();
        CompteService compteService = new CompteService(client);
        CompteController compteController = new CompteController(client, compteService);
        OperationController operationController = new OperationController();
        Scanner scanner = new Scanner(System.in);
        Compte compte;
        boolean connexion = true;

        while (connexion) {
            System.out.println("\n===== MENU BANQUE =====");
            System.out.println("1. Créer un compte");
            System.out.println("2. Effectuer un versement");
            System.out.println("3. Effectuer un retrait");
            System.out.println("4. Effectuer un virement");
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
                    scanner.nextLine();
                    String codeCompteVer = scanner.nextLine();
                    try {
                        compte = this.client.findCompte(codeCompteVer);
                        System.out.print("Saisir le montant de Versement: ");
                        double montant = scanner.nextDouble();
                        operationController.faireVersement(compte, montant, null);
                        this.client.affichierAccountes();
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Connectez-vous à votre compte: ");
                    scanner.nextLine();
                    String codeCompteRe = scanner.nextLine();
                    try {
                        compte = this.client.findCompte(codeCompteRe);
                        System.out.print("Saisir le montant de Retrait: ");
                        double montant = scanner.nextDouble();
                        operationController.faireRetrait(compte, montant, null);
                        this.client.affichierAccountes();
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Connectez-vous à votre compte: ");
                    scanner.nextLine();
                    String codeCompteVir1 = scanner.nextLine();
                    try {
                        compte = this.client.findCompte(codeCompteVir1);
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                        break;
                    }

                    Compte compteVer;
                    System.out.print("Donner le compte de Versement: ");
                    String codeCompteVir2 = scanner.nextLine();

                    try {
                        compteVer = this.client.findCompte(codeCompteVir2);
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                        break;
                    }

                    System.out.print("Saisir le montant de Virement: ");
                    double montant = scanner.nextDouble();
                    operationController.faireRetrait(compte, montant, "Virement retirer");
                    operationController.faireVersement(compteVer, montant, "Virement versement");
                    this.client.affichierAccountes();
                    break;

                case 5:
                    System.out.print("Connectez-vous à votre compte: ");
                    scanner.nextLine();
                    String codeCompteDet = scanner.nextLine();
                    try {
                        compte = this.client.findCompte(codeCompteDet);
                        System.out.println("Solde du votre compte est: " + compte.getSolde());
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Connectez-vous à votre compte: ");
                    scanner.nextLine();
                    String codeCompte = scanner.nextLine();
                    try {
                        compte = this.client.findCompte(codeCompte);
                        ArrayList<Operation> listeOperations = compte.getListeOperations();
                        System.out.println("===== La liste des opérations de votre compte " + codeCompte + " sont: ");
                        for (Operation operation : listeOperations) {
                            operation.afficherDetails();
                        }
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                    }
                    break;
                default:
                    System.out.println("Choix invalide !");

            }

//            scanner.close();
        }
    }
}
