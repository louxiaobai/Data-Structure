package com.line.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;


/**ʵ��Ͱ����
 * @author lqw
 * @date 2021/9/29-3:38 ����
 */
public class BucketSorter {


    public static void main(String[] args) {

//        int[] data = new int[]{2, 5, 1, 23, 22, 33, 56, 12, 5, 3, 5, 6, 8, 2, 3, 4};
//        new BucketSorter().bucketSort(data);
//        System.out.println(Arrays.toString(data));
    }
    /**
     *����Ͱ����
     * @param data
     */
    public static void bucketSort(int[] data){

        if (data==null||data.length<2) return;//������Ҫ���������ֱ�ӽ��з���
        //���з�Ͱ����--�������Ԫ�ص���ֵ���з�Ͱ��Ͱ�ĸ���Ϊ���Ԫ�س�10+1
        //Ͱ�ĸ������Ը���ҵ����Ҫ���л���,����û��ͳһ��Ҫ��
        //ȡ��������Ԫ�ص����ֵ
        int maxValue=data[0];

        for (int datum : data) {

            maxValue=Math.max(maxValue, datum);

        }

        int bucketNum=maxValue/10+1;//�õ���Ͱ�ĸ���

        ArrayList<Integer>[] buckets=new ArrayList[bucketNum];

        //����Ӧ��Ԫ����ӵ�Ͱ��
        for (int i = 0; i <data.length; i++) {

            int index=data[i]/10;

            //���Ͱû�д�������д���Ͱ
            if (buckets[index]==null){

                buckets[index]=new ArrayList<Integer>();

            }
            buckets[index].add(data[i]);

        }
        //��ÿһ��Ͱ�й���Ԫ�ؽ�������---����ѡ�����������㷨��������
        //����ѡ���������-��������Ч�ʸ�
        for (int i = 0; i <bucketNum ; i++) {

            ArrayList<Integer> bucket = buckets[i];//�õ�����Ͱ������
            //��Ͱ�ڵ����ݽ�������

            if (bucket!=null){//���Ͱ��Ԫ�ز�Ϊ��������������

                 ArrayQuickSorter.sort(bucket);
            }

        }
        //��bucket���õ�����������
        int index=0;
        for (int i = 0; i <bucketNum; i++) {

            ArrayList<Integer> bucketData=buckets[i];

            if (bucketData!=null){
                for (int j = 0; j < bucketData.size(); j++) {
                    data[index++] = bucketData.get(j);
                }
            }


            
        }

    }





}