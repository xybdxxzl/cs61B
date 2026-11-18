package student;

/**
 * 由 hug 于 2017 年 2 月 4 日创建。
 * 于 2019 年 2 月 3 日添加了 isEmpty() 默认实现。
 */
public interface Deque<Item> {
    void addFirst(Item x);
    void addLast(Item x);

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
}