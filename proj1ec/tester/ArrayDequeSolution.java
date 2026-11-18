package tester;

import java.util.LinkedList;

/**
 * 这个解法是不是有点……作弊？是的。
 * 尤其会让有审美洁癖的人震惊的是：这个本该是
 * ArrayDeque 的东西实际上用的是 LinkedList。可悲！（SAD!）
 */
public class ArrayDequeSolution<Item> extends LinkedList<Item> {
    public void printDeque() {
        System.out.println("dummy");
    }

    public Item getRecursive(int i) {
        return get(i);
    }

    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
