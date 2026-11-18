package game2048;

import org.junit.Test;

import static org.junit.Assert.*;

/** 测试 Model 的 emptySpaceExists() 静态方法。
 *
 * @author Omar Khan
 */
public class TestEmptySpace {

    /** 我们将要在其上进行测试的 Board。 */
    static Board b;

    @Test
    /** 注意，这并不是一个可能出现的棋盘状态。 */
    public void testCompletelyEmpty() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals, 0);
        assertTrue("Board is full of empty space\n" + b,
                Model.emptySpaceExists(b));
    }

    @Test
    /** 测试一个除了顶行以外完全填满的棋盘。 */
    public void testEmptyTopRow() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
        };

        b = new Board(rawVals, 0);

        assertTrue("Top row is empty\n" + b, Model.emptySpaceExists(b));
    }

    @Test
    /** 测试一个除了底行以外完全填满的棋盘。 */
    public void testEmptyBottomRow() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals, 0);
        assertTrue("Bottom row is empty\n" + b,
                Model.emptySpaceExists(b));
    }


    @Test
    /** 测试一个除了左列以外完全填满的棋盘。 */
    public void testEmptyLeftCol() {
        int[][] rawVals = new int[][] {
                {0, 4, 2, 4},
                {0, 2, 4, 2},
                {0, 4, 2, 4},
                {0, 2, 4, 2},
        };

        b = new Board(rawVals, 0);

        assertTrue("Left col is empty\n" + b,
                Model.emptySpaceExists(b));
    }

    @Test
    /** 测试一个除了右列以外完全填满的棋盘。 */
    public void testEmptyRightCol() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 0},
                {4, 2, 4, 0},
                {2, 4, 2, 0},
                {4, 2, 4, 0},
        };

        b = new Board(rawVals, 0);

        assertTrue("Right col is empty\n" + b,
                Model.emptySpaceExists(b));
    }

    @Test
    /** 测试一个除了一个方块以外完全填满的棋盘。 */
    public void testAlmostFullBoard() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 0, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals, 0);

        assertTrue("Board is not full\n" + b,
                Model.emptySpaceExists(b));
    }

    @Test
    /** 测试一个完全填满的棋盘。
     * 由于你可以合并，游戏尚未结束，但 emptySpaceExists 方法
     * 应只查找空格子（而不查找相邻的值）。 */
    public void testFullBoard() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        b = new Board(rawVals, 0);

        assertFalse("Board is full\n" + b, Model.emptySpaceExists(b));
    }

    @Test
    /** 测试一个完全填满的棋盘。 */
    public void testFullBoardNoMerge() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals, 0);

        assertFalse("Board is full\n" + b, Model.emptySpaceExists(b));
    }
}
