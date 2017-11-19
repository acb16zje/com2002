package dbManager.models;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 18/11/2017
 */
public class Treatment {

    private String name;
    private int cost;

    public Treatment(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Treatment{" +
            "name='" + name + '\'' +
            ", cost=" + cost +
            '}';
    }
}
