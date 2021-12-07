package com.lyy.fengxiao.order;

import java.util.*;

/**
 * @Author: 白榆
 * @Date: 2021/12/7 9:10 下午
 */
public class order_39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }


    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        if (candidates.length == 1 && candidates[0] > target) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<Integer> paths = new ArrayList<>();
        backTrack(candidates, result, paths, target, 0);
        return result;
    }

    private static void backTrack(int[] candidates, List<List<Integer>> result, List<Integer> paths, int target, int index) {
        if (candidates[0] > target) {
            if (paths.size() > 0) {
                paths.remove(paths.size() - 1);
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            List<Integer> temp = new ArrayList<>(paths);
            if (candidate == target) {
                temp.add(candidate);
                result.add(temp);
            } else if (candidate < target) {
                temp.add(candidate);
                backTrack(candidates, result, temp, target - candidate, i);
            } else {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7,6,5,3,1};
        System.out.println(combinationSum1(nums, 9));
    }
}
