package timingtest;

/** SLList 是一个整数列表，它隐藏了内部赤裸裸的
 * 糟糕真相。 */
public class SLList<Item> {
	private class IntNode {
		public Item item;
		public IntNode next;

		public IntNode(Item i, IntNode n) {
			item = i;
			next = n;
		}
	}

	/* 第一个元素（如果存在）位于 sentinel.next。 */
	private IntNode sentinel;
	private int size;

	/** 创建一个空的 timingtest.SLList。 */
	public SLList() {
		sentinel = new IntNode(null, null);
		size = 0;
	}

	public SLList(Item x) {
		sentinel = new IntNode(null, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/** 将 x 添加到列表的前端。 */
	public void addFirst(Item x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size = size + 1;
	}

	/** 返回列表中的第一个元素。 */
	public Item getFirst() {
		return sentinel.next.item;
	}

	/** 将 x 添加到列表的末尾。 */
	public void addLast(Item x) {
		size = size + 1;

		IntNode p = sentinel;

		/* 将 p 前进到列表的末尾。 */
		while (p.next != null) {
			p = p.next;
		}

		p.next = new IntNode(x, null);
	}

	/** 返回列表中的最后一个元素 */
	public Item getLast() {
		IntNode p = sentinel;

		/* 将 p 前进到列表的末尾。 */
		while (p.next != null) {
			p = p.next;
		}

		return p.item;
	}


	/** 返回列表的大小。 */
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		/* 创建一个只含一个整数的列表，即 10 */
		SLList L = new SLList();
		L.addLast(20);
		System.out.println(L.size());
	}
}
