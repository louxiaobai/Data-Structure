package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/1/23-5:18 下午
 */
public class _26_RemoveDuplicates {
    /**
     * 快慢指针解决
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums==null||nums.length==0) return 0;
        int slow=0;
        int fast=1;
        while (fast<nums.length) {
            if (nums[slow]!= nums[fast]) {
                slow++;
                nums[slow]=nums[fast];
            }
           fast++;
        }
        return slow + 1;

    }

}