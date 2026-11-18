package speed;

import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;

import hashmap.Map61B;
import hashmap.ULLMap;
import hashmap.MyHashMap;

/**
 * 对三种不同的集合实现执行计时测试。
 * 对于 hashmap.MyHashMap 而言，假定 <K,V> 是 <String, Integer> 键值对。
 * @author Josh Hug 
 * @author Brendan Hu
 */
public class InsertInOrderSpeedTest {
    /**
     * 请求用户输入，并对三种不同的集合实现执行测试。ARGS 未使用。 
     */
    public static void main(String[] args) throws IOException {
        int N;
        Scanner input = new Scanner(System.in);

        // 借用 InsertRandomSpeedTest 中的 waitForPositiveInt(Scanner input)
        InsertRandomSpeedTest i = new InsertRandomSpeedTest();

        System.out.println("\n This program inserts lexicographically increasing Strings"
                + "into Maps as <String, Integer> pairs.");

        String repeat = "y";
        do {
            System.out.print("\nEnter # strings to insert into hashmap.ULLMap: ");
            timeInOrderMap61B(new ULLMap<String, Integer>(),
                    i.waitForPositiveInt(input));

            System.out.print("\nEnter # strings to insert into hashmap.MyHashMap: ");
            timeInOrderMap61B(new MyHashMap<String, Integer>(),
                    i.waitForPositiveInt(input));

            System.out.print("\nEnter # strings to insert into Java's HashMap: ");
            timeInOrderHashMap(new HashMap<String, Integer>(),
                    i.waitForPositiveInt(input));

            System.out.print("\nWould you like to try more timed-tests? (y/n): ");
            repeat = input.nextLine();
        } while (!repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("no"));
        input.close();
    }

    /**
     * 返回按递增顺序将 N 个字符串放入 hashmap.Map61B 所需的时间。
     * 利用了 speed.StringUtils.nextString(String s)
     */
    public static double insertInOrder(Map61B<String, Integer> map61B, int N) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.nextString(s);
            map61B.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }

    /**
     * 返回按递增顺序将 N 个字符串放入 HashMap 所需的时间。
     */
    public static double insertInOrder(HashMap<String, Integer> ts, int N) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.nextString(s);
            ts.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }

    /**
     * 尝试将 N 个按顺序排列的、长度为 L 的字符串插入 map，
     * 打印 N 次插入调用所耗的时间，否则
     * 打印一条关于错误的友好消息
     */
    public static void timeInOrderMap61B(Map61B<String, Integer> map, int N) {
        try {
            double mapTime = insertInOrder(map, N);
            System.out.printf(map.getClass() + ": %.2f sec\n", mapTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * 尝试将 N 个按顺序排列的、长度为 L 的字符串插入 HashMap，
     * 打印 N 次插入调用所耗的时间，否则
     * 打印一条关于错误的友好消息
     */
    public static void timeInOrderHashMap(HashMap<String, Integer> hashMap, int N) {
        try {
            double javaTime = insertInOrder(hashMap, N);
            System.out.printf("Java's Built-in HashMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* ------------------------------- 私有方法 ------------------------------- */

    /**
     * 在捕获 StackOverflowError 之后调用
     * 打印带有相应 N 和 L 的错误
     */
    private static void printInfoOnStackOverflow(int N) {
        System.out.println("--Stack Overflow -- couldn't add " + N + " strings.");
    }
}

