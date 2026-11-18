package game2048;
import org.junit.Test;

import static org.junit.Assert.*;

/** 测试 Model 的 atLeastOneMoveExists() 静态方法。
 *
 * 在你通过 TestEmptySpace 中的所有测试之前，
 * 你不要指望通过这些测试。
 *
 * @author Omar Khan
 */
public class TestAtLeastOneMoveExists {

    /** 我们将要在其上进行测试的 Board。 */
    static Board b;

    @Test
    /** 测试一个存在一些空格子的棋盘。
     *
     *  注意，这并不是对空格子的全面测试。若要全面测试，
     * 请参见 TestEmptySpace 类。 */
    public void testEmptySpace() {
        int[][] rawVals = new int[][] {
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals, 0);
        assertTrue("A tilt in any direction will change the board "
                        + "(there is empty space on the board)\n" + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个朝任意方向倾斜都会导致变化的棋盘。 */
    public void testAnyDir() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 2},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals, 0);
        assertTrue("A tilt in any direction will change the board\n"
                        + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个朝左或朝右倾斜都会导致变化的棋盘。 */
    public void testLeftOrRight() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 8, 4, 2},
                {2, 2, 2, 4},
                {4, 8, 4, 2},
        };

        b = new Board(rawVals, 0);
        assertTrue("A tilt left or right will change the board\n" + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个朝上或朝下倾斜都会导致变化的棋盘。 */
    public void testUpOrDown() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 8, 4, 2},
                {2, 16, 4, 8},
                {4, 8, 4, 2},
        };

        b = new Board(rawVals, 0);
        assertTrue("A tilt up or down will change the board\n" + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个存在某种可移动空间的棋盘（棋盘上有最大方块）。
     *
     * 虽然棋盘上出现最大方块确实意味着游戏结束，但
     * 不应在此方法中处理该情况。 */
    public void testMoveExistsMaxPiece() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 2, 2, 4},
                {4, 2, 4, 2048},
        };

        b = new Board(rawVals, 0);
        assertTrue("A tilt in any direction will change the board\n"
                        + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个不存在任何可移动空间的棋盘。 */
    public void testNoMoveExists1() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals, 0);
        assertFalse("No move exists\n" + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个不存在任何可移动空间的棋盘。 */
    public void testNoMoveExists2() {
        int[][] rawVals = new int[][] {
                {2, 1024, 2, 4},
                {4, 2, 4, 2},
                {2, 8, 16, 4},
                {512, 2, 4, 2},
        };

        b = new Board(rawVals, 0);
        assertFalse("No move exists\n" + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个不存在任何可移动空间的棋盘。 */
    public void testNoMoveExists3() {
        int[][] rawVals = new int[][] {
                {8, 4, 2, 32},
                {32, 2, 4, 2},
                {2, 8, 2, 4},
                {4, 64, 4, 64},
        };

        b = new Board(rawVals, 0);
        assertFalse("No move exists\n" + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个不存在任何可移动空间的棋盘。 */
    public void testNoMoveExists4() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 32},
                {32, 2, 4, 2},
                {2, 128, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals, 0);
        assertFalse("No move exists\n" + b,
                Model.atLeastOneMoveExists(b));
    }

    @Test
    /** 测试一个不存在任何可移动空间的棋盘。 */
    public void testNoMoveExists5() {
        int[][] rawVals = new int[][] {
                {8, 16, 2, 32},
                {32, 2, 64, 2},
                {2, 256, 128, 256},
                {1024, 8, 4, 2},
        };

        b = new Board(rawVals, 0);
        assertFalse("No move exists\n" + b,
                Model.atLeastOneMoveExists(b));
    }
}
