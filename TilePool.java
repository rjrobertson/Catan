import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by bkrc on 6/1/2017.
 */
public class TilePool {
    private ArrayList<Tile> tiles;




    public TilePool() {
        tiles = new ArrayList<>();

        Tile tile;

        tile = new Tile(0);
        tiles.add(tile);

        int res = 1;
        while (res != 4) {
            int x = 0;
            while (x != 4) {
                tile = new Tile(res);
                tiles.add(tile);
                x++;
            }
            res++;
        }

        res = 4;

        while (res != 6) {
            int x = 0;
            while (x != 3) {
                tile = new Tile(res);
                tiles.add(tile);
                x++;
            }
            res++;
        }
        Collections.shuffle(tiles);
        coordinateTiles();
        greetNeighbors();

    }

    public void greetNeighbors() {
        for (Tile t : tiles) {
            int col = t.getCol();
            int row = t.getRow();
            int x = col - 2;
            int y = row - 3;
            for (Tile neighbor : tiles) {
                if (neighbor.getCol() != col || neighbor.getRow() != row) {
                    if (neighbor.getCol() >= x && neighbor.getCol() <= x + 4) {
                        if (neighbor.getRow() >= y && neighbor.getRow() <= y + 6) {
                            t.addNeighbor(neighbor);
                        }
                    }
                }
            }
            t.createNeighborCoords();
        }
    }

    public void coordinateTiles() {
        int x = 3;
        int y = 2;
        for(Tile t : tiles) {
            t.setCol(x);
            t.setRow(y);

            if (y == 2 || y == 14){
                if (x < 7) {
                    x += 2;
                } else {
                    x = 2;
                    y+=3;
                }
            } else if (y == 5 || y == 11){
                if (x < 8) {
                    x += 2;
                } else {
                    if (y == 5){
                        x = 1;
                    } else {
                        x = 3;
                    }
                    y+=3;
                }
            } else if (y == 8){
                if (x < 9) {
                    x += 2;
                } else {
                    x = 2;
                    y+=3;
                }

            }

        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }


}
