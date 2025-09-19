package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Validation {
    private static final Scanner scanner = new Scanner(System.in);

    public static double getMontantInput() {
        try {
            double input = scanner.nextDouble();
            if (input < 0) return input;
            else throw new InputMismatchException("Le montant ne peut pas être saisi sous forme de valeur négative.");
        } catch (InputMismatchException exc) {
            System.out.println("Erreur dans le type d'entrée: " + exc.getMessage());
            return (double) 0;
        }
    }

    public static int getIntegerInput() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exc) {
            System.out.println("Erreur dans le type d'entrée: " + exc.getMessage());
            return -1;
        }
    }

    public static String  getCodeValidation() {
        try {
            String codeCompte = scanner.nextLine();
            boolean pattern = Pattern.matches("[0-9]{5}", codeCompte); //"^CPT-$[0-9]{5}"
            if (pattern) return codeCompte;
            else throw new InputMismatchException("La structure de code invalide!");
        } catch (InputMismatchException exc) {
            System.out.println("Erreur dans le type d'entrée: " + exc.getMessage());
            return null;
        }
    }
}
