package com.lyy.fengxiao.algorithm.stack;

import java.util.*;

public class NextGreaterElement {

    /**
     * 下一个更大元素 I：496。栈
     * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * 示例 1:
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     *
     * 解题思路：先遍历nums数组，将其放入栈中，并比较其与前一个数值pre的大小，
     * 如果其大于pre，那么其就是pre的下一个更大的数字。
     * 如果其小于等于pre，那么将其放入到栈中，最后栈中剩余的数值都是没有下一个更大的数字的。
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();

        for (int value : nums2) {
            while (!stack.isEmpty()) {
                if (stack.peek() < value) {
                    map.put(stack.pop(), value);
                }else {
                    break;
                }
            }
            stack.push(value);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        int[] result=new int[nums1.length];

        for (int i=0;i<nums1.length;i++){
             result[i]=map.get(nums1[i]);
        }

        return result;
    }

}
