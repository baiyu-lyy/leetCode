package com.lyy.fengxiao.order;

/**
 * 盛最多水的容器
 *
 * @Author: 白榆
 * @Date: 2021/5/24 9:28 下午
 */
public class order_11 {

    public static void main(String[] args) {
        int[] num = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] num1 = {1, 1};
        maxArea(num1);
        maxArea1(num1);
    }

    //暴力枚举
//    public int maxArea(int[] height) {
//        int max=0;
//        final int length = height.length;
//        for (int i=0;i<length;i++){
//            for (int j=i+1;j<length;j++){
//                final int min = Math.min(height[j], height[i]);
//                final int temp = min * (j - i);
//                max= Math.max(temp, max);
//            }
//        }
//        return max;
//    }

    //双指针
    public static int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int max = 0;
        while (i != j) {
            final int num = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(num, max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(max);
        return max;
    }


    public static int maxArea1(int[] height) {
        final int length = height.length;
        int max = 0;
        for (int l = 1; l <= length - 1; l++) {
            for (int start = 0; start < length - l; start++) {
                int end = start + l;
                final int num = Math.min(height[start], height[end]) * l;
                max = Math.max(max, num);
            }
        }
        System.out.println(max);
        return max;
    }
}
