import java.util.ArrayList;

/**
 * Created by bkrc on 6/1/2017.
 */
public class Tile {
    int number, resource;
    boolean robber;
    String id;
    private int col, row;
    private ArrayList<Tile> neighbors = new ArrayList<>();
    private ArrayList<String> neighborCoords = new ArrayList<>();
    private ArrayList<Vertice> vertices = new ArrayList<>();
    final String wheat = "Wheat";
    final String lumber = "Lumber";
    final String sheep = "Sheep";
    final String ore = "Ore";
    final String brick = "Brick";
    final String desert = "Desert";

    final ArrayList<String> types = new ArrayList<>();

    public void makeTypeReference() {
        types.add(desert);
        types.add(wheat);
        types.add(lumber);
        types.add(sheep);
        types.add(ore);
        types.add(brick);
    }
    public Tile(int resource) {
        makeTypeReference();
        this.resource = resource;
        if (resource == 0) {
            robber = true;
        } else {
            robber = false;
        }
        id = types.get(resource);
    }

    public void createNeighborCoords() {
        for (Tile tile : neighbors) {
            neighborCoords.add(tile.getCoordinates());
        }
    }

    public ArrayList<String> getNeighborCoords() {
        return neighborCoords;
    }

    public int getNumber() {
        return number;
    }

    public int getResource() {
        return resource;
    }

    public boolean isRobber() {
        return robber;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<Tile> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Tile tile) {
        neighbors.add(tile);
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getCoordinates() {
        return "(" + getCol() + " , " + getRow() + ")";
    }

    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
}
