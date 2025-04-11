public class RecursivevsIterativeFibonacciComputation {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Recursive Fibonacci of " + n + ": " + fibonacciRecursive(n));
        System.out.println("Iterative Fibonacci of " + n + ": " + fibonacciIterative(n));
    }
}
