package bsuir.webtech.lab2.presentation;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleView {

    private ConsoleViewModel consoleViewModel;

    public ConsoleView(ConsoleViewModel startState) {
        consoleViewModel = startState;
    }

    public void show() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (consoleViewModel != null) {
            System.out.println(consoleViewModel.getText());
            processInput(scanner);
        }
    }

    private void processInput(Scanner scanner) {
        boolean success = false;
        do {
            try {
                System.out.print(": ");
                consoleViewModel = consoleViewModel.processInput(scanner.nextLine());
                success = true;
            } catch (IllegalArgumentException iae) {
                System.out.println("Неверный ввод");
            }
        } while (!success);
    }
}
