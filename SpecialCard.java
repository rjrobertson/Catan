import javax.swing.*;

/**
 * Created by bkrc on 6/7/2017.
 */
public class SpecialCard {
    private final int longestRoad = 0;
    private final int largestArmy = 1;
    private int type;
    private Player owner;
    public SpecialCard(int type) throws Exception {
        if (type == longestRoad) {
            this.type = longestRoad;
        } else if (type == largestArmy) {
            this.type = largestArmy;
        } else {
            throw new Exception("Cannot have special card of this type : " + type);
        }
        this.owner = null;
    }

    public int getType() {
        return type;
    }

    public Player getOwner() {
        if (owner == null) {
            JOptionPane.showMessageDialog(null, "No player owns this card yet.");
            return null;
        }
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
