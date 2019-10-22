package learning.springfive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


public class numberGeneratorI implements numberGenerator {

    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
