package com.leedcode.dayNine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/4/5-11:43 上午
 */
public class _128_LongestConsecutiveOffer {

    public static void main(String[] args) {


        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2,101,102,103,104,105}));

    }

    /**
     * 使用hash查找:先将所有的数据用hash表进行存储,然后去遍历 数组中的每一个元素
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums){

        if (nums.length<2) return nums.length;


        //1.将前部元素进行hash存储

        Set<Integer>  hashSet=new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);

        }

        int max=1;
        for (int num : nums) {

            if (hashSet.contains(num-1)) continue;// 比如 遍历到了 6 那么 以7开的数据就没有必要进行再次遍历了，

            int currNum=num;

            int ans=1;

            while (hashSet.contains(currNum+1)){//如果存在currNum+1--则说明是连续的

                ans++;

                currNum++;
            }

            max=Math.max(max, ans);

        }

        return max;

    }





    /**
     * 思路:先将数据进行排序,这样可以方便统计出现的次数
     * 时间复杂度:O(nlogn)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutive1(int[] nums) {

        //1.进行特殊判断
        if (nums.length<2) return nums.length;
        Arrays.sort(nums);

        int ans=1;
        int max=1;
        for (int i = 1; i < nums.length; i++) {


            if (nums[i]==(nums[i-1])){

                continue;
            }
            if (nums[i]==(nums[i-1]+1)){
                ans++;
            } else{

                max=Math.max(ans, max);
                ans=1;


            }



        }

        return Math.max(max,ans);

    }


}