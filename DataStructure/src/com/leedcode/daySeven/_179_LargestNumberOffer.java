package com.leedcode.daySeven;

/**
 * @author lqw
 * @date 2022/3/29-11:08 上午
 */
public class _179_LargestNumberOffer {

    public static void main(String[] args) {


        _179_LargestNumberOffer largestNumberOffer = new _179_LargestNumberOffer();

        int[] arr=new int[]{3,30,34,5,9};
        _179_LargestNumberOffer largestNumberOffer1 = largestNumberOffer;
        largestNumberOffer1.largestNumber(arr);



    }


    public String largestNumber(int[] nums){

        if (nums.length==1) return nums[0]+"";

        sort(nums, 0, nums.length-1);

        StringBuilder sb=new StringBuilder();

        for (int num : nums) {

            sb.append(num);

        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    public void sort(int[] arr,int lo,int hi){

        if ( lo>=hi) return;//结束条件

        int less=lo;
        int great=hi;
        int index=less;
        int pivot=arr[great];
        while (index<=great){
            String xy=arr[index]+""+pivot;// 2 23
            String yx=pivot+""+arr[index];// 23 2
            if (xy.compareTo(yx)>0){//xy 组合大于 yx组合
                int temp=arr[index];
                arr[index]=arr[less];
                arr[less]=temp;
                less++;
                index++;
            }else if (xy.compareTo(yx)<0){
                int temp=arr[index];
                arr[index]=arr[great];
                arr[great]=temp;
                great--;
            }else{
                index++;
            }
        }
        sort(arr, lo,less-1);
        sort(arr, great+1, hi);
    }




}