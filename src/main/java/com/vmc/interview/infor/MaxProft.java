package com.vmc.interview.infor;

public class MaxProft {

	public static void main(String[] args) {
		int prices[] = {7,6,4,3,1};//{2,4,1};//{7,1,5, 3, 6, 4};
		int minPrice=prices[0];
		int maxProfit=0;
		for (int i = 0; i < prices.length; i++) {
			maxProfit=Math.max(maxProfit, prices[i]-minPrice);
			minPrice=Math.min(minPrice, prices[i]);
		}
		System.out.println(maxProfit);
		
	}

}
