import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bkrc on 6/1/2017.
 */
public class Launcher {
    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("Riley");
        Player player2 = new Player("Andy");
        Player player3 = new Player("Clay");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Game game = new Game(players);

        /*for (Tile tile : tilePool.getTiles()){
            System.out.println(tile.getCoordinates() + ":" + tile.getId() + ":" + tile.isRobber() + "\t" + Arrays.deepToString(tile.getNeighborCoords().toArray()) );
        }*/

        /*verticePool.getVertices().get(11).settle();
        verticePool.refreshAvailability();

        for (Vertice vertice : verticePool.getVertices()) {
            System.out.println(vertice.getIndex() + " : " + vertice.getCoords() + "--- Has Settlement : " + !vertice.isOpen() + "--- Available : " + vertice.isAvailable() + " --- Neighbors : " + Arrays.deepToString(vertice.getNeighborVerticesCoords().toArray()));
        }*/

        /*for (Edge edge : edgePool.getEdges()) {
            System.out.println(edge.getIndex() + " : " + edge.getLink().getLinkString());
        }*/

        for (DevCard card : game.getDeck().getDeck()) {
            System.out.println(card.toString());
        }
    }
}