package learning.springfive.console;

import learning.springfive.Game;
import learning.springfive.MessageGeneratorI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess  {
    // == constants ==

    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Autowired
    private Game game;

    @Autowired
    private MessageGeneratorI mG;

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
       log.info("star() --> containerrr");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(mG.getMainMessage());
            System.out.println(mG.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(mG.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
    }
}
