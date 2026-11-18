package game2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author hug
 */
public class Board implements Iterable<Tile> {
    /** 棋盘的当前内容。 */
    private Tile[][] values;
    /** 棋盘当前视为“北”的一侧。 */
    private Side viewPerspective;

    public Board(int size) {
        values = new Tile[size][size];
        viewPerspective = Side.NORTH;
    }

    /** 移动棋盘的视角，使得棋盘的表现就好像 S 侧是北一样。 */
    public void setViewingPerspective(Side s) {
        viewPerspective = s;
    }

    /** 创建一个棋盘，其中 RAWVALUES 保存棋盘上各方块的值
     * （0 表示 null），当前分数为 SCORE，观看视角设为北。 */
    public Board(int[][] rawValues, int score) {
        int size = rawValues.length;
        values = new Tile[size][size];
        viewPerspective = Side.NORTH;
        for (int col = 0; col < size; col += 1) {
            for (int row = 0; row < size; row += 1) {
                int value = rawValues[size - 1 - row][col];
                Tile tile;
                if (value == 0) {
                    tile = null;
                } else {
                    tile = Tile.create(value, col, row);
                }
                values[col][row] = tile;
            }
        }
    }

    /** 返回棋盘的大小。 */
    public int size() {
        return values.length;
    }

    /** 移动棋盘的视角。 */
    public void startViewingFrom(Side s) {
        viewPerspective = s;
    }

    /** 返回 (COL, ROW) 处当前的 Tile，此时棋盘的方向使得
     *  SIDE 位于你视线的顶部（离你最远）。 */
    private Tile vtile(int col, int row, Side side) {
        return values[side.col(col, row, size())][side.row(col, row, size())];
    }

    /** 返回 (COL, ROW) 处当前的 Tile，其中 0 <= ROW < size()，
     *  0 <= COL < size()。如果该处没有方块则返回 null。 */
    public Tile tile(int col, int row) {
        return vtile(col, row, viewPerspective);
    }

    /** 将棋盘清空并重置分数。 */
    public void clear() {
        for (Tile[] column : values) {
            Arrays.fill(column, null);
        }
    }

    /** 将方块 T 添加到棋盘上 */
    public void addTile(Tile t) {
        values[t.col()][t.row()] = t;
    }

    /** 将 Tile TILE 放置在列 COL、行 ROW 处，其中 COL 和 ROW
     * 被视为相对于当前 viewPerspective 的坐标。
     *
     * 返回此次移动是否构成一次合并。
     * */
    public boolean move(int col, int row, Tile tile) {
        int pcol = viewPerspective.col(col, row, size()),
                prow = viewPerspective.row(col, row, size());
        if (tile.col() == pcol && tile.row() == prow) {
            return false;
        }
        Tile tile1 = vtile(col, row, viewPerspective);
        values[tile.col()][tile.row()] = null;

        if (tile1 == null) {
            values[pcol][prow] = tile.move(pcol, prow);
            return false;
        } else {
            values[pcol][prow] = tile.merge(pcol, prow, tile1);
            return true;
        }
    }

    @Override
    /** 返回棋盘的字符串表示，用于调试。 */
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
        return out.toString();
    }

    /** 遍历棋盘中的每一个方块。 */
    private class AllTileIterator implements Iterator<Tile>, Iterable<Tile> {
        int r, c;

        AllTileIterator() {
            r = 0;
            c = 0;
        }

        public boolean hasNext() {
            return r < size();
        }

        public Tile next() {
            Tile t = tile(c, r);
            c = c + 1;
            if (c == size()) {
                c = 0;
                r = r + 1;
            }
            return t;
        }

        public Iterator<Tile> iterator() {
            return this;
        }
    }

    public Iterator<Tile> iterator() {
        return new AllTileIterator();
    }

}
