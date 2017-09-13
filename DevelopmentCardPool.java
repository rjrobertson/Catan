import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by bkrc on 6/1/2017.
 */
public class DevelopmentCardPool {

    private final int victoryPoint = 0;
    private final int knight = 1;
    private final int yearOfPlenty = 2;
    private final int roadBuilding = 3;
    private final int monopoly = 4;
    private Stack<DevCard> deck;

    public DevelopmentCardPool() {
        DevCard card;
        int x = 0;
        deck = new Stack<>();
        while (x < 5){
            card = new DevCard(0);
            deck.add(card);
            x++;
        }
        x = 0;

        while (x < 14){
            card = new DevCard(1);
            deck.add(card);
            x++;
        }

        card = new DevCard(2);
        deck.add(card);
        deck.add(card);
        card = new DevCard(3);
        deck.add(card);
        deck.add(card);
        card = new DevCard(4);
        deck.add(card);
        deck.add(card);

        Collections.shuffle(deck);


    }

    public Stack<DevCard> getDeck() {
        return deck;
    }
}
