package com.lyy.fengxiao.algorithm.stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class NextGreaterElementsII {
    /**
     * 下一个更大元素 II：503。
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     * 示例 1:
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     * 注意: 输入数组的长度不会超过 10000。
     */
    public static int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> queue= new ArrayDeque<>();
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            while (!queue.isEmpty()){
                if (queue.peekLast()<nums[i]){
                    if (map.containsKey(queue.peekLast())){
                        map.get(queue.pollLast()).put(i-1,nums[i]);
                    }else {
                        Map<Integer,Integer> map1=new HashMap<>();
                        map1.put(i-1,nums[i]);
                        map.put(queue.pollLast(),map1);
                    }
                }else {
                    break;
                }
            }
            queue.addLast(nums[i]);
        }

        int first=queue.getFirst();
        for (int i=0;nums[i]<first;i++){
            if (!queue.isEmpty()){
                if (nums[i]>queue.peekLast()){
//                    map.put(queue.pollLast(),nums[i]);
                }
            }
        }

        while (!queue.isEmpty()){
            if (queue.getFirst()>queue.getLast()) {
//                map.put(queue.pollLast(), queue.getFirst());
            }else {
//                map.put(queue.pollLast(),-1);
            }
        }

        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
//            result[i]=map.get(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num=new int[]{100,1,11,1,120,111,123,1,-1,-100};
        System.out.println(Arrays.toString(nextGreaterElements(num)));
    }
}
