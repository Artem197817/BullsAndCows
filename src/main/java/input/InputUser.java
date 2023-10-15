package input;

import output.Output;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputUser {

    private final Output output;

    private final Scanner scanner = new Scanner(System.in);

    public InputUser(Output output) {
        this.output = output;
    }

    public String inputUserWord() {
        return scannerConsole("Введите слово ");
    }

    public String scannerConsole(String message) {
        output.outputConsole(message);
        try {
            return scanner.next();
        } catch (NoSuchElementException e) {
            output.outputConsole("Неккоректное значение");
        }
        return scannerConsole(message);
    }

    public void scannerClose() {
        scanner.close();
    }
}
