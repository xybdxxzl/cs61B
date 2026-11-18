package byow.TileEngine;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;
import byow.Core.RandomUtils;

/**
 * TETile 对象用于表示你的世界中的单个 tile。由 tile 构成的二维数组组成
 * 一个棋盘，可以使用 TERenderer 类将其绘制到屏幕上。
 *
 * 所有 TETile 对象都必须有一个字符、文字颜色和背景颜色，用于在
 * 绘制到屏幕时表示该 tile。你还可以选择提供一张合适大小（16x16）的
 * 图片文件的路径，用它替代 unicode 表示来绘制。如果提供的图片路径
 * 找不到，draw 将回退为使用所提供的字符和颜色表示，
 * 因此你可以放心地在你自己的电脑上使用图片 tile。
 *
 * 所提供的 TETile 是不可变的，即它的任何实例变量都不能改变。如果你愿意，
 * 你可以自行将 TETile 类改为可变的。
 */

public class TETile {
    private final char character; // 不要重命名 character，否则自动评分系统会出错。
    private final Color textColor;
    private final Color backgroundColor;
    private final String description;
    private final String filepath;

    /**
     * TETile 对象的完整构造器。
     * @param character 显示在屏幕上的字符。
     * @param textColor 字符本身的颜色。
     * @param backgroundColor 绘制在字符背后的颜色。
     * @param description tile 的描述，在 GUI 中悬停于该 tile 上时显示。
     * @param filepath 用于此 tile 的图片的完整路径。必须是正确的大小（16x16）
     */
    public TETile(char character, Color textColor, Color backgroundColor, String description,
                  String filepath) {
        this.character = character;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.description = description;
        this.filepath = filepath;
    }

    /**
     * 不带 filepath 的构造器。此时 filepath 将为 null，因此绘制时我们
     * 甚至不会尝试绘制图片，而是使用所提供的字符和颜色。
     * @param character 显示在屏幕上的字符。
     * @param textColor 字符本身的颜色。
     * @param backgroundColor 绘制在字符背后的颜色。
     * @param description tile 的描述，在 GUI 中悬停于该 tile 上时显示。
     */
    public TETile(char character, Color textColor, Color backgroundColor, String description) {
        this.character = character;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.description = description;
        this.filepath = null;
    }

    /**
     * 创建 TETile t 的一个副本，只是使用给定的 textColor。
     * @param t 要复制的 tile
     * @param textColor tile 副本的前景颜色
     */
    public TETile(TETile t, Color textColor) {
        this(t.character, textColor, t.backgroundColor, t.description, t.filepath);
    }


    /**
     * 在位置 x, y 处将 tile 绘制到屏幕上。如果提供了有效的 filepath，
     * 我们就将位于该 filepath 的图片绘制到屏幕上。否则，我们回退
     * 到该 tile 的字符和颜色表示。
     *
     * 注意，所提供的图片必须是正确的大小（16x16）。它不会被
     * 自动缩放或裁剪。
     * @param x x 坐标
     * @param y y 坐标
     */
    public void draw(double x, double y) {
        if (filepath != null) {
            try {
                StdDraw.picture(x + 0.5, y + 0.5, filepath);
                return;
            } catch (IllegalArgumentException e) {
                // 该异常是因为找不到文件而发生的。在这种情况下，静默失败，
                // 并只使用该 tile 的字符和背景颜色。
            }
        }

        StdDraw.setPenColor(backgroundColor);
        StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
        StdDraw.setPenColor(textColor);
        StdDraw.text(x + 0.5, y + 0.5, Character.toString(character()));
    }

    /** tile 的字符表示。用于文本模式下绘制。
     * @return 字符表示
     */
    public char character() {
        return character;
    }

    /**
     * tile 的描述。用于显示鼠标悬停文本，或
     * 测试两个 tile 是否表示同一类东西。
     * @return tile 的描述
     */
    public String description() {
        return description;
    }

    /**
     * 创建给定 tile 的一个副本，其文字颜色略有不同。新颜色
     * 的红色值将在当前红色值的 dr 范围内，
     * dg 和 db 同理。
     * @param t 要复制的 tile
     * @param dr 红色值的最大差异
     * @param dg 绿色值的最大差异
     * @param db 蓝色值的最大差异
     * @param r 要使用的随机数生成器
     */
    public static TETile colorVariant(TETile t, int dr, int dg, int db, Random r) {
        Color oldColor = t.textColor;
        int newRed = newColorValue(oldColor.getRed(), dr, r);
        int newGreen = newColorValue(oldColor.getGreen(), dg, r);
        int newBlue = newColorValue(oldColor.getBlue(), db, r);

        Color c = new Color(newRed, newGreen, newBlue);

        return new TETile(t, c);
    }

    private static int newColorValue(int v, int dv, Random r) {
        int rawNewValue = v + RandomUtils.uniform(r, -dv, dv + 1);

        // 确保该值不会落在 0 到 255 的范围之外。
        int newValue = Math.min(255, Math.max(0, rawNewValue));
        return newValue;
    }

    /**
     * 将给定的二维数组转换为 String。便于调试。
     * 注意，由于使用 tile 渲染引擎绘制时，y = 0 实际上是你的世界的
     * 底部，因此这个打印方法必须以看起来像是倒序的顺序打印
     * （这样第 0 行会最后被打印）。
     * @param world 要打印的二维世界
     * @return 世界的字符串表示
     */
    public static String toString(TETile[][] world) {
        int width = world.length;
        int height = world[0].length;
        StringBuilder sb = new StringBuilder();

        for (int y = height - 1; y >= 0; y -= 1) {
            for (int x = 0; x < width; x += 1) {
                if (world[x][y] == null) {
                    throw new IllegalArgumentException("Tile at position x=" + x + ", y=" + y
                            + " is null.");
                }
                sb.append(world[x][y].character());
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * 创建给定二维 tile 数组的一个副本。
     * @param tiles 要复制的二维数组
     **/
    public static TETile[][] copyOf(TETile[][] tiles) {
        if (tiles == null) {
            return null;
        }

        TETile[][] copy = new TETile[tiles.length][];

        int i = 0;
        for (TETile[] column : tiles) {
            copy[i] = Arrays.copyOf(column, column.length);
            i += 1;
        }

        return copy;
    }
}
