package com.vmc.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FindMinimumDenomination implements Logic {

    @Override
    public void execute() {
        calculateDenominationCounts(17000, new int[]{2000, 500, 200, 100});
    }

    private void calculateDenominationCounts(int amount, int[] denominations) {
        for (int denomination : denominations) {
            if (amount >= denomination) {
                System.out.println("Denomination " + denomination + " count: " + (amount / denomination));
                amount %= denomination;
                if (amount == 0) break;
            }
        }
    }

    @Override
    public void executeWithSoultion2() {
        calculateDenominationCountsSolution2(17000, new int[]{2000, 500, 200, 100});
    }

    private void calculateDenominationCountsSolution2(int totalAmount, int[] availableDenominations) {
        Map<Integer, Integer> denominationToCountMap = new HashMap<>();
        for (int denomination : availableDenominations) {
            if (totalAmount == 0) break;
            if (totalAmount >= denomination) {
                denominationToCountMap.put(denomination, totalAmount / denomination);
                totalAmount %= denomination;
            }
        }
        System.out.println("denominationToCountMap: " + denominationToCountMap);
    }

    @Override
    public void executeWithSoultion3() {
        // Placeholder for future implementation
    }

    @Override
    public void executeUsingJava8() {
        calculateMinimumDenominationsJava8(17000, new int[]{2000, 500, 200, 100});
    }

    private void calculateMinimumDenominationsJava8(int input, int[] denominations) {
        AtomicInteger remainingAmount = new AtomicInteger(input);
        Arrays.stream(denominations).forEach(denomination -> {
            if (remainingAmount.get() >= denomination) {
                System.out.println("Denomination " + denomination + " count: " + (remainingAmount.get() / denomination));
                remainingAmount.set(remainingAmount.get() % denomination);
            }
        });
    }
}