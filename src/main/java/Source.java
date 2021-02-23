public class Source {

    private SourceType type;
    private String name;
    private int supply;

    //---------------------Constructor
    public Source(String name, int supply, SourceType type)
    {
        this.name=name;
        this.supply=supply;
        this.type=type;
    }

    //---------------------Getters
    public SourceType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getSupply() {
        return supply;
    }

    //---------------------Setters
    public void setType(SourceType type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSupply(int supply) {
        this.supply = supply;
    }

    @Override
    public String toString() {
        return "Source{" +
                "type=" + type +
                ", name=" + name +
                ", supply=" + supply +
                '}'
                ;
    }
}
