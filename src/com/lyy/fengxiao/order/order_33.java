package com.lyy.fengxiao.order;

/**
 * @Author: 白榆
 * @Date: 2021/11/23 8:22 下午
 */
public class order_33 {

    /**
     * O(n)遍历一遍
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 二分查找中 翻转后必定有一部分数据是有序的
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            //左边是有序的
            if (nums[0] < nums[mid]) {
                if (target > nums[0] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        System.out.println(search1(nums, 3));
    }
}

