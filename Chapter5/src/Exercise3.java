public class Exercise3 {
    private static PairOfDice2 dice = new PairOfDice2();


    public static void main(String[] args){
        System.out.println("Total   Average Rolls           Max Rolls   Standard Deviation");
        System.out.println("--------------------------------------------------------------");
        StatCalcWithMinMax stats = new StatCalcWithMinMax();
        for (int i = 2; i <= 12; i++){
            for (int n = 0; n <= 10000; n++){
                stats.enter(rollFor(i));
            }
        System.out.print(i + "\t\t");
        System.out.print(stats.getMean() + "\t\t");
        System.out.print(stats.getMax() + "\t\t");
        System.out.print(stats.getStandardDeviation() + "\t\n");
        }
    }

    static int rollFor(int chosenNumber){
        int count = 0;
        do {
            dice.roll();
            count++;
        } while (dice.getTotal() != chosenNumber);
        return count;
    }

}
