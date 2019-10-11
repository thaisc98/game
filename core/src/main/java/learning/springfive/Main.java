package learning.springfive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        context.close();
    }
}
