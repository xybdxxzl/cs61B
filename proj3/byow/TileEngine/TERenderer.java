package byow.TileEngine;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;

/**
 * 用于渲染 tile 的实用类。你不需要修改此文件。但你也可以修改，
 * 只是要小心。我们强烈建议先把其他所有东西都弄好，然后
 * 再来折腾这个渲染器，除非你想做些花哨的事，比如
 * 允许屏幕滚动或跟踪角色之类的。
 */
public class TERenderer {
    private static final int TILE_SIZE = 16;
    private int width;
    private int height;
    private int xOffset;
    private int yOffset;

    /**
     * 功能与另一个初始化方法相同。唯一的区别是 xOff
     * 和 yOff 参数会改变 renderFrame 方法从何处开始绘制。例如，
     * 如果你选择 w = 60、h = 30、xOff = 3、yOff = 4，然后用一个
     * TETile[50][25] 数组调用 renderFrame，渲染器将在左侧留下 3 个 tile 的空白、右侧留下 7 个 tile 的空白、
     * 底部留下 4 个 tile 的空白，顶部留下 1 个 tile 的空白。
     * @param w 窗口宽度（以 tile 为单位）
     * @param h 窗口高度（以 tile 为单位）。
     */
    public void initialize(int w, int h, int xOff, int yOff) {
        this.width = w;
        this.height = h;
        this.xOffset = xOff;
        this.yOffset = yOff;
        StdDraw.setCanvasSize(width * TILE_SIZE, height * TILE_SIZE);
        Font font = new Font("Monaco", Font.BOLD, TILE_SIZE - 2);
        StdDraw.setFont(font);      
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        StdDraw.clear(new Color(0, 0, 0));

        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }

    /**
     * 初始化 StdDraw 参数并启动 StdDraw 窗口。w 和 h 是
     * 世界以 tile 数量计的宽度和高度。如果你传给
     * renderFrame 的 TETile[][] 数组比它小，那么就会在
     * 帧的右侧和顶部边缘留下额外的空白。例如，如果你选择 w = 60、
     * h = 30，此方法将创建一个宽 60 个 tile、高 30 个 tile 的窗口。如果
     * 你随后用一个 TETile[50][25] 数组调用 renderFrame，它将在
     * 右侧留下 10 个 tile 的空白、顶部留下 5 个 tile 的空白。如果
     * 你想改为在左侧或底部留出额外空间，请使用另一个
     * 初始化方法。
     * @param w 窗口宽度（以 tile 为单位）
     * @param h 窗口高度（以 tile 为单位）。
     */
    public void initialize(int w, int h) {
        initialize(w, h, 0, 0);
    }

    /**
     * 接收一个 TETile 对象的二维数组，并将该二维数组渲染到屏幕上，
     * 从 xOffset 和 yOffset 处开始。
     *
     * 如果该数组是 NxM 数组，那么显示在相应位置上的元素将如下所示
     * （以 tile 为单位）。
     *
     *              位置        xOffset |xOffset+1|xOffset+2| .... |xOffset+world.length
     *                     
     * startY+world[0].length   [0][M-1] | [1][M-1] | [2][M-1] | .... | [N-1][M-1]
     *                    ...    ......  |  ......  |  ......  | .... | ......
     *               startY+2    [0][2]  |  [1][2]  |  [2][2]  | .... | [N-1][2]
     *               startY+1    [0][1]  |  [1][1]  |  [2][1]  | .... | [N-1][1]
     *                 startY    [0][0]  |  [1][0]  |  [2][0]  | .... | [N-1][0]
     *
     * 通过改变 xOffset、yOffset 以及初始化时屏幕的大小，你可以在不同的
     * 位置留出空白空间，为其他信息（例如 GUI）腾出地方。
     * 此方法假定 xScale 和 yScale 已被设置为：x 的最大值
     * 是屏幕以 tile 计的宽度，y 的最大值是屏幕
     * 以 tile 计的高度。
     * @param world 要渲染的二维 TETile[][] 数组
     */
    public void renderFrame(TETile[][] world) {
        int numXTiles = world.length;
        int numYTiles = world[0].length;
        StdDraw.clear(new Color(0, 0, 0));
        for (int x = 0; x < numXTiles; x += 1) {
            for (int y = 0; y < numYTiles; y += 1) {
                if (world[x][y] == null) {
                    throw new IllegalArgumentException("Tile at position x=" + x + ", y=" + y
                            + " is null.");
                }
                world[x][y].draw(x + xOffset, y + yOffset);
            }
        }
        StdDraw.show();
    }
}
