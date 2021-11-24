package com.lyy.fengxiao.order;

import java.util.Arrays;

public class order_34 {

    /**
     * 遍历
     */
    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        if (length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
            return new int[]{-1, -1};
        }
        int start = -1, end = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                if (start >= 0) {
                    end = i;
                } else {
                    start = i;
                }
            }
        }
        return new int[]{start, end > 0 ? end : start};
    }

    /**
     * 二分查找
     */
    public static int[] searchRange1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        if (length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
            return new int[]{-1, -1};
        }
        int l = 0, r = length - 1;
        int start = -1, end = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                for (int i = mid - 1; i >= 0; i--) {
                    if (nums[i] == target) {
                        start = i;
                        continue;
                    }
                    break;
                }
                for (int i = mid + 1; i < length; i++) {
                    if (nums[i] == target) {
                        end = i;
                        continue;
                    }
                    break;
                }
                if (start == -1) {
                    start = mid;
                }
                if (end == -1) {
                    end = mid;
                }
                break;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,4};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
        System.out.println(Arrays.toString(searchRange1(nums, 1)));
    }
}
