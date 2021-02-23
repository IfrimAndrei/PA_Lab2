public class Problem {
    /*public  Problem(int sizeS,int sizeD,int[][] tabelCosturi)
    {

    }
    public void add*/


    public static void main ( String args[]){
        Source[] s=new Source[3];
        Destination[] d=new Destination[3];
        s[0]=new Source("S1",10,SourceType.WAREHOUSE);
        s[1]=new Source("S2",35,SourceType.WAREHOUSE);
        s[2]=new Source("S3",25,SourceType.FACTORY);
        d[0]=new Destination("D1",20);
        d[1]=new Destination("D2",25);
        d[2]=new Destination("D3",25);

        int[][] tabelCosturi={
                {2,3,1},
                {5,4,8},
                {5,6,8}
        };

        afisare(s, d, tabelCosturi);

    }

    private static void afisare(Source[] s, Destination[] d, int[][] tabelCosturi) {
        for(int i=0;i<7;i++)
            System.out.print(" ");
        System.out.println(d[0].getName()+" "+ d[1].getName()+" "+ d[2].getName()+" Supply");

        for(int x = 0; x< s.length; x++)
        {

            for(int i = 0; i<6- s[x].getName().length(); i++)
                System.out.print(" ");
            System.out.print(s[x].getName());
            for(int i = 0; i< d.length; i++)
            {
                for(int j = 0; j< d[i].getName().length()-1; j++)
                    System.out.print(" ");
                if(tabelCosturi[x][i]<9)
                    System.out.print(" ");
                System.out.print(tabelCosturi[x][i]);
            }
            System.out.println(" "+ s[x].getSupply());

        }
        System.out.println("Demand "+ d[0].getSupply()+" "+ d[1].getSupply()+" "+ d[2].getSupply());
    }


}
