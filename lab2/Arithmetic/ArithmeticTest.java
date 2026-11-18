package Arithmetic;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArithmeticTest {

    /** 执行若干任意测试，以检查 product 方法是否正确 */
    @Test
    public void testProduct() {
        /* 用于比较 int 的 assertEquals 接收两个参数：
        assertEquals(expected, actual)。
        如果结果为 false，则断言为 false，
        该测试将会失败。
        */

        assertEquals(30, Arithmetic.product(5, 6));
        assertEquals(-30, Arithmetic.product(5, -6));
        assertEquals(0, Arithmetic.product(0, -6));
    }

    /** 执行若干任意测试，以检查 sum 方法是否正确 */
    @Test
    public void testSum() {

        assertEquals(11, Arithmetic.sum(5, 6));
        assertEquals(-1, Arithmetic.sum(5, -6));
        assertEquals(-6, Arithmetic.sum(0, -6));
        assertEquals(0, Arithmetic.sum(6, -6));
    }
}
