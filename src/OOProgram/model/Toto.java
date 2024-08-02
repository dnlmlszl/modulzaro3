package OOProgram.model;

import java.util.Random;

public class Toto implements GamblingMachine {

    private final Random random = new Random();

    @Override
    public String generateTicket() {
        String[] outcomes = {"1", "2", "X"};

        StringBuilder result = new StringBuilder();

        result.append("Mérkőzések: ");
        for (int i = 1; i <= 13 ; i++) {
            result.append(i).append("\t");
        }

        result.append("13+1\n");
        result.append("Eredmények: ");

        for (int i = 1; i <= 13; i++) {
            result.append(outcomes[random.nextInt(outcomes.length)]).append("\t");
        }

        result.append(outcomes[random.nextInt(outcomes.length)]);

        return result.toString().trim();
    }
}
