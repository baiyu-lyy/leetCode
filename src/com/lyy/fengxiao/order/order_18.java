package com.lyy.fengxiao.order;

import java.util.*;

/**
 * @Author: 白榆
 * @Date: 2021/8/25 10:27 上午
 */
public class order_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        final int length = nums.length;
        for (int i = 0; i < length - 4; i++) {
            int a = nums[i];
            if (i != 0 && a == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 3; j++) {
                int b = nums[j];
                if (j != i + 1 && b == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = length - 1;
                while (l < r) {
                    int c = nums[l], d = nums[r];
                    final int sum = a + b + c + d;
                    if (sum == target) {
                        set.add(Arrays.asList(a, b, c, d));
                        l++;
                        r--;
                    }
                    if (sum > target) {
                        r--;
                    }
                    if (sum < target) {
                        l++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(fourSum(nums, 8));
    }
}
