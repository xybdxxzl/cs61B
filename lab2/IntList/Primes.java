package IntList;

public class Primes {

    /**
     * 这个（复杂的）算法在其参数为质数时返回 True，
     * 否则返回 False。调试时，步入（step into）这个函数可能
     * 不是个好主意！不妨考虑步过（step *over*）这个函数，
     * 并确保它的返回值是合理的。
     *
     * 如果你好奇的话，该算法使用费马小定理（Fermat's Little Theorem）作为
     * 素性测试，并且有很大概率（w.h.p.）返回正确答案（因为存在
     * Carmichael 数）。如果这对你来说毫无意义，很好！它本来就不应该有。
     * 这个函数的目标是让你学会抽象掉函数的内部
     * 运作，并用“Step Over”功能将其作为黑盒来调试。
     *
     * @source: https://www.geeksforgeeks.org/primality-test-set-2-fermet-method/
     * @param n 任意整数
     * @return 当且仅当该整数为质数时返回 True
     */
    public static boolean isPrime(int n) {
        // 边界情况
        if (n <= 1 || n == 4) return false;
        if (n <= 3) return true;

        int k = 3; // 尝试 k = 3 次
        while (k > 0)
        {
            // 在 [2..n-2] 中随机取一个数
            // 上面的边界情况确保 n > 4
            int a = 2 + (int)(Math.random() % (n - 4));

            // 费马小定理
            if (power(a, n - 1, n) != 1)
                return false;

            k--;
        }

        return true;
    }

    /**
     * 这是 isPrime 的辅助方法。你可以忽略此方法。
     * 它是一个以对数时间计算 a^n mod p 的迭代函数
     *
     * @source: https://www.geeksforgeeks.org/primality-test-set-2-fermet-method/
     */
    static int power(int a, int n, int p)
    {
        // 初始化结果
        int res = 1;

        // 如果 'a' >= p，则更新 'a'
        a = a % p;

        while (n > 0)
        {
            // 如果 n 是奇数，将 'a' 与结果相乘
            if ((n & 1) == 1)
                res = (res * a) % p;

            // 现在 n 必定是偶数
            n = n >> 1; // n = n/2
            a = (a * a) % p;
        }
        return res;
    }

    /** 驱动程序代码 */
    public static void main(String[] args) {
        /* 打印前 20 个质数 */
        int primeCount = 0;
        int x = 2;

        while (primeCount < 20) {
            if (isPrime(x)) {
                System.out.println(x);
                primeCount++;
            }
            x++;
        }
    }
}
