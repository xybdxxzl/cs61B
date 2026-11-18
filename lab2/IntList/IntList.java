package IntList;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** 使用……递归！返回列表的大小 */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** 不使用递归返回列表的大小！ */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** 返回此 IntList 的第 i 个元素。 */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /** 返回 IntList 字符串表示形式的方法 */
    public String toString() {
        if (rest == null) {
            // 将 Integer 转换为 String！
            return String.valueOf(first);
        } else {
            return first + " -> " + rest.toString();
        }
    }

    /**
     * 根据参数列表创建 IntList 的方法。
     * 你不需要理解这段代码。我们把它放在这里
     * 是因为它便于测试。它的用法如下：
     *
     * IntList myList = IntList.of(1, 2, 3, 4, 5);
     * 将创建一个 IntList 1 -> 2 -> 3 -> 4 -> 5 -> null。
     *
     * 你可以向 IntList.of 传入任意数量的参数，它都能正常工作：
     * IntList mySmallerList = IntList.of(1, 4, 9);
     */
    public static IntList of(int ...argList) {
        if (argList.length == 0)
            return null;
        int[] restList = new int[argList.length - 1];
        System.arraycopy(argList, 1, restList, 0, argList.length - 1);
        return new IntList(argList[0], IntList.of(restList));
    }
}
