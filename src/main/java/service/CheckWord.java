package service;


import java.util.ArrayList;
import java.util.List;

public class CheckWord {

    private List<Character> resultCheckWordList;

    public String checkWord(String word, String userWord) {
        resultCheckWordList = new ArrayList<>();
        int countCows = 0;
        int countBulls = 0;
        int min;
        char[] arrCharWord = word.toCharArray();
        char[] arrCharUserWord = userWord.toCharArray();
        min = Math.min(arrCharWord.length, arrCharUserWord.length);
        for (int i = 0; i < min; i++) {
            if (arrCharWord[i] == arrCharUserWord[i]) {
                countBulls++;
                resultCheckWordList.add(arrCharWord[i]);
            } else {
                resultCheckWordList.add('*');
            }
            String decodedPartWord = hinting();
            for (char c : arrCharUserWord) {
                if (arrCharWord[i] == c)
                    if (!decodedPartWord.contains(Character.toString(c)))
                        countCows++;
            }
        }
        if (word.equals(userWord))
            return "1";

        return "Быков " + countBulls + " Коров " + countCows;
    }

    public String hinting() {
        StringBuilder hint = new StringBuilder();
        for (Character r : resultCheckWordList) {
            hint.append(r);
        }
        return hint.toString();
    }
}
