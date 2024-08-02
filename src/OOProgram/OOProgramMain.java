package OOProgram;

import OOProgram.userInterface.UserInterface;

import java.util.Scanner;

public class OOProgramMain {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        UserInterface ui = new UserInterface(scanner);

        ui.start();
    }
}
