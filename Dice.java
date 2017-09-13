import java.util.Random;

/**
 * Created by bkrc on 6/8/2017.
 */
public class Dice {
    int die1;
    int die2;

    public int roll1() {
        Random random = new Random();
        die1 = random.nextInt(6) + 1;
        return die1;
    }

    public int roll2() {
        Random random = new Random();
        die2 = random.nextInt(6) + 1;
        return die2;
    }

    public int roll() {
        return roll1() + roll2();
    }
}
