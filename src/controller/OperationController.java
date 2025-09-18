package controller;

import model.Compte;
import model.Versement;

import java.util.Scanner;
import java.util.UUID;

public class OperationController {

    public void faireVersement(Compte compte,String source) {
        Scanner scanner = new Scanner(System.in);
        if (source == null){
            System.out.println("Donner Source: ");
            System.out.println("1. Dépôt espèces");
            System.out.println("2. Salaire");
            System.out.print("Choix: ");
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    source = "Dépôt espèces";
                    break;
                case 2:
                    source = "Salaire";
                    break;
                default:
                    System.out.println("\nProblème lors du versement, réessayez plus tard");
                    return;
            }
        }
        UUID numero = UUID.randomUUID();
        System.out.print("Saisir le montant: ");
        double montant = scanner.nextDouble();
        Versement versement = new Versement(numero, montant, source);
        double preMontant = compte.getSolde();
        compte.setSolde(preMontant + montant);
        compte.ajouterOperation(versement);
        System.out.println("\nVersement a votre compte de " + montant + " effectué.");
    }
}
