package com.lyy.fengxiao.order;

import java.util.*;
import java.util.stream.Collectors;

public class order_40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        if (candidates.length == 1 && candidates[0] != target) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, target, result, path, 0, candidates.length);
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> result, Deque<Integer> path, int index, Integer length) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            dfs(candidates, target - candidates[i], result, path, i + 1, length);

            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = combinationSum2(nums, 8);
        System.out.println(lists);
    }
}
