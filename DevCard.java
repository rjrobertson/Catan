/**
 * Created by bkrc on 6/1/2017.
 */
public class DevCard {
    private int type;
    private boolean isPlayable;

    public DevCard(int type) {
        this.type = type;
        isPlayable = true;
    }

    public int getType() {
        return type;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    public void play() {
        isPlayable = false;
    }

    public String toString() {
        if (type == 0) {
            return "Victory Point";
        }
        else if (type == 1) {
            return "Knight";
        }
        else if (type == 2) {
            return "Year of Plenty";
        }
        else if (type == 3) {
            return "Road Building";
        }
        else if (type == 4) {
            return "Monopoly";
        }
        else {
            return null;
        }
    }
}
