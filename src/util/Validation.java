package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Validation {
    public static double getMontantInput() {
        Double input = null;
        while (input == null) {
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextDouble();
                if (input < 0) throw new InputMismatchException("Le montant ne peut pas être saisi sous forme de valeur négative.");
            } catch (InputMismatchException exc) {
                System.out.println("Erreur dans le type d'entrée: " + exc.getMessage());
                input = null;
            }
            if (input == null) System.out.print("Ré-entrez le montant: ");
        }

        return input;
    }

    public static int getIntegerInput() {
        Integer input = null;
        while (input == null) {
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                if (input < 0) throw new InputMismatchException("Le choix est negative.");
            } catch (InputMismatchException exc) {
                System.out.println("Erreur dans le type d'entrée: " + exc.getMessage());
                input = null;
            }
            if (input == null) System.out.print("Ré-entrez votre choix: ");
        }
        return input;
    }

    public static String  getCodeValidation() {
        String codeCompte = null;
        while (codeCompte == null) {
            Scanner scanner = new Scanner(System.in);
            try {
                codeCompte = scanner.nextLine();
                boolean pattern = Pattern.matches("CPT-[0-9]{5}", codeCompte);
                if (!pattern) throw new InputMismatchException("Structure de code invalid! Le code doit être au format CPT-XXXXX.");
            } catch (InputMismatchException exc) {;
                codeCompte = null;
                System.out.println("Erreur dans le code entrée: " + exc.getMessage());
            }
            if (codeCompte == null) System.out.print("Ré-entrez le code de votre conte: ");
        }

        return codeCompte;
    }
}
