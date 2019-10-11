package learning.springfive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGenerator implements MessageGeneratorI{


    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage(){
        return "getMainMessage() called";
    }

    public String getResultMessage(){
        return "getResultMessage() called";
    }

}
