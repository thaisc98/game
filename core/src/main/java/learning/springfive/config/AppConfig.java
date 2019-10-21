package learning.springfive.config;

import learning.springfive.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "learning.springfive")
public class AppConfig {

        //bena methods
    @Bean
    public numberGenerator numberGenerator(){
        return new numberGeneratorI();
    }

    @Bean
    public Game game(){
        return new GameI();
    }

    @Bean
    public MessageGeneratorI messageGeneratorI() {
        return new MessageGenerator();
    }



}
