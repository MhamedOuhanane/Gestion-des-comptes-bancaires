package controller;

import model.Client;
import model.Compte;
import model.Operation;
import service.CompteService;
import util.Validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BanqueController {
    private final Client client;

    public BanqueController(Client client) {
        this.client = client;
    }

    public void menuGeneral() {
        HashMap<String, Compte> accounts = this.client.getComptes();
        CompteService compteService = new CompteService(client);
        CompteController compteController = new CompteController(client, compteService);
        OperationController operationController = new OperationController();
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

            int choix = Validation.getIntegerInput();

            switch (choix) {
                case 1:
                    compteController.createCompte();
                    break;
                case 2:
                    System.out.print("Connectez-vous à votre compte: ");
                    String codeCompteVer = Validation.getCodeValidation();
                    try {
                        compte = this.client.findCompte(codeCompteVer);
                        System.out.print("Saisir le montant de Versement: ");
                        double montant = Validation.getMontantInput();
                        operationController.faireVersement(compte, montant, null);
                        this.client.affichierAccountes();
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Connectez-vous à votre compte: ");
                    String codeCompteRe = Validation.getCodeValidation();
                    try {
                        compte = this.client.findCompte(codeCompteRe);
                        System.out.print("Saisir le montant de Retrait: ");
                        double montant = Validation.getMontantInput();
                        operationController.faireRetrait(compte, montant, null);
                        this.client.affichierAccountes();
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Connectez-vous à votre compte: ");
                    String codeCompteVir1 = Validation.getCodeValidation();
                    try {
                        compte = this.client.findCompte(codeCompteVir1);
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                        break;
                    }

                    Compte compteVer;
                    System.out.print("Donner le compte de Versement: ");
                    String codeCompteVir2 = Validation.getCodeValidation();

                    try {
                        if (Objects.equals(codeCompteVir2, codeCompteVir1)) throw new IllegalAccessException("Vous ne pouvez pas transférer vers le même compte.");
                        compteVer = this.client.findCompte(codeCompteVir2);
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                        break;
                    }

                    System.out.print("Saisir le montant de Virement: ");
                    double montant = Validation.getMontantInput();
                    boolean retraitCon = operationController.faireRetrait(compte, montant, "Virement sortant");
                    if (retraitCon) operationController.faireVersement(compteVer, montant, "Virement externe");
                    this.client.affichierAccountes();
                    break;

                case 5:
                    System.out.print("Connectez-vous à votre compte: ");
                    String codeCompteDet = Validation.getCodeValidation();
                    try {
                        compte = this.client.findCompte(codeCompteDet);
                        System.out.println("Solde du votre compte est: " + compte.getSolde());
                    } catch (Exception exception) {
                        System.out.println("Quelque chose s'est mal passé. " + exception.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Connectez-vous à votre compte: ");
                    String codeCompte = Validation.getCodeValidation();
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

                case 7:
                    connexion = false;
                    break;
                default:
                    System.out.println("Choix invalide !");

            }

        }
    }
}
