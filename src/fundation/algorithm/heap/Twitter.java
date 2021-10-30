package fundation.algorithm.heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 设计推特
 * @author Administrator
 * @date 2021-10-25 14:28:43
 */
public class Twitter {

	Map<Integer, LinkedList<Node>> container;
	Map<Integer, Set<Integer>> follow;
	int time = 0;

	public Twitter() {
		container = new HashMap<>();
		follow = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		if (!container.containsKey(userId)) {
			container.put(userId, new LinkedList<>());
		}
		int index = container.get(userId).size();
		container.get(userId).add(new Node(userId, tweetId, index, time));
		time++;
	}

	public List<Integer> getNewsFeed(int userId) {
		PriorityQueue<Node> deque = new PriorityQueue<>((a, b) -> (int) (b.time - a.time));
		int k = 0;
		List<Integer> res = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		if (container.containsKey(userId)) {
			set.add(userId);
		}
		if (follow.containsKey(userId)) {
			set.addAll(follow.get(userId));
		}
		for (Integer key : set) {
			if (container.containsKey(key)) {
				deque.offer(container.get(key).getLast());
			}
		}
		while (!deque.isEmpty() && k < 10) {
			Node node = deque.poll();
			res.add(node.tweetId);
			if (node.index >= 1) {
				deque.offer(container.get(node.userId).get(node.index - 1));
			}
			k++;
		}
		return res;
	}

	public void follow(int followerId, int followeeId) {
		if (!follow.containsKey(followerId)) {
			follow.put(followerId, new HashSet<>());
		}
		follow.get(followerId).add(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		if (follow.containsKey(followerId)) {
			follow.get(followerId).remove(Integer.valueOf(followeeId));
		}
	}

	class Node {
		int userId;
		int tweetId;
		int index;
		int time;

		public Node(int userId, int tweetId, int index, int time) {
			this.userId = userId;
			this.tweetId = tweetId;
			this.index = index;
			this.time = time;
		}
	}
}
