import java.util.Arrays;

public class Problem {
    Destination[] d=new Destination[5];
    Source[] s=new Source [5];
    int dSize=0;
    int sSize=0;
    int[][] costTabel;


    public void addDestination(String name,int supply)
    {

        d[dSize]=new Destination(name,supply);
        for(int i=0;i<dSize;i++)
            if(d[dSize].equals(d[i])) {
                System.err.println("You can't add the same destination twice.");
                System.exit(1);

            }
        dSize++;
    }

    public void addSource(String name,int supply,String type)
    {
        if(type.equals("Warehouse"))
            s[sSize]=new Warehouse(name,supply);

        else if(type.equals("Factory"))
            s[sSize]=new Factory(name,supply);

        else
            System.err.println("Inserted type doesn't exist");

        for(int i=0;i<sSize;i++)
            if(s[sSize].equals(s[i])) {
                System.err.println("You can't add the same source twice.");
                System.exit(1);

            }

        sSize++;
    }
    public void create (int[][] costTabel,int sSize,int dSize){
        s=new Source[sSize];
        d=new Destination[dSize];
       this.costTabel=costTabel;

    }

    @Override
    public String toString() {
        return "Problem{" +
                "\nd=" + Arrays.toString(d) +
                ",\ns=" + Arrays.toString(s) +
                ",\ndSize=" + dSize +
                ", sSize=" + sSize +
                /*",\ncostTabel=" + Arrays.toString(costTabel) +*/
                "\n}";
    }
    public void afisare()
    {
        System.out.println(this.toString());
        System.out.println("costTabel=");
        for(int i=0;i< costTabel.length;i++) {
            for (int j = 0; j < costTabel.length; j++)
                System.out.print(costTabel[i][j] + " ");
            System.out.println();
        }


    }


}
