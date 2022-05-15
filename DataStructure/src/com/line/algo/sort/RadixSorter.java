package com.line.algo.sort;

import java.util.Arrays;

/**ʵ�ֻ�������--�䱾���Ǽ�������
 * @author lqw
 * @date 2021/9/30-9:29 ����
 */
public class RadixSorter {

    public static void main(String[] args) {

        int[] data=new  int[]{100,213,123,324,4356,1233};
        //�ҵ����ֵ
        int max=data[0];

        for (int datum : data) {

            max=Math.max(max, datum);

        }

        for (int exp = 1; max/exp>0 ; exp*=10) {
            radxSorter(data,exp);
        }

        System.out.println(Arrays.toString(data));
    }
    /**
     * ʵ�ֻ�������
     * @param data
     * ��ʵ�ָ�λ���ϵ�����
     */
    public static void radxSorter(int[] data,int exp){

         //1.��ȷ�����������С��
         int max=9;
         int min=0;
        //ȷ����������Ĵ�С
        int [] count=new int[max-min+1];
        //�Լ���������и�ֵ
        for (int i = 0; i <data.length; i++) {
            //��λ��:(234/1)%10
            //ʮλ��:(234/10)%10
            //��λ��:(234/100)%10
            //ǧλ��:(2340/1000)%10
            int digit=(data[i]/exp)%10;//ȡ����λ�ϵ�����
            count[digit]++;
        }
        //�Լ�������ִ���ۼӲ���
        int sum=0;
        for (int i = 0; i <count.length ; i++) {
            sum+=count[i];
            count[i]=sum;

        }

        //ִ��������-����һ����������

        int[] sort=new int[data.length];


        for (int i = data.length-1; i >=0 ; i--) {

            int j=(data[i]/exp)%10;
            int k=count[j-min]-1;
            sort[k]=data[i];
            count[j-min]--;
        }

        for (int i = 0; i <sort.length ; i++) {
            data[i]=sort[i];
        }
    }
}