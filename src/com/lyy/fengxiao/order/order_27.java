package com.lyy.fengxiao.order;

/**
 * 双指针
 *
 * @Author: 白榆
 * @Date: 2021/9/8 10:25 上午
 */
public class order_27 {

    public static int removeElement(int[] nums, int val) {
        final int length = nums.length;
        if (length == 1) {
            if (nums[0] == val) {
                return 0;
            }
            return 1;
        }
        int l = 0, r = length - 1;
        while (l <= r) {
            if (l == r && nums[l] == val) {
                return l;
            }
            while (nums[r] == val) {
                r--;
                if (r < 0 || l > r) {
                    return l;
                }
            }
            final int num = nums[l];
            if (num == val) {
                nums[l] = nums[r];
                nums[r] = num;
                r--;
            }
            l++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 4, 0};
        System.out.println(removeElement(nums, 4));
    }
}
