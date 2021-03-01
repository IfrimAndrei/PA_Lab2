public class Solution {
    public void resolve(Problem prob)
    {

        verify(prob); //Verificam daca exista o solutie posibila

        BasicSolution(prob); //Resolve the demands supply one by one,taking from Sources supply one by one in order
                            //This method doesn't care about the final cost


    }

    private void BasicSolution(Problem prob) {
        int contorSupply=0;
        int costTotal=0;
        for(int i = 0; i< prob.dSize; i++)
            if(prob.d[i].getSupply()!=0)
            {
                if(prob.s[contorSupply].getSupply()> prob.d[i].getSupply())
                {
                    int sum= prob.costTabel[contorSupply][i]* prob.d[i].getSupply();
                    System.out.println(prob.s[contorSupply].getName() + " -> " + prob.d[i].getName() + " : " + prob.d[i].getSupply() + " units * cost "
                            + prob.costTabel[contorSupply][i] + " = " + sum );

                    costTotal+=sum;
                    prob.s[contorSupply].setSupply(prob.s[contorSupply].getSupply()- prob.d[i].getSupply()) ;
                    prob.d[i].setSupply(0);

                }
                else if (prob.s[contorSupply].getSupply()== prob.d[i].getSupply())
                {
                    int sum= prob.costTabel[contorSupply][i]* prob.d[i].getSupply();
                    System.out.println(prob.s[contorSupply].getName() + " -> " + prob.d[i].getName() + " : " + prob.d[i].getSupply() + " units * cost " + prob.costTabel[contorSupply][i]  + " = " + sum );
                    costTotal+=sum;
                    prob.d[i].setSupply(0);
                    prob.s[contorSupply].setSupply(0);
                    contorSupply++;
                }
                else
                {
                    int sum= prob.costTabel[contorSupply][i]* prob.d[i].getSupply();
                    System.out.println(prob.s[contorSupply].getName() + " -> " + prob.d[i].getName() + " : " + prob.s[contorSupply].getSupply() + " units * cost " + prob.costTabel[contorSupply][i]  + " = " + sum );
                    costTotal+=sum;
                    prob.d[i].setSupply(prob.d[i].getSupply()- prob.s[contorSupply].getSupply());
                    prob.s[contorSupply].setSupply(0);
                    contorSupply++;
                    i--;
                }
            }
        System.out.println("Total cost: "+costTotal);
    }

    public void verify(Problem prob)
    {
        int supplyLeft=0;                   //Verificam daca exista o solutie posibila
        for(int i=0;i<prob.sSize;i++)
            supplyLeft+=prob.s[i].getSupply();
        for(int i=0;i<prob.dSize;i++)
            supplyLeft-=prob.d[i].getSupply();
        if(supplyLeft<0)
        {
            System.err.println("Nu exista solutie pentru aceste valori.");
            System.exit(2);
        }
    }

}
