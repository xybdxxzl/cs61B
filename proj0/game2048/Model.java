package game2048;

import java.util.Formatter;
import java.util.Observable;


/** 一局 2048 游戏的状态。
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /** 棋盘的当前内容。 */
    private Board board;
    /** 当前分数。 */
    private int score;
    /** 迄今为止的最高分。在游戏结束时更新。 */
    private int maxScore;
    /** 当且仅当游戏已结束时为 true。 */
    private boolean gameOver;

    /* 坐标系：棋盘的列 C、行 R（其中第 0 行、
     * 第 0 列是棋盘的左下角）将对应
     * board.tile(c, r)。注意！它的运作方式如同 (x, y) 坐标。
     */

    /** 最大的方块值。 */
    public static final int MAX_PIECE = 2048;

    /** 一局新的 2048 游戏，棋盘大小为 SIZE，没有方块
     *  且分数为 0。 */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /** 一局新的 2048 游戏，其中 RAWVALUES 包含各方块的值
     * （如果为 null 则为 0）。VALUES 以 (row, col) 为索引，(0, 0) 对应
     * 左下角。用于测试目的。 */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /** 返回 (COL, ROW) 处当前的 Tile，其中 0 <= ROW < size()，
     *  0 <= COL < size()。如果该处没有方块则返回 null。
     *  用于测试。应当被弃用并移除。
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** 返回棋盘一边的格子数。
     *  用于测试。应当被弃用并移除。 */
    public int size() {
        return board.size();
    }

    /** 当且仅当游戏结束（没有可移动的空间，或
     *  棋盘上有一个值为 2048 的方块）时返回 true。 */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /** 返回当前分数。 */
    public int score() {
        return score;
    }

    /** 返回当前最高游戏分数（在游戏结束时更新）。 */
    public int maxScore() {
        return maxScore;
    }

    /** 将棋盘清空并重置分数。 */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /** 将 TILE 添加到棋盘上。当前相同位置必须
     *  没有 Tile。 */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** 将棋盘朝 SIDE 方向倾斜。当且仅当这改变了棋盘时返回 true。
     *
     * 1. 如果两个 Tile 对象在运动方向上相邻且具有
     *    相同的值，它们会合并为一个值为原来两倍的 Tile，
     *    并且该新值会加到 score 实例变量上
     * 2. 作为合并结果的方块在该次倾斜中不会再次合并。
     *    因此每次移动中，每个方块至多只会参与一次
     *    合并（也可能为零次）。
     * 3. 当运动方向上有三个相邻方块具有相同
     *    值时，运动方向上最前面的两个方块合并，
     *    而末尾的方块不合并。
     * */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

        // TODO: 修改 this.board（也许还有 this.score）以处理
        // 朝 SIDE 方向的倾斜。如果棋盘发生了变化，将
        // changed 局部变量设为 true。

        checkGameOver();
        if (changed) {
            setChanged();
        }
        return changed;
    }

    /** 检查游戏是否结束，并相应地设置 gameOver
     *  变量。
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /** 判断游戏是否结束。 */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** 如果棋盘上至少有一个空格子则返回 true。
     *  空格子存储为 null。
     * */
    public static boolean emptySpaceExists(Board b) {
        // TODO: 填写此函数。
        return false;
    }

    /**
     * 如果任何方块等于最大有效值，则返回 true。
     * 最大有效值由 MAX_PIECE 给出。注意，
     * 给定一个 Tile 对象 t，我们通过 t.value() 获取其值。
     */
    public static boolean maxTileExists(Board b) {
        // TODO: 填写此函数。
        return false;
    }

    /**
     * 如果棋盘上存在任何有效的移动，则返回 true。
     * 有效的移动有两种情形：
     * 1. 棋盘上至少有一个空格子。
     * 2. 有两个相邻的方块具有相同的值。
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO: 填写此函数。
        return false;
    }


    @Override
     /** 返回 model 的字符串表示，用于调试。 */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** 返回两个 model 是否相等。 */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** 返回 Model 字符串的哈希码。 */
    public int hashCode() {
        return toString().hashCode();
    }
}
