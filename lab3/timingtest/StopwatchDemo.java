package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * 由 hug 创建。
 */
public class StopwatchDemo {
    /** 使用慢速的朴素递归策略计算第 n 个斐波那契数。*/
    private static int fib(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        int fib41 = fib(41);
        double timeInSeconds = sw.elapsedTime();
        System.out.println("The 50th fibonacci number is " + fib41);
        System.out.println("Time taken to compute 41st fibonacci number: " + timeInSeconds + " seconds.");
    }
}
