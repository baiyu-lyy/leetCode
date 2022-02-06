package com.lyy.fengxiao.order;

import java.util.HashMap;
import java.util.Map;

public class order_41 {

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int min = nums[0];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            map.put(num, i);
            if (num < 0) {
                continue;
            }
            if (num < min || min < 0) {
                min = num;
            }
        }

        if (min < 0 || min > 1) {
            return 1;
        }
        for (int i = min; i < Integer.MAX_VALUE; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 1;
    }

    public static int firstMissingPositive1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] < length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return length+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 4, 2, 1, 9, 10, 0};
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive1(nums));
    }
}
