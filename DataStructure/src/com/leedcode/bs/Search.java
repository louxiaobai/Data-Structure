package com.leedcode.bs;

/**704. 二分查找
 * @author lqw
 * @date 2021/10/11-8:56 上午
 */
public class Search {

    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums,int target){

        if (nums==null||nums.length==0) return -1;

        int left=0;
        int right=nums.length-1;

        while (left<=right){

            int mid=left+(right-left)/2;

            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                  right=mid-1;
            }else{
                 left=mid+1;
            }

        }
        return -1;

    }


}