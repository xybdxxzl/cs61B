package game2048;

/** 表示 2048 棋盘上一个带数字方块的形象。
 *  @author P. N. Hilfinger.
 */
public class Tile {

    /** 一个位于 (ROW, COL)、以 VALUE 为值的新方块。此
     *  构造器是私有的，因此所有方块都由工厂方法
     *  create、move 和 merge 创建。 */
    private Tile(int value, int col, int row) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.next = null;
    }

    /** 返回我当前的行号。 */
    public int row() {
        return row;
    }

    /** 返回我当前的列号。 */
    public int col() {
        return col;
    }

    /** 返回传给构造器的值。 */
    public int value() {
        return value;
    }

    /** 返回我的下一状态。在我被移动或合并之前，我就是
     *  我自己的后继。 */
    public Tile next() {
        return next == null ? this : next;
    }

    /** 返回一个位于 (ROW, COL)、值为 VALUE 的新方块。 */
    public static Tile create(int value, int col, int row) {
        return new Tile(value, col, row);
    }

    /** 返回将我移动到 (COL, ROW) 的结果。 */
    public Tile move(int col, int row) {
        Tile result = new Tile(value, col, row);
        next = result;
        return result;
    }

    /** 返回在移动到 (COL, ROW) 之后将 OTHERTILE 与我合并
     *  的结果。 */
    public Tile merge(int col, int row, Tile otherTile) {
        assert value == otherTile.value();
        next = otherTile.next = new Tile(2 * value, col, row);
        return next;
    }

    /** 返回我与后继方块之间的行或列距离
     *  （如果我没有后继则为 0）。 */
    public int distToNext() {
        if (next == null) {
            return 0;
        } else {
            return Math.max(Math.abs(row - next.row()),
                            Math.abs(col - next.col()));
        }
    }

    @Override
    public String toString() {
        return String.format("%d@(%d, %d)", value(), col(), row());
    }

    /** 我的值。 */
    private final int value;

    /** 我在棋盘上的最后位置。 */
    private final int row, col;

    /** 后继方块：我移动后或合并后的那个方块。 */
    private Tile next;
}
