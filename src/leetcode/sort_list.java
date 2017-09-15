package leetcode;

/**
 * 链表的快速排序
 * 
 * @author tigerto
 *
 */
public class sort_list {
	public ListNode sortList(ListNode head) {
		quicksort(head, null);
		return head;
	}

	public void quicksort(ListNode start, ListNode end) {
		if (start != end) {
			ListNode p = partition(start);
			quicksort(start, p);
			quicksort(p.next, end);
		}
	}

	public ListNode partition(ListNode root) {
		int key = root.val;
		ListNode slow = root;
		ListNode fast = root.next;
		while (fast != null) {
			if (fast.val < key) {
				slow = slow.next;
				swap(slow, fast);
			}
			fast = fast.next;
		}
		swap(slow, root);
		return slow;
	}

	public void swap(ListNode p, ListNode q) {
		int tmp = p.val;
		p.val = q.val;
		q.val = tmp;
	}
}
