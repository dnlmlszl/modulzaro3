package OOProgram.userInterface;

import OOProgram.model.GamblingMachine;
import OOProgram.model.Lotto;
import OOProgram.model.MusicRecommendation;
import OOProgram.model.Toto;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        GamblingMachine lottoMachine = new Lotto();
        GamblingMachine totoMachine = new Toto();
        MusicRecommendation musicRecommendation = new MusicRecommendation();

        menuSelection(lottoMachine, totoMachine, musicRecommendation);
    }

    private void menuSelection(GamblingMachine lottoMachine, GamblingMachine totoMachine, MusicRecommendation musicRecommendation) {
        while (true) {
            System.out.println("Válassz egy lehetőséget:");
            System.out.println("1. Lottó Szelvény");
            System.out.println("2. Totó Szelvény");
            System.out.println("3. Zenei ajánlat");
            System.out.println("4. Kilépés");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Érvénytelen bemenet. Kérlek, adj meg egy számot 1 és 4 között.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Lotto szelvény: " + lottoMachine.generateTicket());
                    break;
                case 2:
                    System.out.println("Totó szelvény: \n" + totoMachine.generateTicket());
                    break;
                case 3:
                    System.out.println("Válassz egy hangulatot (happy, sad, energetic, relaxed): ");
                    String mood = scanner.nextLine();
                    System.out.println("Zene ajánló: " + musicRecommendation.getRecommendation(mood));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Ez most egy érvénytelen menüpont volt, adj meg egy érvényes opciót");
                    break;
            }
        }
    }
}
