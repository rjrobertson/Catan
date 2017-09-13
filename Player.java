import org.omg.CORBA.Object;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bkrc on 6/1/2017.
 */
public class Player {
    private final int wheat = 0;
    private final int lumber = 1;
    private final int ore = 2;
    private final int brick = 3;
    private final int sheep = 4;

    public final int road = 0;
    public final int settlement = 1;
    public final int city = 2;
    public final int developmentCard = 3;

    private int color, numSettlements,numCities, numRoads, roadLength, armySize;
    private boolean longestRoad, largestArmy;
    private ArrayList<Road> roads = new ArrayList<>();
    private ArrayList<Settlement> settlements = new ArrayList<>();
    private ArrayList<DevCard> devCards = new ArrayList<>();
    private ArrayList<Integer> resources = new ArrayList<>();
    private String playerName;
    private int victoryPoints;

    public Player(String playerName) {
        this.playerName = playerName;
        numSettlements = 5;
        numCities = 4;
        numRoads = 15;
        longestRoad = false;
        largestArmy = false;
        devCards = new ArrayList<>();
        victoryPoints = 0;
        int x = 0;
        while (x != 5) {
            resources.add(0);
            x++;
        }

        armySize = 0;
        roadLength = 0;

    }


    public void activateDevCard(int index, ArrayList<Object> list) {
        DevCard card = devCards.get(index);
        int type = devCards.get(index).getType();
        if (type == 1) {
            //Knight
        }
        if (type == 2) {
            String[] choices = {"Wheat","Lumber","Ore","Brick","Sheep"};
            String choice = JOptionPane.showInputDialog(null, "Please select your Resource of choice"
            , "Year of Plenty",JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]).toString();
            if (choice.equals(choices[wheat])) {
                incResource(wheat, 2);
            }
            if (choice.equals(choices[lumber])) {
                incResource(lumber, 2);
            }
            if (choice.equals(choices[ore])) {
                incResource(ore, 2);
            }
            if (choice.equals(choices[brick])) {
                incResource(brick, 2);
            }
            if (choice.equals(choices[sheep])) {
                incResource(sheep, 2);
            }
            JOptionPane.showMessageDialog(null, "Resources received");
        }
        if (type == 3) {
            //Road Builder
            Edge edge1 = (Edge) JOptionPane.showInputDialog(null, "Please select your first Road."
                    , "Road Builder",JOptionPane.QUESTION_MESSAGE, null, list.toArray(), list.get(0));
            Edge edge2 = (Edge) JOptionPane.showInputDialog(null, "Please select your second Road."
                    , "Road Builder",JOptionPane.QUESTION_MESSAGE, null, list.toArray(), list.get(0));
            edge1.buildRoad(this);
            edge2.buildRoad(this);
        }
        if (type == 4) {
            //Monopoly
            String[] choices = {"Wheat","Lumber","Ore","Brick","Sheep"};
            String choice = JOptionPane.showInputDialog(null, "Please select your Resource of choice"
                    , "Monopoly",JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]).toString();
            ArrayList<String> resz = new ArrayList<>();
            for (String c : choices) {
                resz.add(c);
            }
            int res = resz.indexOf(choice);
            for (Object p : list) {
                if ((Player) p == this){

                } else {
                    Player player = (Player) p;
                    int amount = player.getResource(res);
                    player.decResource(res, amount);
                    this.incResource(res, amount);
                }
            }
        }

    }

    public void offerTrade(Player partner, ArrayList<Integer> resources) {

    }

    public void buildDevCard(DevelopmentCardPool pool) {
        if (canAfford(developmentCard)) {
            decResource(wheat);
            decResource(sheep);
            decResource(ore);
            DevCard card = pool.getDeck().pop();
            devCards.add(card);
            JOptionPane.showMessageDialog(null, "Card was drawn");
        }
        else{
            JOptionPane.showMessageDialog(null, "Cannot afford");
        }
    }

    public void buildCity(Settlement settlement) {
        if (canAfford(city)) {
            decResource(wheat, 2);
            decResource(ore, 3);
            settlement.upgrade();
        }else{
            JOptionPane.showMessageDialog(null, "Cannot afford");
        }
    }

    public void buildRoad(Edge edge) {
        if (canAfford(road)) {
            decResource(brick);
            decResource(lumber);
            Road road = new Road(this, edge);
            roads.add(road);
            numRoads++;
            edge.buildRoad(this);
        }else{
            JOptionPane.showMessageDialog(null, "Cannot afford");
        }
    }

    public void buildSettlement(Vertice vertice) {
        if (canAfford(settlement)){
            decResource(wheat);
            decResource(lumber);
            decResource(brick);
            decResource(sheep);
            Settlement settlement = new Settlement(this, vertice);
            settlements.add(settlement);
            numSettlements++;
            vertice.settle();
        }
        else{
            JOptionPane.showMessageDialog(null, "Cannot afford");
        }
    }

    public boolean canAfford(int struct) {
        if (struct == road) {
            if (getLumber() >= 1 && getBrick() >= 1) {
                return true;
            } else {
                return false;
            }
        }
        if (struct == settlement) {
            if (getLumber() >= 1 && getBrick() >= 1 && getWheat() >= 1 && getSheep() >= 1) {
                return true;
            } else {
                return false;
            }
        }
        if (struct == city) {
            if (getWheat() >= 2 && getOre() >= 3) {
                return true;
            } else {
                return false;
            }
        }
        if (struct == developmentCard) {
            if (getOre() >= 1 && getWheat()>= 1 && getSheep() >= 1) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Did not catch value : " + struct);
            return false;
        }
    }

    public void incResource (int resource) {
        resources.set(resource, resources.get(resource) + 1);
    }

    public void incResource (int resource, int amount) {
        resources.set(resource, resources.get(resource) + amount);
    }

    public void decResource (int resource) {
        if (resources.get(resource) > 0) {
            resources.set(resource, resources.get(resource) - 1);
        } else {
            resources.set(resource, 0);
        }
    }

    public void decResource (int resource, int amount) {
        if (resources.get(resource) >= amount) {
            resources.set(resource, resources.get(resource) - amount);
        } else {
            resources.set(resource, 0);
        }
    }

    public int getWheat() {
        return resources.get(wheat);
    }

    public int getLumber() {
        return resources.get(lumber);
    }

    public int getOre() {
        return resources.get(ore);
    }

    public int getBrick() {
        return resources.get(brick);
    }

    public int getSheep() {
        return resources.get(sheep);
    }

    public int getResource(int resource) {
        if (resource == 0) {
            return getWheat();
        }
        if (resource == 1) {
            return getLumber();
        }
        if (resource == 2) {
            return getOre();
        }
        if (resource == 3) {
            return getBrick();
        }
        if (resource == 4) {
            return getSheep();
        }
        else {
            return -1;
        }
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    public void addSettlement(Settlement settlement) {
        settlements.add(settlement);
    }
}
