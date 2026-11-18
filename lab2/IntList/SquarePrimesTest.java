package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * 这里有一个针对 isPrime 方法的测试。试着运行它。
     * 它能通过，但起始代码中 isPrime 的实现
     * 是有问题的。请编写你自己的 JUnit 测试来尝试找出这个 bug！
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }
}
