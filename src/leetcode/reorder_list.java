package leetcode;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n, reorder it to: L 0→L n →L
 * 1→L n-1→L 2→L n-2→… You must do this in-place without altering the nodes'
 * values. For example, Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * 
 */

// 快慢指针找到中间节点，将后面的链表反转（前插法），合并链表
// 另：题目要求是就地解决，应该是不能用辅助栈之类的吧
public class reorder_list {
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode pre = slow.next;
		if (pre != null && pre.next != null) {
			ListNode nex = pre.next;
			while (nex != null) {
				pre.next = nex.next;
				nex.next = slow.next;
				slow.next = nex;
				nex = pre.next;
			}
		}
		merge(head, slow);
	}

	public void merge(ListNode head, ListNode slow) {
		ListNode p = head;
		ListNode q = slow.next;
		while (q != null && p != null) {
			slow.next = q.next;
			q.next = p.next;
			p.next = q;
			q = slow.next;
			p = p.next.next;
		}
	}
}
