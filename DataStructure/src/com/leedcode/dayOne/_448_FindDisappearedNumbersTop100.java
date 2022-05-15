package com.leedcode.dayOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqw
 * @date 2022/1/23-10:05 上午
 */
public class _448_FindDisappearedNumbersTop100 {

    public static void main(String[] args) {

        int[] arr=new int[]{4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(arr));
    }

    /**
     * 在原始数组加负数用来标记数组中已经出现过的值
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            int index=Math.abs(num)-1;
            if (nums[index]>0){
                nums[index]=-nums[index];//将出现过的数字--当做下标值为负数
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){//如果值大于0说明以该下表的值没出现过
                list.add(i+1);
            }
        }
        return list;
    }

}