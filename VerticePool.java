import java.util.ArrayList;

/**
 * Created by bkrc on 6/5/2017.
 */
public class VerticePool {
    ArrayList<Vertice> vertices = new ArrayList<>();
    TilePool tilePool;
    private static int c ;

    public void inC(){
        c++;
    }


    public VerticePool(TilePool tilePool){
        this.tilePool = tilePool;
        coordinate();
        greetNeighbors();
        greetNeighborVertices();
    }

    public void refreshAvailability() {
        for (Vertice v : vertices) {
            if (!v.isOpen()) {
                for (Vertice v2 : v.getNeighborVertices()) {
                    v2.makeUnplayable();
                }
            }
        }
    }

    public void greetNeighbors() {
        for (Vertice v : vertices) {
            int col = v.getX();
            int row = v.getY();
            int x = col - 1;
            int y = row - 3;
            for (Tile neighbor : tilePool.getTiles()) {
                if (neighbor.getCol() >= x && neighbor.getCol() <= x + 2) {
                    if (neighbor.getRow() >= y && neighbor.getRow() <= y + 6) {
                        v.addNeighbor(neighbor);
                    }
                }
            }
            v.createNeighborCoords();
        }
    }

    public void greetNeighborVertices() {
        for (Vertice vertice : vertices) {
            int col = vertice.getX();
            int row = vertice.getY();
            int x = col - 1;
            int y = row - 2;
            for (Vertice vertice2 : vertices){
                if (vertice2.getX() != col || vertice2.getY() != row) {
                    if (vertice2.getX() >= x && vertice2.getX() <= x + 2) {
                        if (vertice2.getY() >= y && vertice2.getY() <= y + 4) {
                            vertice.addNeighborVertice(vertice2);
                        }
                    }
                }
            }
            vertice.createNeighborVerticeCoords();
        }
    }

    public void coordinate() {
        int x = 3;
        int y = 0;
        while (vertices.size() != 54) {


            if (y == 0 || y == 16) {
                if (x < 7) {
                    set(x,y,c);
                    x+=2;
                } else {
                    set(x,y,c);
                    x = 2;
                    y++;
                }
            }
            if (y == 1 || y == 3 || y == 13 || y == 15) {
                if (x < 8) {
                    set(x,y,c);
                    x+=2;
                } else if (y == 3){
                    set(x,y,c);
                    x = 1;
                    y++;
                } else if (y == 15) {
                    set(x,y,c);
                    x = 3;
                    y++;
                }
                else {
                    set(x,y,c);
                    x = 2;
                    y+=2;
                }
            }
            if (y == 4 || y == 6 || y == 10 || y == 12) {
                if (x < 9) {
                    set(x,y,c);
                    x+=2;
                } else if (y == 6){
                    set(x,y,c);
                    x = 0;
                    y++;
                } else if (y == 12) {
                    set(x,y,c);
                    x = 2;
                    y++;
                } else {
                    set(x,y,c);
                    x = 1;
                    y+=2;
                }
            }
            if (y == 7 || y == 9) {
                if (x < 10) {
                    set(x,y,c);
                    x+=2;
                } else if (y == 9){
                    set(x,y,c);
                    x = 1;
                    y++;
                } else {
                    set(x,y,c);
                    x = 0;
                    y+=2;
                }
            }
            //c++;
        }
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void set(int x, int y, int c) {
        Vertice vertice = new Vertice(x,y);
        vertice.setIndex(c + 1);
        vertices.add(vertice);
        inC();
    }

}
