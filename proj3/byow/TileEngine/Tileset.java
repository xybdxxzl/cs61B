package byow.TileEngine;

import java.awt.Color;

/**
 * 包含常量 tile 对象，以避免在代码的不同部分
 * 重复创建相同的 tile。
 *
 * 你可以自由地（并且我们鼓励你）创建自己的 tile 并添加到本文件。本文件将
 * 随你的其余代码一起提交。
 *
 * 例如：
 *      world[x][y] = Tileset.FLOOR;
 *
 * 由于使用了 unicode 字符，当你尝试对本文件做风格检查（style check）时，
 * 风格检查器可能会崩溃。这没关系。
 */

public class Tileset {
    public static final TETile AVATAR = new TETile('@', Color.white, Color.black, "you");
    public static final TETile WALL = new TETile('#', new Color(216, 128, 128), Color.darkGray,
            "wall");
    public static final TETile FLOOR = new TETile('·', new Color(128, 192, 128), Color.black,
            "floor");
    public static final TETile NOTHING = new TETile(' ', Color.black, Color.black, "nothing");
    public static final TETile GRASS = new TETile('"', Color.green, Color.black, "grass");
    public static final TETile WATER = new TETile('≈', Color.blue, Color.black, "water");
    public static final TETile FLOWER = new TETile('❀', Color.magenta, Color.pink, "flower");
    public static final TETile LOCKED_DOOR = new TETile('█', Color.orange, Color.black,
            "locked door");
    public static final TETile UNLOCKED_DOOR = new TETile('▢', Color.orange, Color.black,
            "unlocked door");
    public static final TETile SAND = new TETile('▒', Color.yellow, Color.black, "sand");
    public static final TETile MOUNTAIN = new TETile('▲', Color.gray, Color.black, "mountain");
    public static final TETile TREE = new TETile('♠', Color.green, Color.black, "tree");
}


