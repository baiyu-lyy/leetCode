package com.lyy.fengxiao.order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 白榆
 * @Date: 2021/5/29 4:15 下午
 */
public class order_1 {

    public int[] twoSum(int[] nums, int target) {
        final int length = nums.length;
        int[] result=new int[2];
        for (int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                final int sum = nums[i] + nums[j];
                if (sum==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        final int length = nums.length;
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<length;i++){
            if (map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                return result;
            }
            map.put(nums[i],i);
        }
        return nums;
    }
}
