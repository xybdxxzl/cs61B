package hashmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 使用 Priority Queue（优先队列）作为桶的哈希表
 * 优先队列的元素需要可比较，因此我们将映射限制为
 * 只允许可比较的键
 *
 * @author Neil Kulkarni
 */
public class MyHashMapPQBuckets<K extends Comparable<K>, V> extends MyHashMap<K, V> {

    /**
     * 构造器，创建一个使用默认初始大小
     * 和负载因子的底层数组
     */
    public MyHashMapPQBuckets() {
        super();
    }

    /**
     * 构造器，创建一个大小为 initialSize
     * 并使用默认负载因子的底层数组
     *
     * @param initialSize 底层数组的初始大小
     */
    public MyHashMapPQBuckets(int initialSize) {
        super(initialSize);
    }

    /**
     * 构造器，创建一个大小为 initialSize 的底层数组。
     * 负载因子（# 元素 / # 桶）应始终 <= loadFactor
     *
     * @param initialSize 底层数组的初始大小
     * @param maxLoad 最大负载因子
     */
    public MyHashMapPQBuckets(int initialSize, double maxLoad) {
        super(initialSize, maxLoad);
    }

    @Override
    protected Collection<Node> createBucket() {
        // 这是花哨的新式 Java，用大白话说就是：
        //
        //  "构建一个 Node 的 PriorityQueue，当你比较两个 Node 时，
        //   通过它们键的 compareTo 方法比较它们的键"
        //
        // 记住，我们在类声明处有 K extends Comparable<K>，
        // 因此我们知道这些键已经实现了 compareTo 方法
        return new PriorityQueue<>(Comparator.comparing(a -> a.key));
    }
}
