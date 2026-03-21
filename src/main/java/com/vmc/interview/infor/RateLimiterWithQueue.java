package com.vmc.interview.infor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RateLimiterWithQueue {

	public static void main(String[] args) {
		RateLimiterWithQueue rateLimiter = new RateLimiterWithQueue();
		rateLimiter.allowRequest("A", 1);
		rateLimiter.allowRequest("A", 2);
		rateLimiter.allowRequest("A", 3);
		rateLimiter.allowRequest("A", 4);
		rateLimiter.allowRequest("A", 12);
		rateLimiter.allowRequest("A", 15);
		rateLimiter.allowRequest("A", 17);
		rateLimiter.allowRequest("A", 18);
	}
	
	
	private Map<String, Queue<Integer>> userRequests = new HashMap<>();
	private final int MAX_REQUESTS = 3;
	private final int WINDOW_SIZE = 10;

	public boolean allowRequest(String userId, int timestamp) {
		// 1. Get the list for this user (or create a new one)
		userRequests.putIfAbsent(userId, new LinkedList<>());
		Queue<Integer> timestamps = userRequests.get(userId);

		// 2. Remove timestamps that are older than 10 seconds from current
		// Formula: Current Timestamp - Previous Timestamp >= 10
		timestamps.removeIf(t -> t <= timestamp - WINDOW_SIZE);

		// 3. Check if they have room for a new request
		if (timestamps.size() < MAX_REQUESTS) {
			timestamps.add(timestamp);
			System.out.println("timeStamp:" + timestamp + " allowed Request:" + true);
			return true;
			
		}
		System.out.println("timeStamp:" + timestamp + " allowed Request:" + false);

		return false;
	}
}
