public abstract class Source{

    private String name;
    private int supply;

    //---------------------Constructor

    public Source(String name, int supply)
    {
        this.name=name;
        this.supply=supply;
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


    public boolean equals(Source obj) {
        return this.name.equals(obj.name) && this.supply == obj.supply;
    }


    @Override
    public String toString() {
        return "Source{" +
                "name=" + name +
                ", supply=" + supply +
                '}'
                ;
    }
}
