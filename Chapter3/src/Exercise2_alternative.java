public class Exercise2_alternative {
    /*
Which integer between 1 and 10000 has the largest number of divisors, and how many divisors does it have?
Write a program to find the answers and print out the results.
It is possible that several integers in this range have the same, maximum number of divisors.
Your program only has to print out one of them. An example in Subsection 3.4.2 discussed divisors.
The source code for that example is CountDivisors.java.
You might need some hints about how to find a maximum value.
The basic idea is to go through all the integers, keeping track of the largest number of divisors that you've seen so far.
Also, keep track of the integer that had that number of divisors.

    public static void main(String[] args) {
        countDivisors(N:100);

        int MAX_INDEX = 10000;
        int maxCount = 0;
        int bestVal = 0;

        for (int i = 0; i < MAX_INDEX; I++){
            int n = i + 1;
            int count = countDivisors(n);
            if (count > maxCount){
                bestVal = n;
                maxCount = count;
                System.out.println("best=" + bestVal + ", max" + maxCount);
            }
        }
    }

    public static int countDivisors(int N){
        int testDivisor;
        int divisorCount;
        int numberTested;
        divisorCount = 0;
        numberTested = 0;

        for(testDivisor = 1; testDivisor <=N; testDivisor++){
            if (N % testDivisor == 0)
                divisorCount++;
        }
        int MAX_INDEX = 10000;
    }
*/
}
