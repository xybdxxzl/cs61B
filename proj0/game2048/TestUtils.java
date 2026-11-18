package game2048;

import static org.junit.Assert.*;

public class TestUtils {

    /** 我们将要测试的 Model。 */
    static Model model;
    /** 这些测试中 Board 的大小。 */
    public static final int SIZE = 4;

    /** 用于生成错误消息的实用方法。 */
    public static String boardShouldChange(Side side) {
        return "When tilted to the " + side + ", the model should change, but"
                + " the call to tilt returned false.\nModel after call:" + model;
    }

    /** 用于生成错误消息的实用方法。 */
    public static String boardShouldNotChange(Side side) {
        return "When tilted to the " + side + ", the model should NOT change,"
                + " but the call to tilt returned true.\nModel after call:"
                + model;
    }

    /**
     * 将静态变量 model 更新为 board 属性如 VALUES
     * 所描述的 Model。
     */
    public static void updateModel(int[][] values, int score, int maxScore,
                                   boolean gameOver) {
        assert values.length == SIZE : "board must have 4x4 dimensions";
        assert values[0].length == SIZE : "board must have 4x4 dimensions";
        model = new Model(values, score, maxScore, gameOver);
    }

    /**
     * 检查静态变量 model 是否如 VALUES 所描述、且具有
     * score 属性 SCORE 那样配置。
     *  @param values - 描述预期棋盘的整数二维数组，"0"
     *               元素表示 null Tile。
     * @param score - model 应具有的分数。
     * @param maxScore 最高分
     * @param prevBoard - 在此次移动之前棋盘的样子。
     * @param currMove - 我们倾斜朝向的 Side。
     */
    public static void checkModel(int[][] values, int score, int maxScore,
                                  String prevBoard, Side currMove) {

        Model expected = new Model(values, score, maxScore, false);
        String errMsg = String.format("Board incorrect. Before tilting towards"
                        + " %s, your board looked like:%s%nAfter the call to"
                        + " tilt, we expected:%s%nBut your board looks like:%s.",
                currMove, prevBoard, expected.toString(), model.toString());
        assertEquals(errMsg, expected, model);
    }

    /**
     * 检查调用 tilt 方法返回的布尔值是否正确。
     *
     * @param s - 被倾斜的朝向（即传给 tilt 的参数）。
     * @param expected - 预期的返回值。
     * @param actual - 实际的返回值。
     */
    public static void checkChanged(Side s, boolean expected, boolean actual) {
        String changedErrMsg;
        if (expected) {
            changedErrMsg = boardShouldChange(s);
            assertTrue(changedErrMsg, actual);
        } else {
            changedErrMsg = boardShouldNotChange(s);
            assertFalse(changedErrMsg, actual);
        }
    }
}
