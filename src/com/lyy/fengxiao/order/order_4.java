package com.lyy.fengxiao.order;

/**
 * @Author: 白榆
 * @Date: 2021/6/6 4:00 下午
 */
public class order_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, m = 0;
        int num1 , num2;
        while (i < nums1.length && j < nums2.length) {
            num1 = nums1[i];
            num2 = nums2[j];
            if (num1 <= num2) {
                nums[m++] = num1;
                i++;
            } else {
                nums[m++] = num2;
                j++;
            }
        }
        if (i!=nums1.length){
            while (i<nums1.length){
                nums[m++]=nums1[i];
                i++;
            }
        }
        if (j!=nums2.length){
            while (j<nums2.length){
                nums[m++]=nums2[j];
                j++;
            }
        }
        final int length = nums1.length + nums2.length;
        final int i1 = length / 2;
        if (length%2==0){
            return (nums[i1]+nums[i1-1])/2.0;
        }else {
            return nums[i1];
        }
    }

    public static void main(String[] args) {
        int[] nums1={0,1,2};
        int[] nums2={3,4};
        final double v = findMedianSortedArrays(nums1, nums2);
        System.out.println(v);
    }
}
