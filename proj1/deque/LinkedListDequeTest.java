package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** 向列表中添加一些东西，检查 isEmpty() 和 size() 是否正确，
     * 最后打印结果。
     *
     * && 是"与（and）"运算。 */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        /*
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// && 运算符与 Python 中的 "and" 相同。
		// 它是一个二元运算符，当两个参数都为 true 时返回 true，否则返回 false。
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
		*/
    }

    @Test
    /** 添加一个元素，然后移除一个元素，并确保之后 deque 为空。 */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        /*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// 应该为空
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// 不应该为空
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// 应该为空
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
        */
    }

    @Test
    /* 测试从空 deque 中移除元素 */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        /*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
        */
    }

    @Test
    /* 检查你能否创建具有不同参数化类型的 LinkedListDeque */
    public void multipleParamTest() {

        /*
        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
        */
    }

    @Test
    /* 检查从空 LinkedListDeque 中移除时是否返回 null。 */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        /*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

        */
    }

    @Test
    /* 向 deque 中添加大量元素；检查顺序是否正确。 */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        /*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

        */
    }
}
