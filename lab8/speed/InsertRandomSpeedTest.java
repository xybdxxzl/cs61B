package speed;

import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;

import hashmap.Map61B;
import hashmap.ULLMap;
import hashmap.MyHashMap;

/** 对三种不同的集合实现执行计时测试。
 *  @author Josh Hug
 *  @author Brendan Hu
 */
public class InsertRandomSpeedTest {
    /**
     * 请求用户输入，并对三种不同的集合实现执行测试。ARGS 未使用。 
     */
    public static void main(String[] args) throws IOException {
        int N;
        Scanner input = new Scanner(System.in);

        System.out.println("\n This program inserts random "
                + "Strings of length L\n"
                + " Into different types of maps "
                + "as <String, Integer> pairs.\n");
        System.out.print("What would you like L to be?: ");
        int L = waitForPositiveInt(input);

        String repeat = "y";
        do {
            System.out.print("\nEnter # strings to insert into hashmap.ULLMap: ");
            timeRandomMap61B(new ULLMap<String, Integer>(),
                    waitForPositiveInt(input), L);

            System.out.print("\nEnter # strings to insert into your hashmap.MyHashMap: ");
            timeRandomMap61B(new MyHashMap<String, Integer>(),
                    waitForPositiveInt(input), L);

            System.out.print("\nEnter # strings to insert into Java's HashMap: ");
            timeRandomHashMap(new HashMap<String, Integer>(),
                    waitForPositiveInt(input), L);

            System.out.print("\nWould you like to try more timed-tests? (y/n)");
            repeat = input.nextLine();
        } while (!repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("no"));
        input.close();
    }

    /**
     * 返回将 N 个长度为 L 的随机字符串放入
     * hashmap.Map61B 61bMap 所需的时间。
     */
    public static double insertRandom(Map61B<String, Integer> map61B, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            map61B.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }

    /**
     * 返回将 N 个长度为 L 的随机字符串放入
     * HashMap hashMap 所需的时间。
     */
    public static double insertRandom(HashMap<String, Integer> hashMap, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            hashMap.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }

    /**
     * 尝试将 N 个长度为 L 的随机字符串插入 map，
     * 打印 N 次插入调用所耗的时间，否则
     * 打印一条关于错误的友好消息
     */
    public static void timeRandomMap61B(Map61B<String, Integer> map, int N, int L) {
        try {
            double mapTime = insertRandom(map, N, L);
            System.out.printf(map.getClass() + ": %.2f sec\n", mapTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * 尝试将 N 个长度为 L 的随机字符串插入 HashMap
     * 打印 N 次插入调用所耗的时间，否则
     * 打印一条关于错误的友好消息
     */
    public static void timeRandomHashMap(HashMap<String, Integer> hashMap, int N, int L) {
        try {
            double javaTime = insertRandom(hashMap, N, L);
            System.out.printf("Java's Built-in HashMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待 Scanner 另一侧的用户
     * 输入一个正整数，
     * 并输出该整数
     */
    public static int waitForPositiveInt(Scanner input) {
        int ret = 0;
        do {
            while (!input.hasNextInt()) {
                errorBadIntegerInput();
                input.next();
            }
            ret = input.nextInt();
            input.nextLine(); //消耗 nextInt() 未取走的 \n
        } while (ret <= 0);
        return ret;
    }
    /* ------------------------------- 私有方法 ------------------------------- */
    /**
     * 在捕获 StackOverflowError 之后调用
     * 打印带有相应 N 和 L 的错误
     */
    private static void printInfoOnStackOverflow(int N, int L) {
        System.out.println("--Stack Overflow -- couldn't add " + N
                + " strings of length " + L + ".");
    }

    /**
     * 在输入有误时为用户打印一条友好消息
     */
    private static void errorBadIntegerInput() {
        System.out.print("Please enter a positive integer: ");
    }

}

