package bstmap;

import java.util.Set;
import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Test;

/** lab 7 可选部分的测试。 */
public class TestBSTMapExtra {

    /*
    * keySet 的健全性（sanity）测试，放在这里只是因为它属于可选内容
    */
    @Test
    public void sanityKeySetTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        HashSet<String> values = new HashSet<String>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
            values.add("hi" + i);
        }
        assertEquals(455, b.size()); //键都在
        Set<String> keySet = b.keySet();
        assertTrue(values.containsAll(keySet));
        assertTrue(keySet.containsAll(values));
    }

    /* 移除测试
     *
     * 关于 testRemoveRoot 的说明：
     *
     * 仅仅检查 c 已被移除（也许并不严谨）
     * 就假定了 remove 会保持 BST 结构。
     *
     * 本可以编写更详尽的测试来验证
     * remove 的实现，但那需要做
     * 诸如检查中序与先序交换之类的
     * 事情，在这个简单的 BST 实现中是不必要的。
     */
    @Test
    public void testRemoveRoot() {
        BSTMap<String,String> q = new BSTMap<String,String>();
        q.put("c","a");
        q.put("b","a");
        q.put("a","a");
        q.put("d","a");
        q.put("e","a"); // 中序：a b c d e
        assertTrue(null != q.remove("c"));
        assertFalse(q.containsKey("c"));
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        assertTrue(q.containsKey("e"));
    }

    /* 移除测试 2
     * 测试 remove 的 3 种不同情况
     */
    @Test
    public void testRemoveThreeCases() {
        BSTMap<String,String> q = new BSTMap<String,String>();
        q.put("c","a");
        q.put("b","a");
        q.put("a","a");
        q.put("d","a");
        q.put("e","a");                         // 中序：a b c d e
        assertTrue(null != q.remove("e"));      // 中序：a b c d
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("c"));
        assertTrue(q.containsKey("d"));
        assertTrue(null != q.remove("c"));      // 中序：a b d
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        q.put("f","a");                         // 中序：a b d f
        assertTrue(null != q.remove("d"));      // 中序：a b f
        assertTrue(q.containsKey("a"));
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("f"));
    }

    /* 移除测试 3
    *  检查当根节点两侧只有 1 个或 0 个子节点时，
    *  remove 是否能在根节点上正确工作。 */
    @Test
    public void testRemoveRootEdge() {
        BSTMap rightChild = new BSTMap();
        rightChild.put('A', 1);
        rightChild.put('B', 2);
        Integer result = (Integer) rightChild.remove('A');
        assertTrue(result.equals(new Integer(1)));
        for (int i = 0; i < 10; i++) {
            rightChild.put((char) ('C'+i), 3+i);
        }
        rightChild.put('A', 100);
        assertTrue(((Integer) rightChild.remove('D')).equals(new Integer(4)));
        assertTrue(((Integer) rightChild.remove('G')).equals(new Integer(7)));
        assertTrue(((Integer) rightChild.remove('A')).equals(new Integer(100)));
        assertTrue(rightChild.size()==9);

        BSTMap leftChild = new BSTMap();
        leftChild.put('B', 1);
        leftChild.put('A', 2);
        assertTrue(((Integer) leftChild.remove('B')).equals(1));
        assertEquals(1, leftChild.size());
        assertEquals(null, leftChild.get('B'));

        BSTMap noChild = new BSTMap();
        noChild.put('Z', 15);
        assertTrue(((Integer) noChild.remove('Z')).equals(15));
        assertEquals(0, noChild.size());
        assertEquals(null, noChild.get('Z'));
    }

}
