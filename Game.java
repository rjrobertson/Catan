import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bkrc on 6/8/2017.
 */
public class Game {
    private TilePool tilePool;
    private VerticePool verticePool;
    private EdgePool edgePool;
    private DevelopmentCardPool deck;
    private ArrayList<Player> players;
    private Dice dice = new Dice();
    private int currentRoll;
    private Player turnPlayer;
    private JFrame frame = new JFrame();


    public Game(ArrayList<Player> players) {
        this.tilePool = new TilePool();
        this.verticePool = new VerticePool(tilePool);
        this.edgePool = new EdgePool(verticePool);
        this.deck = new DevelopmentCardPool();
        this.players = players;
        this.turnPlayer = players.get(0);
    }

    public TilePool getTilePool() {
        return tilePool;
    }

    public VerticePool getVerticePool() {
        return verticePool;
    }

    public EdgePool getEdgePool() {
        return edgePool;
    }

    public DevelopmentCardPool getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }
}
