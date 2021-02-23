public class Destination {
    private String name;
    private int supply;

    //---------------------Constructor
    public Destination(String name, int supply) {
        this.name = name;
        this.supply = supply;
    }

    //---------------------Getters
    public String getName() {
        return name;
    }
    public int getSupply() {
        return supply;
    }

    //---------------------Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSupply(int supply) {
        this.supply = supply;
    }


    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", supply=" + supply +
                '}';
    }
}
