package byow.lab13;

import byow.Core.RandomUtils;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame {
    /** 本游戏窗口的宽度。 */
    private int width;
    /** 本游戏窗口的高度。 */
    private int height;
    /** 用户当前所处的轮次。 */
    private int round;
    /** 用于随机生成 String 的 Random 对象。 */
    private Random rand;
    /** 游戏是否结束。 */
    private boolean gameOver;
    /** 现在是否是玩家的回合。用于 spec 的最后一节
     * 'Helpful UI'（实用 UI）。 */
    private boolean playerTurn;
    /** 我们用来生成随机 String 的字符。 */
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    /** 鼓励性的短语。用于 spec 的最后一节 'Helpful UI'（实用 UI）。 */
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        long seed = Long.parseLong(args[0]);
        MemoryGame game = new MemoryGame(40, 40, seed);
        game.startGame();
    }

    public MemoryGame(int width, int height, long seed) {
        /* 设置 StdDraw，使其画布为一个宽 width、高 height 的 16x16 方格网格
         * 同时设置缩放比例，使左上角为 (0,0)，右下角为 (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        //TODO: 初始化随机数生成器
    }

    public String generateRandomString(int n) {
        //TODO: 生成长度为 n 的随机字母字符串
        return null;
    }

    public void drawFrame(String s) {
        //TODO: 取该字符串并将其显示在屏幕中央
        //TODO: 如果游戏尚未结束，在屏幕顶部显示相关的游戏信息
    }

    public void flashSequence(String letters) {
        //TODO: 逐字显示 letters 中的每个字符，确保在字符之间清空屏幕
    }

    public String solicitNCharsInput(int n) {
        //TODO: 读取玩家输入的 n 个字母
        return null;
    }

    public void startGame() {
        //TODO: 在游戏开始前设置任何相关的变量

        //TODO: 建立 Engine 循环
    }

}
