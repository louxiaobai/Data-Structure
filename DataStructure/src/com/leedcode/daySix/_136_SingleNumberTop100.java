package com.leedcode.daySix;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/3/13-10:55 上午
 */
public class _136_SingleNumberTop100 {

    public static void main(String[] args) {

        int[] nums={4,1,2,1,2};

        System.out.println(singleNumber(nums));

    }


    /**
     * 思路:使用异或运算--异或运算具有交换率
     * 时间复杂度:O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){

        int num=0;
        for (int i = 0; i < nums.length; i++) {

            num=num^nums[i];
        }
        return num;
    }

    /**
     * 方法1:使用map进行存储数据 value 代表 key 出现次数代表值
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();

        map.put(nums[0],1);

        for (int i = 1; i < nums.length; i++) {

            if (map.containsKey(nums[i])){

                map.put(nums[i],map.get(nums[i])+1);

            }else{

                map.put(nums[i],1);

            }

        }

        int num=0;
        for (Integer key : map.keySet()) {

            Integer value = map.get(key);

            if (value==1){

                num=key;
            }


        }


        return num;

     }




}