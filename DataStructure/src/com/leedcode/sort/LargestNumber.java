package com.leedcode.sort;

import java.util.Arrays;

/**179��--�����--�е��Ѷ�
 * @author lqw
 * @date 2021/10/5-6:40 ����
 */
public class LargestNumber {

    public static void main(String[] args) {


    }


    public static String largestNumber(int[] nums){

        //1.�������������
        sort(nums, 0, nums.length-1);

        if (nums[0]==0) return "0";

        //2.������õ����ݽ���ƴ��Ȼ���ӡ����

        StringBuilder sb=new StringBuilder();

        for (int num : nums) {
            sb.append(num);

        }
        return sb.toString();

    }


    /**
     * ʵ�ֿ���
     * @param data
     */
    public  static  void sort(int[] data,int lo,int hi){
        if (lo>=hi) return;//���п��ŵĳ���
        int left=lo;
        int right=hi;
        int pivot=data[right];//��׼Ԫ��
        int index=left;
        while (index<=right){
            String xy=data[index]+""+pivot;
            String yx=pivot+""+data[index];
            if (xy.compareTo(yx)>0){
                //����Ԫ�ؽ���
                int tem=data[left];
                data[left]=data[index];
                data[index]=tem;
                index++;
                left++;
            }else if (xy.compareTo(yx)<0){
                int tem=data[right];
                data[right]=data[index];
                data[index]=tem;
                right--;
            }else{
                index++;
            }
        }
        sort(data, lo, left-1);
        sort(data, right+1, hi);
    }


}