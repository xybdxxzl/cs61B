/** 该类用于打印从给定数字开始的 Collatz 序列（考拉兹序列）。
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** nextNumber 的有 bug 的实现！ */
    public static int nextNumber(int n) {
        if(n%2==0)
            return n/2;
        else
            return 3*n+1;

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

