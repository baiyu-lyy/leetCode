package com.lyy.fengxiao.order;

import java.util.Arrays;

/**
 * 数组、排序、双指针
 *
 * @Author: 白榆
 * @Date: 2021/8/23 11:20 上午
 */
public class order_16 {

    public static int threeSumClosest(int[] nums, int target) {
        final int length = nums.length;
        Arrays.sort(nums);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int l = i + 1, r = length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];
                int sum = a + b + c;
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    r--;
                }
                if (sum < target) {
                    l++;
                }
                final int diff = Math.abs(sum - target);
                if (diff < min) {
                    result = sum;
                    min = diff;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
