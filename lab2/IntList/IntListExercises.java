package IntList;

public class IntListExercises {

    /**
     * 第 A 部分：（有 bug 的）变异方法，向 IntList 的每个元素
     * 加上一个常量 C
     *
     * @param lst 来自课堂讲解的 IntList
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
        while (head.rest != null) {
            head.first += c;
            head = head.rest;
        }
    }

    /**
     * 第 B 部分：有 bug 的方法，对于 L 中的每个节点，
     * 如果从该节点开始的列表中的最大值其首位数字
     * 与末位数字相同，则将该节点的 first 置为零
     *
     * @param L 来自课堂讲解的 IntList
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))) {
                p.first = 0;
            }
            p = p.rest;
        }
    }

    /** 返回从 L 开始的 IntList 中的最大值。 */
    public static int max(IntList L) {
        int max = L.first;
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }

    /** 如果 x 的末位数字等于 x 的首位数字，
     *  则返回 true。
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        int lastDigit = x % 10;
        while (x > 10) {
            x = x / 10;
        }
        int firstDigit = x % 10;
        return firstDigit == lastDigit;
    }

    /**
     * 第 C 部分：（有 bug 的）变异方法，对 IntList 中的每个
     * 质数元素求平方。
     *
     * @param lst 来自课堂讲解的 IntList
     * @return 如果列表发生了更新则为 true
     */
    public static boolean squarePrimes(IntList lst) {
        // 基本情况：我们已经到达列表的末尾
        if (lst == null) {
            return false;
        }

        boolean currElemIsPrime = Primes.isPrime(lst.first);

        if (currElemIsPrime) {
            lst.first *= lst.first;
        }

        return currElemIsPrime || squarePrimes(lst.rest);
    }
}
