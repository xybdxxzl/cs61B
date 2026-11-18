package hashmap;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 使用 Array List（数组列表）作为桶的哈希表
 * @author Neil Kulkarni
 */
public class MyHashMapALBuckets<K, V> extends MyHashMap<K, V> {

    /**
     * 构造器，创建一个使用默认初始大小
     * 和负载因子的底层数组
     */
    public MyHashMapALBuckets() {
        super();
    }

    /**
     * 构造器，创建一个大小为 initialSize
     * 并使用默认负载因子的底层数组
     *
     * @param initialSize 底层数组的初始大小
     */
    public MyHashMapALBuckets(int initialSize) {
        super(initialSize);
    }

    /**
     * 构造器，创建一个大小为 initialSize 的底层数组。
     * 负载因子（# 元素 / # 桶）应始终 <= loadFactor
     *
     * @param initialSize 底层数组的初始大小
     * @param maxLoad 最大负载因子
     */
    public MyHashMapALBuckets(int initialSize, double maxLoad) {
        super(initialSize, maxLoad);
    }

    @Override
    protected Collection<Node> createBucket() {
        return new ArrayList<>();
    }
}
