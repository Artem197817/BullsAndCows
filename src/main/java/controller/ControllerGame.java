package controller;

import input.InputUser;
import output.Output;
import repositories.SecretWord;
import service.CheckWord;


public class ControllerGame {
    private int numberOfAttempts;
    private final SecretWord secretWord;
    private final CheckWord checkWord;
    private final InputUser inputUser;
    private final Output output;
    private int countNumberOfAttempts = 1;
    private String word;
    private boolean isHint = false;


    public ControllerGame(SecretWord secretWord, CheckWord checkWord, Output output, InputUser inputUser) {
        this.secretWord = secretWord;
        this.checkWord = checkWord;
        this.inputUser = inputUser;
        this.output = output;
    }

    public void initGame() {
        try {
            numberOfAttempts = Integer.parseInt(inputUser.scannerConsole("Введите количество попыток  "));
        } catch (NumberFormatException e) {
            output.outputConsole("Введено неккоректное значение. У Вас 5 попыток");
            numberOfAttempts = 5;
        }
        activationHint();
        selectionNumberOfPlayers();
    }

    public void run() {
        while (countNumberOfAttempts <= numberOfAttempts) {
            String userWord = inputUser.inputUserWord();
            String result = checkWord.checkWord(word, userWord);
            if (result.equals("1")) {
                output.outputConsole("Вы угадали слово " + word);
                inputUser.scannerClose();
                return;
            }
            output.outputConsole(result);
            if (isHint)
                output.outputConsole(checkWord.hinting());
            countNumberOfAttempts++;
        }
        output.outputConsole("Попытки закончились. Вы не угадали слово " + word);
        inputUser.scannerClose();
    }

    public void activationHint() {
        String scanner = inputUser.scannerConsole("Включить подсказки (Д/Н)");
        if (scanner.equalsIgnoreCase("д") || scanner.equalsIgnoreCase("y"))
            isHint = true;
    }

    public void selectionNumberOfPlayers() {
        String numberOfPlayers = inputUser.scannerConsole("Введите количество игроков (1/2) ");
        if (numberOfPlayers.equalsIgnoreCase("1"))
            this.word = secretWord.secretWord();
        else
            this.word = secretWord.secretWordUser();
    }
}
