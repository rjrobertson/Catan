/**
 * Created by bkrc on 6/6/2017.
 */
public class Link {
    private Vertice one, two;
    private String linkString;
    public Link(Vertice one, Vertice two) {
        this.one = one;
        this.two = two;
        this.linkString = one.getCoords() + " to " + two.getCoords();
    }

    public Vertice getOne() {
        return one;
    }

    public Vertice getTwo() {
        return two;
    }

    public String getLinkString() {
        return one.getCoords() + " to " + two.getCoords();
    }

    public boolean has(Vertice one2, Vertice two2) {
        if (one.getCoords().equals(one2.getCoords()) && two.getCoords().equals(two2.getCoords())) {
            return true;
        }
        if (one.getCoords().equals(two2.getCoords()) && two.getCoords().equals(one2.getCoords())) {
            return true;
        } else {
            return false;
        }
    }
}
