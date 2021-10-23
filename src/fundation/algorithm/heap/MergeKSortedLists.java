package fundation.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并k个有序链表
 *
 * @author chenyuxian
 * @date 2021-10-23 17:26:47
 */
public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode();
		ListNode node = res;
		Queue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
		for (ListNode list : lists) {
			if (list != null) {
				queue.add(list);
			}
		}
		while(!queue.isEmpty()) {
			ListNode min = queue.remove();
			node.next = min;
			node = node.next;
			if(min.next != null) {
				queue.add(min.next);
			}
		}
		return res.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
