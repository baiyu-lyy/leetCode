package com.lyy.fengxiao.order;

import java.util.*;

/**
 * 数组+排序+双指针
 *
 * @Author: 白榆
 * @Date: 2021/8/23 10:25 上午
 */
public class order_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        final int length = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];
                if (b + c + a == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    Collections.sort(list);
                    set.add(list);
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                    r--;
                    while (nums[r] == nums[r + 1] && l < r) {
                        r--;
                    }
                }
                if (b + c > -a) {
                    r--;
                    while (nums[r] == nums[r + 1] && l < r) {
                        r--;
                    }
                }
                if (b + c < -a) {
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
