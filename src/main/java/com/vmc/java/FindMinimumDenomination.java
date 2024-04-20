package com.vmc.java;

import java.util.HashMap;
import java.util.Map;

public class FindMinimumDenomination implements Logic {

	@Override
	public void execute() {
		int input = 17000;
		int[] denominations = { 2000, 500, 200, 100 };
		findMinimumDenomination(input, denominations);
	}

	private void findMinimumDenomination(int input, int[] denominations) {
		int remainder = input;
		for (int i = 0; i < denominations.length; i++) {
			if (remainder >= denominations[i]) {
				System.out.println("denomination " + denominations[i] + " count:" + remainder / denominations[i]);
				remainder = remainder % denominations[i];
				if (remainder == 0) {
					return;
				}
			}
		}
	}

	@Override
	public void executeWithSoultion2() {
		int input = 17000;
		int[] denominations = { 2000, 500, 200, 100 };
		findMinimumDenominationSoultion2(input, denominations);

	}

	private void findMinimumDenominationSoultion2(int amount, int[] denominations) {
		Map<Integer, Integer> denominationCountMap = new HashMap<>();
		for (int denomination : denominations) {
			if (amount == 0)
				break;
			if (amount >= denomination) {
				int remainder = amount % denomination;
				int denominationCount = amount / denomination;
				denominationCountMap.put(denomination, denominationCount);
				amount -= denomination * denominationCount;
			}
		}
		System.out.println("denominationCountMap:" + denominationCountMap);
	}

	@Override
	public void executeWithSoultion3() {

	}

	@Override
	public void executeUsingJava8() {

	}

}
