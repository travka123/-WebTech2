package bsuir.webtech.lab2.presentation;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleView {

    private ConsoleViewModel consoleViewModel;

    public ConsoleView(ConsoleViewModel startState) {
        consoleViewModel = startState;
    }

    /**
     * Printing and processing input in loop until user exit
     * @throws IOException
     */
    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (consoleViewModel != null) {
            System.out.println(consoleViewModel.getText());
            System.out.print(": ");
            while (!tryProcessInput(scanner.nextLine())) {
                System.out.print("Неверный ввод\n\n:");
            }
        }
    }

    /**
     * Try process input, changes current consoleViewModel ({@link ConsoleViewModel}) if necessary,
     * return true if input process success, otherwise false
     * @param input
     * @return is input success
     */
    private boolean tryProcessInput(String input) {
        try {
            consoleViewModel = consoleViewModel.processInput(input);
            return true;
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }
}
