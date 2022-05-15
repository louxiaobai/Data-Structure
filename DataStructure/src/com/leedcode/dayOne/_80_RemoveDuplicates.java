package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/1/23-6:00 下午
 */
public class _80_RemoveDuplicates {

    /**
     * 快慢指针
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
    
        if ( nums.length<=2) return nums.length;
        int slow=2;
        int fast=2;
        while (fast<nums.length){
                if (nums[fast]!=nums[slow-2]){
                    nums[slow]=nums[fast];
                    slow++;
                }
                fast++;
        }
        return slow;
    }
}