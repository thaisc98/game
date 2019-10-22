package learning.springfive.console;

import learning.springfive.config.AppConfig;
import learning.springfive.Game;
import learning.springfive.MessageGeneratorI;
import learning.springfive.numberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
   // private static final String CONFIG_LOCATION ="beans.xml";

    public static void main(String[] args) {
        log.info("Test");

        ConfigurableApplicationContext context
                =  new AnnotationConfigApplicationContext(AppConfig.class);

        /*ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);*/
        numberGenerator numG =
                context.getBean("numberGenerator", numberGenerator.class);

         int number = numG.next();
         log.info("number = {}",number);

         //get game  bean from context
        Game game = context.getBean(Game.class);

        //get message generator  bean from context
        MessageGeneratorI msgG =  context.getBean(MessageGeneratorI.class);
            log.info("getMainMessage = {}", msgG.getMainMessage());
            log.info("getResultMessage = {}",msgG.getResultMessage());
        context.close();


    }
}
