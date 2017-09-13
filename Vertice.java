import java.util.ArrayList;

/**
 * Created by bkrc on 6/2/2017.
 */
public class Vertice {
    private ArrayList<Tile> neighbors = new ArrayList<>();
    private ArrayList<String> neighborCoords = new ArrayList<>();
    private ArrayList<Vertice> neighborVertices = new ArrayList<>();
    private ArrayList<String> neighborVerticesCoords = new ArrayList<>();
    private int x, y, index;
    private boolean isOpen;
    private boolean isAvailable;
    private String coords;

    public Vertice(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAvailable = true;
        this.isOpen = true;
        createNeighborCoords();
        createNeighborVerticeCoords();
    }


    public void addNeighborVertice(Vertice vertice) {
        neighborVertices.add(vertice);
    }

    public void createNeighborVerticeCoords(){
        for (Vertice vertice : neighborVertices) {
            neighborVerticesCoords.add(vertice.getCoords());
        }
    }

    public void createNeighborCoords() {
        for (Tile tile : neighbors) {
            neighborCoords.add(tile.getCoordinates());
        }
    }

    public ArrayList<Vertice> getNeighborVertices() {
        return neighborVertices;
    }

    public ArrayList<String> getNeighborVerticesCoords() {
        return neighborVerticesCoords;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void makeUnplayable() {
        this.isAvailable = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void settle() {
        if (isAvailable()) {
            isOpen = false;
            isAvailable = false;
        }
        else {
            System.out.println("Plot was not available for settling.");
        }
    }

    public ArrayList<Tile> getNeighbors() {
        return neighbors;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCoords() {
        return "(" + getX() + " , " + getY() + ")";
    }

    public void addNeighbor (Tile tile) {
        neighbors.add(tile);
    }

    public ArrayList<String> getNeighborCoords() {
        return neighborCoords;
    }
}
