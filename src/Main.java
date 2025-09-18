import controller.BanqueController;
import model.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        BanqueController banqueController = new BanqueController(client);

        banqueController.menuGeneral();


    }
}