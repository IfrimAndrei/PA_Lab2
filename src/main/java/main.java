public class main {
    public static void main ( String[] args ) {
        //Creating and initializing the problem
        Problem prob = new Problem ();
        initProblem ( prob );
        prob.print ();

        Solution sol = new Solution ();
        sol.resolve ( prob );
    }

    /**
     * Problem initialization,adding and setting the Source,Destination values and the cost table
     * @param prob
     */
    public static void initProblem ( Problem prob ) {
        int nrDest = 3;
        int nrSource = 3;
        int[][] costTable = {
                { 2, 3, 1 },
                { 5, 4, 8 },
                { 5, 6, 8 }
        };
        prob.create ( costTable, nrSource, nrDest );

        prob.addDestination ( "D1", 20 );
        //prob.addDestination("D1",20);
        prob.addDestination ( "D2", 25 );
        prob.addDestination ( "D3", 25 );
        prob.addSource ( "S1", 10, "Factory" );
        //prob.addSource("S1",10,"Warehouse");
        prob.addSource ( "S2", 35, "Warehouse" );
        prob.addSource ( "S3", 25, "Warehouse" );
    }
}
