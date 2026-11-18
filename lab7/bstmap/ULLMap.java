package bstmap;

import java.util.Iterator;
import java.util.Set;

/** 一种使用链表来存储键值对的数据结构。
 *  任何键至多只能出现一次，但值可以出现多次。
 *  关键操作有 get(key)、put(key, value) 和 contains(key) 方法。与某个键
 *  关联的值是最近一次使用该键调用 put 时的值。 */
public class ULLMap<K, V>  implements Map61B<K, V> {

    int size = 0;

    /** 返回与 KEY 对应的值，如果不存在这样的值则返回 null。 */
    public V get(K key) {
        if (list == null) {
            return null;
        }
        Entry lookup = list.get(key);
        if (lookup == null) {
            return null;
        }
        return lookup.val;
    }

    @Override
    public int size() {
        return size;
    }

    /** 从此映射中移除所有映射关系。 */
    @Override
    public void clear() {
        size = 0;
        list = null;
    }

    /** 将 KEY 和 VALUE 的键值对插入此字典，
     *  若存在则替换与 KEY 关联的先前值。 */
    public void put(K key, V val) {
        if (list != null) {
            Entry lookup = list.get(key);
            if (lookup == null) {
                list = new Entry(key, val, list);
            } else {
                lookup.val = val;
            }
        } else {
            list = new Entry(key, val, list);
            size = size + 1;
        }
    }

    /** 当且仅当此字典包含某个键值对以 KEY 作为键时
     *  返回 true。 */
    public boolean containsKey(K key) {
        if (list == null) {
            return false;
        }
        return list.get(key) != null;
    }

    @Override
    public Iterator<K> iterator() {
        return new ULLMapIter();
    }

    /** 键和值存储在由 Entry 对象构成的链表中。
     *  此变量存储该链表中的第一对。 */
    private Entry list;

    /** 表示存储字典中键值对的链表中的一个节点。 */
    private class Entry {

        /** 将 KEY 存储为此键值对的键，VAL 存储为值，NEXT
         *  存储为链表中的下一个节点。 */
        Entry(K k, V v, Entry n) {
            key = k;
            val = v;
            next = n;
        }

        /** 返回此键值对链表中键等于 KEY 的 Entry，
         *  如果不存在这样的 Entry 则返回 null。 */
        Entry get(K k) {
            if (k != null && k.equals(key)) {
                return this;
            }
            if (next == null) {
                return null;
            }
            return next.get(key);
        }

        /** 存储链表中此节点的键值对的键。 */
        K key;
        /** 存储链表中此节点的键值对的值。 */
        V val;
        /** 存储链表中的下一个 Entry。 */
        Entry next;

    }

    /** 一个遍历字典中所有键的迭代器。 */
    private class ULLMapIter implements Iterator<K> {

        /** 通过将 cur 设为存储键值对的链表中的第一个节点，
         *  创建一个新的 ULLMapIter。 */
        public ULLMapIter() {
            cur = list;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public K next() {
            K ret = cur.key;
            cur = cur.next;
            return ret;
        }

        /** 存储当前的键值对。 */
        private Entry cur;

    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

}
