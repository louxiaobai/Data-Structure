package com.leedcode.dayTwelve;

/**
 * @author lqw
 * @date 2022/4/24-10:59 上午
 */
public class Test2 {


    /**
     * 二分另外一种写法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {



        int left=0;

        int right=nums.length-1;

        while (left<=right){


            int mid=left+(right-left)/2;
            if (nums[mid]>=target){


                right=mid-1;

            }else{

                left=mid+1;
            }


        }

        return left;




    }
    /**
     * 二分解法-时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {


        int left=0;

        int right=nums.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]>=target){
                if (mid==0||nums[mid-1]<target)return mid;
                else right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return nums.length;





    }
    /**
     * 暴力解法 时间复杂度:O(n)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {


        for (int i = 0; i <nums.length ; i++) {


            if (nums[i]>=target) return i;

        }
        return 0;


    }
}