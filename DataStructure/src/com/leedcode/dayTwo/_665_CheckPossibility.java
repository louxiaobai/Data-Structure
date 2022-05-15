package com.leedcode.dayTwo;

/**
 * @author lqw
 * @date 2022/2/12-9:36 下午
 */
public class _665_CheckPossibility {


    public static void main(String[] args) {

        int[] arr=new int[]{-1,4,2,3};

        System.out.println(checkPossibility(arr));

    }

    /**
     * 时间复杂度o(n)
     * 空间复杂度o(1)
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {

        int cout=0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i-1]>nums[i]){

                cout++;

                if (cout>1) return  false;

                if (i-2>0&&nums[i]<nums[i-2]){
                    nums[i]=nums[i-1];
                }else{

                    nums[i-1]=nums[i];
                }
            }
        }
        return true;
    }
}