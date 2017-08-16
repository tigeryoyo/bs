package 牛客616;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * @author Chan
 *
 */
public class Main56___ {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode p1 = pHead;
		ListNode p2 = pHead;
		int p1c = 0;
		int p2c = 0;
		do {
			p1 = p1.next;
			if (p1 == null) {
				return null;
			}
			p2 = p2.next;
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
			if (p2 == null) {
				return null;
			}
			p1c += 1;
			p2c += 2;
		} while (p1 != p2);

		p1 = pHead;
		p2 = pHead;
		int c = p2c - p1c;
		while (c-- != 0) {
			p2 = p2.next;
		}

		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		if (pHead.next == null) {
			return pHead;
		}
		ListNode curHead = null;
		if (pHead.val == pHead.next.val) {
			curHead = pHead.next.next;
			while (curHead != null && curHead.val == pHead.val) {
				curHead = curHead.next;
			}
			return deleteDuplication(curHead);
		} else {
			curHead = pHead.next;
			pHead.next = deleteDuplication(curHead);
			return pHead;
		}
	}

}
