package hashmap;

import static org.junit.Assert.*;
import org.junit.Test;

/** lab 8 可选部分的测试。 */
public class TestMyHashMapExtra {

    @Test
    public void testRemove() {
        MyHashMap<String, String> q = new MyHashMap<>();
        q.put("c", "a");
        q.put("b", "a");
        q.put("a", "a");
        q.put("d", "a");
        q.put("e", "a"); // 中序：a b c d e
        assertTrue(null != q.remove("c"));
        assertFalse(q.containsKey("c"));
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        assertTrue(q.containsKey("e"));
    }

    /** 
     * 移除测试 2
     * 测试 remove 的 3 种不同情况
     */
    @Test
    public void testRemoveThreeCases() {
        MyHashMap<String, String> q = new MyHashMap<>();
        q.put("c", "a");
        q.put("b", "a");
        q.put("a", "a");
        q.put("d", "a");
        q.put("e", "a");                         // 中序：a b c d e
        assertTrue(null != q.remove("e"));      // 中序：a b c d
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("c"));
        assertTrue(q.containsKey("d"));
        assertTrue(null != q.remove("c"));      // 中序：a b d
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        q.put("f", "a");                         // 中序：a b d f
        assertTrue(null != q.remove("d"));      // 中序：a b f
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("f"));
    }
}
