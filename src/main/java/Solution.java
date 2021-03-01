public class Solution {
    public void resolve(Problem prob) {

        verify( prob ); //Verificam daca exista o solutie posibila

        BasicSolution( prob ); //Resolve the demands supply one by one,taking from Sources supply one by one in order
        //This method doesn't care about the final cost


    }

    /**
     * A solution that doesn't care about the final cost, first Source gives all its supply to the first Destination,after that, to the second
     * until it doesn't have any supply left, then the second Source 'donates' its supply, and algorithm keeps going until all the Destinations have their supply met
     * @param prob
     */
    private void BasicSolution(Problem prob) {
        int contorSupply = 0;
        int costTotal = 0;
        for ( int i = 0 ; i < prob.getdSize() ; i++ )
            if ( prob.getD()[i].getSupply() != 0 ) {
                if ( prob.getS()[contorSupply].getSupply() > prob.getD()[i].getSupply() ) {
                    int sum = prob.getCostTabel()[contorSupply][i] * prob.getD()[i].getSupply();
                    System.out.println( prob.getS()[contorSupply].getName() + " -> " + prob.getD()[i].getName() + " : " + prob.getD()[i].getSupply() + " units * cost "
                            + prob.getCostTabel()[contorSupply][i] + " = " + sum );

                    costTotal += sum;
                    prob.getS()[contorSupply].setSupply( prob.getS()[contorSupply].getSupply() - prob.getD()[i].getSupply() );
                    prob.getD()[i].setSupply( 0 );

                } else if ( prob.getS()[contorSupply].getSupply() == prob.getD()[i].getSupply() ) {
                    int sum = prob.getCostTabel()[contorSupply][i] * prob.getD()[i].getSupply();
                    System.out.println( prob.getS()[contorSupply].getName() + " -> " + prob.getD()[i].getName() + " : " + prob.getD()[i].getSupply() + " units * cost " + prob.getCostTabel()[contorSupply][i] + " = " + sum );
                    costTotal += sum;
                    prob.getD()[i].setSupply( 0 );
                    prob.getS()[contorSupply].setSupply( 0 );
                    contorSupply++;
                } else {
                    int sum = prob.getCostTabel()[contorSupply][i] * prob.getD()[i].getSupply();
                    System.out.println( prob.getS()[contorSupply].getName() + " -> " + prob.getD()[i].getName() + " : " + prob.getS()[contorSupply].getSupply() + " units * cost " + prob.getCostTabel()[contorSupply][i] + " = " + sum );
                    costTotal += sum;
                    prob.getD()[i].setSupply( prob.getD()[i].getSupply() - prob.getS()[contorSupply].getSupply() );
                    prob.getS()[contorSupply].setSupply( 0 );
                    contorSupply++;
                    i--;
                }
            }
        System.out.println( "Total cost: " + costTotal );
    }

    /**
     * Verify that Sources has enough supply for Destinations
     * @param prob
     */
    public void verify(Problem prob) {
        int supplyLeft = 0;                   //Verificam daca exista o solutie posibila
        for ( int i = 0 ; i < prob.getsSize() ; i++ )
            supplyLeft += prob.getS()[i].getSupply();
        for ( int i = 0 ; i < prob.getdSize() ; i++ )
            supplyLeft -= prob.getD()[i].getSupply();
        if ( supplyLeft < 0 ) {
            System.err.println( "Nu exista solutie pentru aceste valori." );
            System.exit( 2 );
        }
    }

}
