import java.util.Arrays;

public class Problem {
    private Destination[] d;
    private Source[] s;
    private int dSize = 0;  // Numarul de elemente de tip Source
    private int sSize = 0;  // Numarul de elemente de tip Destination
    private int[][] costTabel;

    //---------------------Getters
    public Destination[] getD ( ) {
        return d;
    }
    public Source[] getS ( ) {
        return s;
    }
    public int getdSize ( ) {
        return dSize;
    }
    public int getsSize ( ) {
        return sSize;
    }
    public int[][] getCostTabel ( ) {
        return costTabel;
    }

    //---------------------Setters
    public void setD ( Destination[] d ) {
        this.d = d;
    }
    public void setS ( Source[] s ) {
        this.s = s;
    }
    public void setdSize ( int dSize ) {
        this.dSize = dSize;
    }
    public void setsSize ( int sSize ) {
        this.sSize = sSize;
    }
    public void setCostTabel ( int[][] costTabel ) {
        this.costTabel = costTabel;
    }


    /**
     * Adds a new Destination to the problem, putting it in the 'd' array,using dSize as a counter for the array. Verifies that the Destination is unique
     * @param name
     * @param supply
     */
    public void addDestination ( String name, int supply ) {

        d[dSize] = new Destination (name, supply);
        for (int i = 0 ; i < dSize ; i++)
            if (d[dSize].equals (d[i])) {
                System.err.println ("You can't add the same destination twice.");
                System.exit (1);

            }
        dSize++;
    }

    /**
     *  Adds a new Source to the problem, putting it in the 's' array,using sSize as a counter for the array. Verifies that the Source is unique
     * @param name
     * @param supply
     * @param type
     */
    public void addSource ( String name, int supply, String type ) {
        if (type.equals ("Warehouse"))
            s[sSize] = new Warehouse (name, supply);

        else if (type.equals ("Factory"))
            s[sSize] = new Factory (name, supply);

        else
            System.err.println ("Inserted type doesn't exist");

        for (int i = 0 ; i < sSize ; i++)
            if (s[sSize].equals (s[i])) {
                System.err.println ("You can't add the same source twice.");
                System.exit (1);

            }

        sSize++;
    }

    /**
     * Creating the problem, sSize/dSize refer to the maxim number of Sources/Destinations we can add in the problem
     * @param costTabel
     * @param sSize
     * @param dSize
     */
    public void create ( int[][] costTabel, int sSize, int dSize ) {
        s = new Source[sSize];
        d = new Destination[dSize];
        this.costTabel = costTabel;

    }

    /**
     * Using toString method to print the problem data
     */
    public void print ( ) {
        System.out.println ("Problem{" +
                "\nd=" + Arrays.toString (d) +
                ",\ns=" + Arrays.toString (s) +
                ",\ndSize=" + dSize +
                ", sSize=" + sSize +
                /*",\ncostTabel=" + Arrays.toString(costTabel) +*/
                "");
        System.out.println ("costTabel=");
        for (int i = 0 ; i < sSize ; i++) {
            for (int j = 0 ; j < dSize ; j++)
                System.out.print (" " +costTabel[i][j] );
            System.out.println ("");
        }
        System.out.println("}");

    }


}
