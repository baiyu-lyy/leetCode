package com.lyy.fengxiao.order;


public class order_31 {

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        boolean flag = false;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        l = i;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        while (l < r) {
            swap(nums, l, r);
            r--;
            l++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        nextPermutation(nums);
    }
}
