package dbManager;

/**
 * @author Jake Sturgeon
 * @version 1.0 on 18/11/2017
 */
public class Treatment {

    private String name;
    private float cost;

    public Treatment(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
