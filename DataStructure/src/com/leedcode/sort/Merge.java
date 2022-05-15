package com.leedcode.sort;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
/**�ϲ�����--�е��Ѷ� 56��
 * @author lqw
 * @date 2021/10/5-11:42 ����
 */
public class Merge {



    public static void main(String[] args) {

        int[][] arr={{1,3},{2,5},{9,10}};

        int[][] list=merge(arr);
        System.out.println(list[1][1]);

    }

    public static int[][] merge(int[][] intervals){

        //��һ������ �Զ�ά���鰴�� ��λ���ֵĴ�С��������
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        //������ɽ��кϲ�-�Զ���һ�� ��̬����洢 ����
        ArrayList<int[]> list=new ArrayList<int[]>();

        //�Զ�ά������б���
        for (int i = 0; i <intervals.length ; i++) {

            //���listΪ����ֱ�ӽ��д洢 Ԫ��

            if (list.size()==0){
                list.add(intervals[i]);
            }else{

                //�����Ϊ��������ж�-�Ƿ���кϲ�Ԫ��

                //1.ȡ���Ѿ����Ԫ�ص����ֵ

                int currMax=list.get(list.size()-1)[1];

                //2.�õ���ǰ����Ԫ�ص���Сֵ

                int currMin=intervals[i][0];//

                //3.�����ǰ����Ԫ�ص���Сֵ,���ڵ����Ѵ������е����ֵ -����кϲ�

                if (currMin<= currMax){

                    //�����޸�Ԫ��
                    list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1], intervals[i][1]);
                }else{
                    list.add(intervals[i]);
                }



            }



        }


        return list.toArray(new int[list.size()][]);


    }


}