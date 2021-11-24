package com.lyy.fengxiao.order;

public class order_35 {

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int l = 0, r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums,2));
    }
}
