package repositories;

import input.InputUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecretWord {

    ArrayList<String> wordRepositories = new ArrayList<>(List.of("папа", "мама", "утка", "гусыня", "лев", "лемур"));
    InputUser inputUser;

    public SecretWord(InputUser inputUser) {
        this.inputUser = inputUser;
    }

    public String secretWord() {
        Random random = new Random();
        return wordRepositories.get(random.nextInt(wordRepositories.size()));
    }

    public String secretWordUser() {
        String word = inputUser.scannerConsole("Введите загадываемое слово ");
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        return word;
    }
}
