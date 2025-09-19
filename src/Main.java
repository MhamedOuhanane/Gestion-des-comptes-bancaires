import controller.BanqueController;
import model.Client;
import model.Compte;
import model.CompteEpargne;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

        BanqueController banqueController = new BanqueController(client);
        banqueController.menuGeneral();


    }
}