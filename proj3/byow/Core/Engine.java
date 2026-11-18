package byow.Core;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;

public class Engine {
    TERenderer ter = new TERenderer();
    /* 随意修改宽度和高度。 */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;

    /**
     * 用于探索一个全新世界的方法。此方法应处理所有输入，
     * 包括来自主菜单的输入。
     */
    public void interactWithKeyboard() {
    }

    /**
     * 用于自动评分和测试你的代码的方法。输入字符串将是一系列
     * 字符（例如 "n123sswwdasdassadwas"、"n123sss:q"、"lwww"）。引擎的行为应
     * 完全就像用户使用 interactWithKeyboard 将这些字符
     * 输入到引擎中一样。
     *
     * 回想一下，以 ":q" 结尾的字符串应使游戏退出并保存。例如，
     * 如果我们调用 interactWithInputString("n123sss:q")，我们期望游戏运行前
     * 7 条命令（n123sss），然后退出并保存。如果我们接着调用
     * interactWithInputString("l")，我们应该回到完全相同的状态。
     *
     * 换句话说，以下两个调用：
     *   - interactWithInputString("n123sss:q")
     *   - interactWithInputString("lww")
     *
     * 应产生与下面这个调用完全相同的世界状态：
     *   - interactWithInputString("n123sssww")
     *
     * @param input 要喂给你的程序的输入字符串
     * @return 表示世界状态的二维 TETile[][]
     */
    public TETile[][] interactWithInputString(String input) {
        // TODO: 填充此方法，使其使用作为参数传入的输入运行引擎，
        // 并返回一个二维 tile 表示；如果同样的输入
        // 传给 interactWithKeyboard()，世界就会画成那样。
        //
        // 参见 proj3.byow.InputDemo，了解如何做出一个简洁优雅、能适用于
        // 多种不同输入类型的接口的演示。

        TETile[][] finalWorldFrame = null;
        return finalWorldFrame;
    }
}
