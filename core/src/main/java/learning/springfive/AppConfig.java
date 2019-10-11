package learning.springfive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
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

}
