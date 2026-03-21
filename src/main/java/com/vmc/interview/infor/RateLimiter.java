package com.vmc.interview.infor;

public class RateLimiter {

	public static void main(String[] args) {
		RateLimiter rateLimiter = new RateLimiter();
		rateLimiter.allowRequest("A", 1);
		rateLimiter.allowRequest("A", 2);
		rateLimiter.allowRequest("A", 3);
		rateLimiter.allowRequest("A", 4);
		rateLimiter.allowRequest("A", 12);
	}

	static int seconds = 0;
	static int durationSeconds = 10;

	boolean allowRequest(String userId, Integer timeStamp) {

		if (timeStamp < (durationSeconds - seconds)) {
			seconds++;
		} else {
			seconds = 0;
		}

		boolean isAllowedRequest = seconds > 3 ? false : true;
		System.out.println("timeStamp:" + timeStamp + " allowed Request:" + isAllowedRequest);
		return isAllowedRequest;
	}

}
