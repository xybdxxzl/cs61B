package speed;

import java.util.regex.Pattern;
import java.util.Random;

/** 用于字符串的实用函数。
 *  @author Josh Hug
 */
public class StringUtils {
    /** 用来让风格检查器（style checker）安静下来。 */
    private static final int ALPHABET_SIZE = 26;

    /** 本类使用的随机数生成器。 */
    private static Random r = new Random();

    /** 将随机种子设为 L，使 randomString 的结果可预测。*/
    public static void setSeed(long l) {
        r = new Random(l);
    }

    /** 返回长度为 LENGTH 的下一个随机字符串。 */
    public static String randomString(int length) {
        char[] someChars = new char[length];
        for (int i = 0; i < length; i++) {
            someChars[i] = (char) (r.nextInt(ALPHABET_SIZE) + 'a');
        }
        return new String(someChars);
    }

    /**
     * 如果字符串 S 仅由 'a' 到 'z' 之间的字符组成，
     * 则返回 true。不允许包含空格、数字、大写字母或任何其他
     * 字符。
     */
    public static boolean isLowerCase(String s) {
        return Pattern.matches("[a-z]*", s);
    }

    /**
     * 返回按字母顺序紧跟在 S 之后的字符串。
     * 例如，如果 s 是 'potato'，此方法将返回 'potatp'。如果
     * 最后一个字符是 z，则我们进位到下一个位置，依此类推。
     */
    public static String nextString(String s) {
        /* 将全为 z 的情况作为特殊情况处理，以保持辅助方法简单。 */
        if (isAllzs(s)) {
            return allAs(s.length() + 1);
        }
        char[] charVersion = s.toCharArray();
        incrementCharArray(charVersion, charVersion.length - 1);
        return new String(charVersion);
    }

    /**
     * nextString 的辅助函数。将 X 的第 P 个位置
     * 加一，如果 p == 'z' 则回绕到 'a'。如果发生回绕，
     * 则我们需要进位，并将位置 P - 1 加一。
     *
     * 对于仅包含 z 的字符数组会失败。
     */
    private static void incrementCharArray(char [] x, int p) {
        if (x[p] != 'z') {
            x[p] += 1;
        } else {
            x[p] = 'a';
            incrementCharArray(x, p - 1);
        }
    }

    /** 返回一个由 LEN 个 'a' 组成的字符串。 */
    private static String allAs(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    /** 如果 S 全为 'z' 则返回 true。空字符串返回 false */
    public static boolean isAllzs(String s) {
        return Pattern.matches("[z]+", s);
    }

}

