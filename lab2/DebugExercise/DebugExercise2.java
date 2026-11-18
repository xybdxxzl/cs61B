package DebugExercise;

/**
 * 用于展示步过（step over）按钮的练习。
 * 代码改编自 https://stackoverflow.com/questions/4895173/bitwise-multiply-and-add-in-java 与 https://stackoverflow.com/questions/1533131/what-useful-bitwise-operator-code-tricks-should-a-developer-know-about
 */
public class DebugExercise2 {
    /** 返回 a 与 b 中的最大值。不要步入（step into）此函数。 */
    public static int max(int a, int b) {
        int w = (b - a) >> 31;
        /* 如果你步入了此函数，请点击
           步出（step out）按钮，因为你不会学到任何东西。 */
        int z = ~(b - a) >> 31;

        int max = b & w | a & z;
        return max;
    }


    /** 返回 a 与 b 的和。不要步入（step into）此函数。 */
    public static int add(int a, int b) {
        int x = a, y = b;
        /* 如果你步入了此函数，请点击
           步出（step out）按钮，因为你不会学到任何东西。 */
        int xor, and, temp;
        and = x & y;
        xor = x ^ y;

        while (and != 0) {
            and <<= 1;
            temp = xor ^ and;
            and &= xor;
            xor = temp;
        }
        return xor;
    }

    /** 返回一个新数组，其中第 i 项是 a[i] 与 b[i] 中的最大值。
     * 例如，若 a = {1, -10, 3} 且 b = {0, 20, 5}，
     * 此函数将返回 {1, 20, 5}。
     * */
    public static int[] arrayMax(int[] a, int[] b) {
        if (a.length != b.length) {
            System.out.println("ERROR! Arrays don't match");
            return null;
        }
        int[] returnArray = new int[a.length];
        for (int i = 0; i < a.length; i += 1) {
            int biggerValue = max(a[i], b[i]);
            returnArray[i] = biggerValue;
        }

        return returnArray;
    }

    /** 返回 x 中所有元素的和。 */
    public static int arraySum(int[] x) {
        int i = 0;
        int sum = 0;
        while (i < x.length) {
            sum = sum + add(sum, x[i]);
            i = i + 1;
        }
        return sum;
    }

    /** 返回 a 与 b 逐元素最大值的总和。
     *  例如，若 a = {2, 0, 10, 14} 且 b = {-5, 5, 20, 30}，
     *  结果应为 57。
     * */
    public static int sumOfElementwiseMaxes(int[] a, int[] b) {
        int[] maxes = arrayMax(a, b);
        int sumofMaxes = arraySum(maxes);
        return sumofMaxes;
    }


    public static void main(String[] args) {
        int[] a = {1, 11, -1, -11};
        int[] b = {3, -3, 2, -1};

        int sumOfElementwiseMaxes = sumOfElementwiseMaxes(a, b);
        System.out.println(sumOfElementwiseMaxes);
    }
}
