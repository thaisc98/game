package learning.springfive.config;

import learning.springfive.GuessCount;
import learning.springfive.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.guessCount}")
    private int guessCount;


    @Bean
    @MaxNumber
    public int maxNumber1(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount1(){
        return guessCount;
    }
}
