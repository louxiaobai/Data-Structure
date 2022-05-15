package com.leedcode.sort;

/**
 * @author lqw
 * @date 2021/10/6-4:50 ����
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        sort(nums);
    }

    //ֻ��Ҫ���п��ŵ�һ����
    public static void sort(int[] data){

        int index=0;
        int left=0;
        int right=data.length-1;

        while(index<=right){

            if(data[index]==0){

                int temp=data[left];
                data[left]=data[index];
                data[index]=temp;
                index++;
                left++;

            }else if(data[index]==2){

                int temp=data[right];
                data[right]=data[index];
                data[index]=temp;
                right--;

            }else{

                index++;
            }


        }
    }
}