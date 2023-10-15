import controller.ControllerGame;
import input.InputUser;
import output.Output;
import repositories.SecretWord;
import service.CheckWord;

public class Main {

    public static void main(String[] args) {
        Output output = new Output();
        InputUser inputUser = new InputUser(output);
        ControllerGame controllerGame = new ControllerGame(new SecretWord(inputUser), new CheckWord(), output
                , inputUser);
        controllerGame.initGame();
        controllerGame.run();


    }
}
