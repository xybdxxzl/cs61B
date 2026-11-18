package randomizedtest;

/** 基于数组的列表。
 *  @author Josh Hug
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* 不变量（Invariants）：
 addLast：我们下一步想要添加的元素，将放入位置 size
 getLast：我们想要返回的元素位于位置 size - 1
 size：列表中元素的数目应为 size。
*/

public class BuggyAList<Item> {
    private Item[] items;
    private int size;

    /** 创建一个空列表。 */
    public BuggyAList() {
        items = (Item[]) new Object[1];
        size = 0;
    }

    /** 将底层数组调整为目标容量。 */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            a[i] = items[i];
        }
        items = a;
    }

    /** 将 X 插入到列表的末尾。 */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size = size + 1;
    }

    /** 返回列表末尾的元素。 */
    public Item getLast() {
        return items[size - 1];
    }
    /** 获取列表中的第 i 个元素（0 表示前端）。 */
    public Item get(int i) {
        return items[i];
    }

    /** 返回列表中元素的个数。 */
    public int size() {
        return size;
    }

    /** 删除列表末尾的元素，
      * 并返回被删除的元素。 */
    public Item removeLast() {
        if ((size < items.length / 4) && (size > 4)) {
            resize(size / 4);
        }
        Item x = getLast();
        items[size - 1] = null;
        size = size - 1;
        return x;
    }
}
