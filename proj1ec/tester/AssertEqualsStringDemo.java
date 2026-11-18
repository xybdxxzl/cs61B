package tester;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.introcs.StdRandom;
/** 演示带 String 消息的 assertEquals 版本。 */
public class AssertEqualsStringDemo {
    @Test
    public void test1() {
        int expected = 20;
        int actual = StdRandom.uniform(4);
        assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual 
                     + " not equal to " + expected + "!", 
                     expected, actual);
    }

    /** 这个 main 方法是可选的。 */
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(AssertEqualsStringDemo.class);
    }
} 
