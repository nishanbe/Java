public class Exercise2 {
    public static void main(String[] args){
/*
Which integer between 1 and 10000 has the largest number of divisors, and how many divisors does it have?
Write a program to find the answers and print out the results.
It is possible that several integers in this range have the same, maximum number of divisors.
Your program only has to print out one of them. An example in Subsection 3.4.2 discussed divisors.
The source code for that example is CountDivisors.java.
You might need some hints about how to find a maximum value.
The basic idea is to go through all the integers, keeping track of the largest number of divisors that you've seen so far.
Also, keep track of the integer that had that number of divisors.
*/

        int num;
        int maxDivisors = 1;
        int numWithMaxDivisors = 1;
        int divisor;

        for(num = 1; num <= 10000 ; num++){
            int divisorCount = 0;

            for(divisor = 1; divisor <= num; divisor++){

                if(num % divisor == 0){
                    divisorCount++;
                }
                if (divisorCount > maxDivisors){
                    maxDivisors = divisorCount;
                    numWithMaxDivisors = num;
                }
            }
        }
        System.out.println("The integer between 1 and 10000 that has the largest number of divisors is = " + numWithMaxDivisors);
        System.out.println("It has " + maxDivisors + " divisors");

    }
}