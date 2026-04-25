package com.vmc.interview.altimetric;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public static void main(String[] args) {
        int[]  nums = {2, 7, 11, 15};
        nums = new int[]{3, 2, 4};
        nums = new int[]{3, 3};
        int target=6;
        int[] outputArray =new int[2];
        outputArray= findTwoSum(nums,target);
    }

    private static int[] findTwoSum(int[] nums, int target) {
        int[] outputArray =new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(map.containsKey(need)){
                outputArray =    new int[]{map.get(need),i};
            }
            map.put(nums[i],i);//2,0;7,1
        }
        Arrays.stream(outputArray).forEach(System.out::println);
        return outputArray;
    }
}
