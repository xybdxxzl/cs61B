package game2048;

/** 棋盘四个侧面的符号名称。
 *  @author P. N. Hilfinger */
public enum Side {
    /** 下面每个符号方向 D 的参数（COL0、ROW0、DCOL 和 DROW）
     *  应按如下方式理解：
     *     棋盘的标准方向以棋盘的顶部
     *     为 NORTH，行和列（参见 Model）从棋盘的
     *     左下角开始编号。考虑将棋盘的方向调整为
     *     使棋盘的 D 侧离你最远。那么
     *        * (COL0*s, ROW0*s) 是重新定向后的棋盘
     *          左下角的标准坐标（其中 s 是
     *          棋盘大小），且
     *        * 若 (c, r) 是重新定向后的棋盘上某个
     *          格子的标准坐标，则 (c+DCOL, r+DROW)
     *          是其在重新定向后的棋盘上正上方
     *          那些格子的标准坐标。
     *  如此费心的用意在于：通过使用下面的
     *  col() 和 row() 方法在重新定向坐标与
     *  标准坐标之间转换，就可以用完全相同的代码
     *  来计算朝任意特定方向倾斜棋盘的结果。 */

    NORTH(0, 0, 0, 1), EAST(0, 1, 1, 0), SOUTH(1, 1, 0, -1),
    WEST(1, 0, -1, 0);

    /** 从棋盘上任何格子出发沿方向 (DCOL, DROW) 所到达的那一侧。
     *  这里，“方向 (DCOL, DROW)”意味着朝这一 Side 的方向
     *  移动一格会使行增加 DROW、列增加 DCOL。(COL0, ROW0) 是
     *  当你坐在棋盘前、面向这一 Side 时左下角格子的
     *  行和列。 */
    Side(int col0, int row0, int dcol, int drow) {
        this.row0 = row0;
        this.col0 = col0;
        this.drow = drow;
        this.dcol = dcol;
    }

    /** 返回 S 侧相对的那一侧。 */
    static Side opposite(Side s) {
        if (s == NORTH) {
            return SOUTH;
        } else if (s == SOUTH) {
            return NORTH;
        } else if (s == EAST) {
            return WEST;
        } else {
            return EAST;
        }
    }

    /** 返回大小为 SIZE 的棋盘上格子 (C, R) 的标准列号，
     *  该棋盘以这一 Side 朝上。 */
    public int col(int c, int r, int size) {
        return col0 * (size - 1) + c * drow + r * dcol;
    }

    /** 返回大小为 SIZE 的棋盘上格子 (C, R) 的标准行号，
     *  该棋盘以这一 Side 朝上。 */
    public int row(int c, int r, int size) {
        return row0 * (size - 1) - c * dcol + r * drow;
    }

    /** 描述这一 Side 的参数，如本类开头注释所
     *  记载的那样。 */
    private int row0, col0, drow, dcol;

};
