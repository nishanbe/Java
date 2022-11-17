
import java.util.Scanner;
        import java.math.BigInteger;


public class Exercise1 {


    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
        while (true) {
            System.out.print("\n\nEnter a positive integer, or 0 to end:  ");
            int N = in.nextInt();
            if (N == 0)
                break;
            else if (N < 0) {
                System.out.println("Negative numbers are not allowed.");
                continue;
            }
            BigInteger NasBigInteger = BigInteger.valueOf(N);
            System.out.println("\n  factorial(" + N + ") is " + factorial(NasBigInteger));
            if (N > 40) {
                System.out.println("\n  N is too big to compute fibonacci(N) recursively");
            }
            else {
                System.out.println("\n  fibonacci(" + N + ") is " +
                        fibonacci(N) + "   (recursively)");
            }
            System.out.println("\n  fibonacci(" + N + ") is " +
                    fibonacci_nonrecursive(N) + "   (non-recursively)");
        }
    }


    static int fibonacci( int N ) {
        assert N >= 0 : "fibonacci(n) is only defined for non-negative n";
        assert N <= 40 : "n is to large to compute fibonacci(N) recursively";
        if ( N == 0 || N == 1 ) {
            // Base cases; the answer is 1.
            return 1;
        }
        else {
            // Recursive case; the answer is obtained by applying the function
            // recursively to N-1 and to N-2, and adding the two answers.
            return fibonacci(N-1) + fibonacci(N-2);
        }
    }



    static BigInteger fibonacci_nonrecursive( int N ) {
        assert N >= 0 : "fibonacci(n) is only defined for non-negative n";
        if (N == 0 || N == 1) {
            // fibonacci(0) = fibonacci(1) = 1;
            return BigInteger.ONE;
        }
        else {
            BigInteger f0 = BigInteger.ONE;  // In the loop, this is fibonacci(i-2)
            BigInteger f1 = BigInteger.ONE;  // In the loop, this is fibonacci(i-1)
            for (int i = 2; i <= N; i++) {
                BigInteger fi = f0.add(f1);  // Computes fibonacci(i)
                f0 = f1;  // Update to account for i++
                f1 = fi;  // Update to account for i++
            }
            return f1;  // Final value of f1 is fibonacci(N)
        }
    }


    static BigInteger factorial( BigInteger N ) {
        assert N.signum() >= 0 : "factorial(n) is only defined for non-negative n";
        if ( N.equals(BigInteger.ZERO) ) {
            // Base case; the answer is 1.
            return BigInteger.ONE;
        }
        else {
            // Recursive case; the answer is obtained by applying the function
            // recursively to N-1 and multiplying the answer by N.
            BigInteger factorialOfNMinus1 = factorial(N.subtract(BigInteger.ONE));
            return N.multiply(factorialOfNMinus1);
        }
    }

}