/**
 * Created by bkrc on 6/5/2017.
 */
public class Settlement {
    private Player player;
    private Vertice location;
    private boolean isCity = false;

    public Settlement(Player player, Vertice location) {
        this.player = player;
        this.location = location;
    }

    public void retrieveStartingResources() {
        for (Tile tile : location.getNeighbors()) {
            int resource = tile.getResource();
            player.incResource(resource);
        }
    }

    public void upgrade() {
        isCity = true;
    }

    public Player getPlayer() {
        return player;
    }

    public Vertice getLocation() {
        return location;
    }


}
