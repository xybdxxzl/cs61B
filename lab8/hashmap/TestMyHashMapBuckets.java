package hashmap;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 由 Brendan Hu 于 2015 年春季编写的测试
 * 2016 年由 Josh Hug 修订
 * 2021 年由 Neil Kulkarni 修订
 */
public class TestMyHashMapBuckets {

    @Test
    public void sanityGenericsTest() {
        MyHashMap<String, Integer> a = new MyHashMapALBuckets<>();
        MyHashMap<String, Integer> b = new MyHashMapALBuckets<>();
        MyHashMap<Integer, String> c = new MyHashMapALBuckets<>();
        MyHashMap<Boolean, Integer> d = new MyHashMapALBuckets<>();

        a = new MyHashMapLLBuckets<>();
        b = new MyHashMapLLBuckets<>();
        c = new MyHashMapLLBuckets<>();
        d = new MyHashMapLLBuckets<>();

        a = new MyHashMapTSBuckets<>();
        b = new MyHashMapTSBuckets<>();
        c = new MyHashMapTSBuckets<>();
        d = new MyHashMapTSBuckets<>();

        a = new MyHashMapHSBuckets<>();
        b = new MyHashMapHSBuckets<>();
        c = new MyHashMapHSBuckets<>();
        d = new MyHashMapHSBuckets<>();

        a = new MyHashMapPQBuckets<>();
        b = new MyHashMapPQBuckets<>();
        c = new MyHashMapPQBuckets<>();
        d = new MyHashMapPQBuckets<>();
    }

    //假定 put/size/containsKey/get 正常工作
    @Test
    public void sanityClearTest() {
        TestMyHashMap.sanityClearTest(new MyHashMapALBuckets<>());
        TestMyHashMap.sanityClearTest(new MyHashMapLLBuckets<>());
        TestMyHashMap.sanityClearTest(new MyHashMapTSBuckets<>());
        TestMyHashMap.sanityClearTest(new MyHashMapHSBuckets<>());
        TestMyHashMap.sanityClearTest(new MyHashMapPQBuckets<>());
    }

    // 假定 put 正常工作
    @Test
    public void sanityContainsKeyTest() {
        TestMyHashMap.sanityContainsKeyTest(new MyHashMapALBuckets<>());
        TestMyHashMap.sanityContainsKeyTest(new MyHashMapLLBuckets<>());
        TestMyHashMap.sanityContainsKeyTest(new MyHashMapTSBuckets<>());
        TestMyHashMap.sanityContainsKeyTest(new MyHashMapHSBuckets<>());
        TestMyHashMap.sanityContainsKeyTest(new MyHashMapPQBuckets<>());
    }

    // 假定 put 正常工作
    @Test
    public void sanityGetTest() {
        TestMyHashMap.sanityGetTest(new MyHashMapALBuckets<>());
        TestMyHashMap.sanityGetTest(new MyHashMapLLBuckets<>());
        TestMyHashMap.sanityGetTest(new MyHashMapTSBuckets<>());
        TestMyHashMap.sanityGetTest(new MyHashMapHSBuckets<>());
        TestMyHashMap.sanityGetTest(new MyHashMapPQBuckets<>());
    }

    // 假定 put 正常工作
    @Test
    public void sanitySizeTest() {
        TestMyHashMap.sanitySizeTest(new MyHashMapALBuckets<>());
        TestMyHashMap.sanitySizeTest(new MyHashMapLLBuckets<>());
        TestMyHashMap.sanitySizeTest(new MyHashMapTSBuckets<>());
        TestMyHashMap.sanitySizeTest(new MyHashMapHSBuckets<>());
        TestMyHashMap.sanitySizeTest(new MyHashMapPQBuckets<>());
    }

    //假定 get/containskey 正常工作
    @Test
    public void sanityPutTest() {
        TestMyHashMap.sanityPutTest(new MyHashMapALBuckets<>());
        TestMyHashMap.sanityPutTest(new MyHashMapLLBuckets<>());
        TestMyHashMap.sanityPutTest(new MyHashMapTSBuckets<>());
        TestMyHashMap.sanityPutTest(new MyHashMapHSBuckets<>());
        TestMyHashMap.sanityPutTest(new MyHashMapPQBuckets<>());
    }

    @Test
    public void sanityKeySetTest() {
        TestMyHashMap.sanityKeySetTest(new MyHashMapALBuckets<>());
        TestMyHashMap.sanityKeySetTest(new MyHashMapLLBuckets<>());
        TestMyHashMap.sanityKeySetTest(new MyHashMapTSBuckets<>());
        TestMyHashMap.sanityKeySetTest(new MyHashMapHSBuckets<>());
        TestMyHashMap.sanityKeySetTest(new MyHashMapPQBuckets<>());
    }

    // 测试一般功能以及 Map 的各项性质是否成立。
    @Test
    public void functionalityTest() {
        TestMyHashMap.functionalityTest(new MyHashMapALBuckets<>(), new MyHashMapALBuckets<>());
        TestMyHashMap.functionalityTest(new MyHashMapLLBuckets<>(), new MyHashMapLLBuckets<>());
        TestMyHashMap.functionalityTest(new MyHashMapTSBuckets<>(), new MyHashMapTSBuckets<>());
        TestMyHashMap.functionalityTest(new MyHashMapHSBuckets<>(), new MyHashMapHSBuckets<>());
        TestMyHashMap.functionalityTest(new MyHashMapPQBuckets<>(), new MyHashMapPQBuckets<>());
    }
}
