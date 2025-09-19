import controller.BanqueController;
import model.Client;
import model.Compte;
import model.CompteEpargne;
import util.Validation;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            HashMap<String, Compte> accounts = client.getComptes();
            for (Compte compte : accounts.values()) {
                if (compte instanceof CompteEpargne) {
                    double interet = compte.calculerInteret();
                    compte.setSolde(compte.getSolde() + interet);
                }
            }
        }, 0, 5, TimeUnit.SECONDS);

        System.out.println("Code: ");
        String code = Validation.getCodeValidation();
        if (code == null) System.out.println("ff");
        else System.out.println(code);
        BanqueController banqueController = new BanqueController(client);
        banqueController.menuGeneral();


    }
}