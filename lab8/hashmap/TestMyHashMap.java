package hashmap;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 由 Brendan Hu 于 2015 年春季编写的测试
 * 2016 年由 Josh Hug 修订
 * 2021 年由 Neil Kulkarni 修订
 */
public class TestMyHashMap {

    @Test
    public void sanityGenericsTest() {
        MyHashMap<String, String> a = new MyHashMap<>();
        MyHashMap<String, Integer> b = new MyHashMap<>();
        MyHashMap<Integer, String> c = new MyHashMap<>();
        MyHashMap<Boolean, Integer> d = new MyHashMap<>();
    }

    //假定 put/size/containsKey/get 正常工作
    @Test
    public void sanityClearTest() {
        sanityClearTest(new MyHashMap<>());
    }

    public static void sanityClearTest(MyHashMap<String, Integer> b) {
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
            //通过 containsKey 和 get 确保 put 正常工作
            assertTrue(null != b.get("hi" + i)
                    && b.containsKey("hi" + i));
        }
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // 假定 put 正常工作
    @Test
    public void sanityContainsKeyTest() {
        sanityContainsKeyTest(new MyHashMap<>());
    }

    public static void sanityContainsKeyTest(MyHashMap<String, Integer> b) {
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // 假定 put 正常工作
    @Test
    public void sanityGetTest() {
        sanityGetTest(new MyHashMap<>());
    }

    public static void sanityGetTest(MyHashMap<String, Integer> b) {
        assertEquals(null, b.get("starChild"));
        b.put("starChild", 5);
        assertNotEquals(null, b.get("starChild"));
        b.put("KISS", 5);
        assertNotEquals(null, b.get("KISS"));
        assertNotEquals(null, b.get("starChild"));
    }

    // 假定 put 正常工作
    @Test
    public void sanitySizeTest() {
        sanitySizeTest(new MyHashMap<>());
    }

    public static void sanitySizeTest(MyHashMap<String, Integer> b) {
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertEquals(456, b.size());
    }

    //假定 get/containskey 正常工作
    @Test
    public void sanityPutTest() {
        sanityPutTest(new MyHashMap<>());
    }

    public static void sanityPutTest(MyHashMap<String, Integer> b) {
        b.put("hi", 1);
        assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }

    @Test
    public void sanityKeySetTest() {
        sanityKeySetTest(new MyHashMap<>());
    }

    public static void sanityKeySetTest(MyHashMap<String, Integer> b) {
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

    // 测试一般功能以及 Map 的各项性质是否成立。
    @Test
    public void functionalityTest() {
        functionalityTest(new MyHashMap<>(), new MyHashMap<>());
    }

    public static void functionalityTest(MyHashMap<String, String> dictionary,
                                   MyHashMap<String, Integer> studentIDs) {
        assertEquals(0, dictionary.size());

        // 可以将对象放入 dictionary 并取出
        dictionary.put("hello", "world");
        assertTrue(dictionary.containsKey("hello"));
        assertEquals("world", dictionary.get("hello"));
        assertEquals(1, dictionary.size());

        // 用已存在的键放入会更新该值
        dictionary.put("hello", "kevin");
        assertEquals(1, dictionary.size());
        assertEquals("kevin", dictionary.get("hello"));

        // 多次放入同一个键不会影响行为
        studentIDs.put("sarah", 12345);
        assertEquals(1, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        assertTrue(studentIDs.containsKey("sarah"));
        assertTrue(studentIDs.containsKey("alan"));

        // 处理值相同的情况
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("evil alan", 345);
        assertEquals(345, studentIDs.get("evil alan").intValue());
        assertEquals(studentIDs.get("evil alan"), studentIDs.get("alan"));
    }
}
