package OOProgram.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto implements GamblingMachine {

    private final Random random = new Random();

    @Override
    public String generateTicket() {
        List<Integer> numbers = new ArrayList<>();

        while(numbers.size() < 5) {
            numbers.add(random.nextInt(90) + 1);
        }

        Collections.sort(numbers);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));

            if (i < numbers.size() - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }
}
