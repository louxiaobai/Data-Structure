package com.leedcode.dayTwo;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lqw
 * @date 2022/2/13-11:00 上午
 */
public class _228_SummaryRanges {


    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public  List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();
        int left=0,right=0;//用于记录连续数字的区间
        for (int i = 0; i < nums.length; i++) {
            if (i+1<nums.length&&nums[i]+1==nums[i+1]){
                right++;
            }else {
                if (left==right){
                    list.add(String.valueOf(nums[left]));
                }else{
                    list.add(String.valueOf(nums[left])+"->"+String.valueOf(nums[right]));
                }
                right++;
                left=right;
            }
        }
        return list;

    }

}