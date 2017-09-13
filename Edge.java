import java.util.ArrayList;

/**
 * Created by bkrc on 6/6/2017.
 */
public class Edge {
    private Link link;
    private ArrayList<Edge> neighborEdges = new ArrayList<>();
    private boolean isRoad;
    private boolean isPlayable;
    private int index;


    public Edge() {
        this.isRoad = false;
        this.isPlayable = true;
    }

    public void buildRoad(Player player){
        if (isPlayable) {
            isPlayable = false;
            isRoad = true;
            Road road = new Road(player, this);
            player.addRoad(road);
        }else {
            System.out.println("Could not build road.");
        }
    }

    public void addNeighborEdges(Edge edge) {
        neighborEdges.add(edge);
    }

    public void addLink(Link link) {
        this.link = link;
    }

    public Link getLink() {
        return link;
    }

    public ArrayList<Edge> getNeighborEdges() {
        return neighborEdges;
    }

    public boolean isRoad() {
        return isRoad;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
