import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bkrc on 6/6/2017.
 */
public class EdgePool {
    private ArrayList<Edge> edges = new ArrayList<>();
    private VerticePool verticePool;
    private ArrayList<Link> links = new ArrayList<>();


    public EdgePool(VerticePool verticePool){
        this.verticePool = verticePool;
        fillPool();
        makeLinks();
        nailEdges();

    }



    public void fillPool() {
        int x = 0;
        while (x != 70) {
            Edge edge = new Edge();
            edges.add(edge);
            edge.setIndex(x+1);
            x++;
        }
    }

    public void makeLinks() {
        int x = 0;
        Link link;
        for (Vertice vertice : verticePool.getVertices()) {
            for (Vertice vertice2 : vertice.getNeighborVertices()) {
                link = new Link(vertice, vertice2);
                if (links.size() == 0){
                    links.add(link);
                }else {
                    for (Link check : links) {
                        if (check.has(vertice, vertice2)) {
                            x = 1;
                            break;
                        }
                        x = 0;
                    }
                    if (x == 0) {
                        links.add(link);
                    }
                }
            }
        }
    }

    public void nailEdges() {
        int x = 0;
        for (Edge edge : edges) {
            edge.addLink(links.get(x));
            x++;
        }
    }


    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public VerticePool getVerticePool() {
        return verticePool;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }
}
