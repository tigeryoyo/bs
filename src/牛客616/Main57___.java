package 牛客616;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 * 
 * @author Chan
 *
 */
public class Main57___ {
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

	public ListNode deleteDuplication1(ListNode pHead) {
		ListNode g_head = new ListNode(-1);
		g_head.next = pHead;
		ListNode last = g_head;
		ListNode p = pHead;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				int val = p.val;
				while (p != null && p.val == val) {
					p = p.next;
				}
				last.next = p;
			} else {
				last = p;
				p = p.next;
			}
		}
		return g_head.next;
	}
}
