package hashmap;

import java.util.Set;
/**
 * 你的 hashmap.MyHashMap 实现应实现此接口。为此，
 * 在你的 "public class..." 声明末尾追加 "implements hashmap.Map61B<K, V>"，
 * 当然如果你想的话，也可以使用其他形式类型参数。
 */
public interface Map61B<K, V> extends Iterable<K> {
    /** 从此映射中移除所有映射关系。 */
    void clear();

    /** 如果此映射包含指定键的映射关系，则返回 true。 */
    boolean containsKey(K key);

    /**
     * 返回指定键所映射到的值；如果此映射不包含
     * 该键的映射关系，则返回 null。
     */
    V get(K key);

    /** 返回此映射中的键值映射关系数。 */
    int size();

    /**
     * 将指定的值与此映射中的指定键关联。
     * 如果此映射先前已包含该键的映射关系，
     * 则替换旧值。
     */
    void put(K key, V value);

    /** 返回此映射中所包含键的 Set 视图。 */
    Set<K> keySet();

    /**
     * 如果存在指定键的映射关系，则将其从此映射中移除。
     * Lab 8 不要求实现。如果你不实现它，请抛出
     * UnsupportedOperationException。
     */
    V remove(K key);

    /**
     * 仅当指定键当前映射到指定值时，才移除该键的条目。
     * Lab 8 不要求实现。如果你不实现它，
     * 请抛出 UnsupportedOperationException。
     */
    V remove(K key, V value);
}

