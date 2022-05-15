package com.leedcode.dayTwelve;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/4/23-12:30 下午
 */
public class _209_MinSubArrayLenOffer {


    public static void main(String[] args) {


        int[] arr=new int[]{1,2,3,4,5,6,7,8,20};
        int[] preSum=new int[arr.length+1];
        preSum[0]=0;
        for (int i = 1; i <=arr.length; i++) {
            preSum[i]=arr[i-1]+preSum[i-1];
        }

        System.out.println(Arrays.toString(preSum));


//        System.out.println(minSubArrayLen(15,arr));

    }




    /**
     * 滑动窗口--定义滑动窗口的左右指针 left 和righta 如果 窗口内的数据之和不大于等于 target 则一只让 right++
     * 如果一旦窗口内的数据之和大于等于 target 则让left++进行缩小 窗口,一直如此进行计算窗口的最小值
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {

        int left=0;
        int right=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while (right<nums.length){
            sum+=nums[right];
            while (sum>=target){//如果窗口总和大于等于target
                min=Math.min(min, right-left+1);
                left++;
                sum=sum-nums[left];
            }
            right++;
        }

        return min==Integer.MAX_VALUE?0:min;
    }

    /**
     * 二分+前缀和进行求解--因为题目数组中的值都是大于0值  所以数组的前缀和 则一定是一个升序数组--故可以使用升序数组进行求解
     *
     * preSum[j]-preSum[i]>=target
     *
     * preSum[j]>=preSum[i]+target
     *
     * 时间复杂度:O(nlog)
     * 空间复杂度:O(n)
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums){

        int ans=Integer.MAX_VALUE;
        int[] preSum=new int[nums.length+1];
        preSum[0]=0;
        for (int i = 1; i <nums.length; i++) {
            preSum[i]=nums[i-1]+preSum[i-1];
        }
        //前缀和的解法 preSum[j]-preSum[i]>=target
        //preSum[j]>=target+preSum[i]-意在找到数组中第一个大于等于的 则为滑动窗口的最小值
        for (int i = 1; i < preSum.length; i++) {

            int temp=target+preSum[i-1];

            int j=firstGetTagetElement(preSum, temp);

            if (j<0) continue;//如果没有则说明无此窗口 直接进行返回即可

            ans=Math.min(ans, j-temp+1);
            
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
    /**
     * 查找数组中大于或者等于某个值的第一个位置 找不到则进行返回 -1;
     * @return
     */
    public static int firstGetTagetElement(int[] nums,int target){

        if (nums==null||nums.length==0) return -1;
        int left=0;
        int righ=nums.length-1;
        while (left<=righ){
             int mid=left+(righ-left)/2;
             if (target<=nums[mid]){
                 //如果当前值大于或者等于目标值 则接下来进行判断 他左边的值
                 //是否也是大于目标值的,如果不大于则直接返回
                 if (mid==0||nums[mid-1]<target) return mid;
                 else righ=mid-1;
             }else {
                 left=mid+1;
             }
        }
        return -1;//没有找到
    }



}