package hashmap;

import java.util.Collection;

/**
 *  一个由哈希表（hash table）支持的 Map 实现。在最佳情况下，
 *  通过 get()、remove() 和 put() 提供均摊常数时间
 *  的元素访问。
 *
 *  假定永远不会插入 null 键，并且在 remove() 时不会缩容。
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * 用于存储键值对的 protected 辅助类
     * protected 限定符允许子类访问
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* 实例变量 */
    private Collection<Node>[] buckets;
    // 你大概还应该再定义一些别的！

    /** 构造器 */
    public MyHashMap() { }

    public MyHashMap(int initialSize) { }

    /**
     * MyHashMap 构造器，创建一个大小为 initialSize 的底层数组。
     * 负载因子（# 元素 / # 桶）应始终 <= loadFactor
     *
     * @param initialSize 底层数组的初始大小
     * @param maxLoad 最大负载因子
     */
    public MyHashMap(int initialSize, double maxLoad) { }

    /**
     * 返回一个将要放入哈希表桶中的新节点
     */
    private Node createNode(K key, V value) {
        return null;
    }

    /**
     * 返回一个将作为哈希表桶的数据结构
     *
     * 哈希表桶的唯一要求是我们可以：
     *  1. 插入元素（`add` 方法）
     *  2. 删除元素（`remove` 方法）
     *  3. 遍历元素（`iterator` 方法）
     *
     * 这些方法都由 java.util.Collection 支持，
     * Java 中大多数数据结构都继承自 Collection，因此我们
     * 几乎可以用任何数据结构来作为桶。
     *
     * 重写此方法即可使用不同的数据结构作为
     * 底层桶类型
     *
     * 务必调用这个工厂方法，而不要用 NEW 运算符
     * 创建你自己的桶数据结构！
     */
    protected Collection<Node> createBucket() {
        return null;
    }

    /**
     * 返回一个用于支撑哈希表的表。根据上面的注释，
     * 该表可以是一个 Collection 对象的数组
     *
     * 创建表时务必调用这个工厂方法，
     * 以确保所有桶类型都是 JAVA.UTIL.COLLECTION
     *
     * @param tableSize 要创建的表的大小
     */
    private Collection<Node>[] createTable(int tableSize) {
        return null;
    }

    // TODO: 在下面实现 Map61B 接口的方法
    // 在你实现之前，代码无法通过编译！

}
