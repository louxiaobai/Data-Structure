package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/3/31-7:29 下午
 */
public class _33_SearchTop100 {


    /**
     * 思路: 因为是反转数组---说明数组 两半都是有序的,根据nums[mid]和nums[right]进行比对大小
     * 如果nums[left]<=nums[mid]说明mid左边一定是有序的,相反右边一定有序的,然后在这两个的区间判断是left+1 还是rigt-1
     *特别注意:这里使用等于(nums[left]<=nums[mid])是因为 left和mid 指向的可能是同一个元素 例如 [1,2]
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

         if (nums==null||nums.length==0) return -1;


         int left=0;

         int right=nums.length-1;


         while (left<=right){

             int mid=left+(right-left)/2;
             if (nums[mid]==target){
                 return mid;
             }
             if (nums[left]<=nums[mid]){//这就说明mid左边是有有序的,这里=是有可能出现 nums[left]==nums[mid]比如数组[3,1]
                 if (target>=nums[left]&&target<nums[mid]){//说明有可能在left-mid这个区间内
                     right=mid-1;
                 }else {
                     left=mid+1;
                 }
             }else{

                 if (target>nums[mid]&&target<=nums[right]){//说明有可能在mid-right的区间内

                     left=mid+1;
                 }else {
                     right=mid-1;

                 }
             }
         }
         return -1;
    }
}