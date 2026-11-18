package byow.lab12;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

/**
 *  绘制一个除了一小块区域之外大部分为空的世界。
 */
public class BoringWorldDemo {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    public static void main(String[] args) {
        // 用大小为 WIDTH x HEIGHT 的窗口初始化 tile 渲染引擎
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // 初始化 tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // 填充一个宽 14 个 tile、高 4 个 tile 的区块
        for (int x = 20; x < 35; x += 1) {
            for (int y = 5; y < 10; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }

        // 将世界绘制到屏幕上
        ter.renderFrame(world);
    }


}
