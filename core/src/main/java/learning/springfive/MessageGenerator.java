package learning.springfive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGenerator implements MessageGeneratorI{


    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    @Autowired
    private Game game;

    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage(){
        return "Number is between  " +
                game.getsmallest() +
                " and " + game.getBiggest() +
                ".Can you guess it?";
    }

    @Override
    public String getResultMessage(){
        if(game.isGameWon()){
            return " You guessed it! The number was " + game.getNumber();
        } else if (game.isGameLost()){
            return " You lost bitch, the numer was " + game.getNumber();
        } else if(!game.isValidNumberRange()){
            return " Invalid number range! ";
        } else  if(game.getRemainingGuesses() == game.getGuessCount()){
            return " What is your first guess? ";
        }else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = " Higher ";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }

}
