package byow.InputDemo;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Random;

/**
 * 由 hug 创建。
 */
public class RandomInputSource implements InputSource {
    Random r;

    public RandomInputSource(Long seed) {
        r = new Random(seed);
    }

    /** 返回一个 a 到 z 之间的随机字母。*/
    public char getNextKey() {
        return (char) (r.nextInt(26) + 'A');
    }

    public boolean possibleNextInput() {
        return true;
    }
}
