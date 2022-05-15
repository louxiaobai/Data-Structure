package com.leedcode.offer;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

/**��ָ Offer 51. �����е������-����
 * @author lqw
 * @date 2021/10/9-2:14 ����
 */
public class ReversePairs{


    public static void main(String[] args) {

        int[] arr=new int[]{7,5,6,4};

        System.out.println( sort(arr, 0, arr.length-1));

        System.out.println(Arrays.toString(arr));
    }


    /**
     * �������������(�鲢����)
     * @param data
     * @param startInde
     * @param endIndex
     */
    public static int sort(int[] data,int startInde,int endIndex) {

        if (startInde == endIndex) return 0;//�ݹ����
        int mid = startInde+((endIndex-startInde)>>1);
        int leftCunt = sort(data, startInde, mid);
        int rightCount = sort(data, mid + 1, endIndex);
        int mergeCount = merge(data, startInde, mid, endIndex);
        return leftCunt + rightCount + mergeCount;
    }
    /**
     * ��������кϲ�
     * @param data
     * @param startIndex
     * @param midIndex
     * @param endIndex
     */
    public static int merge(int[]data,int startIndex,int midIndex,int endIndex){
        int index=0;//����������±�
        int[] copyArr=new int[endIndex-startIndex+1];//��������Ĵ�С
        int p1=startIndex;//������벿��������±�
        int p2=midIndex+1;//�����Ұ벿��������±�
        int count=0;
        //�Կ���������и���
        while (p1<=midIndex&&p2<=endIndex){
            //���и�ֵ��������
            count+=data[p1]>data[p2]?(midIndex+1-p1):0;//�����������
            copyArr[index++]=data[p1]<=data[p2]? data[p1++]:data[p2++];
        }
        while(p1<=midIndex){
            copyArr[index++]=data[p1++];
        }
        while (p2<=endIndex){

            copyArr[index++]=data[p2++];
        }
        //������õ�copyArr��ֵ��ԭ����
        for (int i = 0; i <copyArr.length ; i++) {

            data[startIndex+i]=copyArr[i];
        }
        return count;
    }









}