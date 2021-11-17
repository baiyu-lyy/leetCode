package com.lyy.fengxiao.order;

/**
 * @Author: 白榆
 * @Date: 2021/9/7 10:37 上午
 */
public class order_26 {

    public static int removeDuplicates(int[] nums) {
        final int length = nums.length;
        int l = 0, r = 1;
        while (r < length) {
            if (nums[l] == nums[r]) {
                r++;
                continue;
            }
            if (r - l > 1) {
                nums[l + 1] = nums[r];
            }
            l++;
            r++;
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
