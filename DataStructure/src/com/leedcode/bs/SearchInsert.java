package com.leedcode.bs;

/**leedcode 35. ËÑË÷²åÈëÎ»ÖÃ--¼òµ¥
 * @author lqw
 * @date 2021/10/12-8:43 ÉÏÎç
 */
public class SearchInsert {

    public static void main(String[] args) {

        int[]nums={1,3,5,6};
        System.out.println(searchInsert(nums, 5));
    }

    public static int searchInsert(int[] nums,int target) {

        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (target>nums[nums.length-1]) return nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {

                if (mid == 0 || nums[mid - 1] < target) return mid;
                else right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return -1;

    }

    }