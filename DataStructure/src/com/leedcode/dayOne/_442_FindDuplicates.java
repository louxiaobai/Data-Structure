package com.leedcode.dayOne;

import sun.jvm.hotspot.runtime.linux.LinuxSignals;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/1/23-8:21 上午
 */
public class _442_FindDuplicates {

    public static void main(String[] args) {

        int[] arr=new int[]{2,3,4,5,2,1,1,3};
        System.out.println(findDuplicates(arr));
    }

    /**
     * 在原始数组加负数用来标记数组中已经出现过的值
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();//存储数组中出现次数为2的数
        for (int i = 0; i < nums.length; i++) {

            //1.遍历数组得到数值
            int num = nums[i];
            int index=Math.abs(num)-1;
            //2.将数组中为num-1下标的值置为负数

            if (nums[index] < 0) {
                 list.add(Math.abs(num));
            } else {
                nums[index] = -nums[index];
            }

        }

        return list;
    }

}