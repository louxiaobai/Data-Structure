package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/2/10-1:06 下午
 */
public class _27_RemoveElement {


    /**
     *快慢指针
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow=0;
        int fast=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[slow]=nums[i];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 对撞指针--移动元素少
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {

        int left=0;

        int right=nums.length-1;

        Double s=new Double( 100.0);

        Boolean w=new Boolean(true);
        while (left<=right){
            if (nums[left]==val){
                nums[left]=nums[right];
                left++;
                right--;
            }
            left++;
        }
        return right;
    }
}