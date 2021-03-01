public class main {
    public static void main(String[] args) {
        Problem problema=new Problem();
        initProblem(problema);
        System.out.println(problema.toString());
    }
    public static void initProblem(Problem problema)
    {
        int[][] tabelCosturi = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };
        problema.create(tabelCosturi);

        problema.addDestination("D1",20);
        //problema.addDestination("D1",20);
        problema.addDestination("D2",25);
        problema.addDestination("D3",25);
        problema.addSource("S1",10,"Factory");
        //problema.addSource("S1",10,"Warehouse");
        problema.addSource("S2",35,"Warehouse");
        problema.addSource("S3",25,"Warehouse");
    }
}
