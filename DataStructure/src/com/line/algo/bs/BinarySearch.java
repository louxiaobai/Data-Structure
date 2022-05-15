package com.line.algo.bs;

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;

/**���ֲ��ҵı�������
 * @author lqw
 * @date 2021/10/10-10:14 ����
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] data=new int[]{1,2,3,4,5,6,6,6,7,7,8,9};

        System.out.println(lastLETragetElement(data,7));
    }
    /**
     * ���ֲ���--������С�±��Ŀ��Ԫ��
     * @param data
     * @param target
     * @return
     */
    public static int firstTargetElement(int[] data,int target){

        if (data==null||data.length==0) return -1;
        int left=0;
        int right=data.length-1;


        while (left<=right){
            int mid=left+(right-left)/2;
            if (target==data[mid]){

                //mid������ĵ�һ��Ԫ�� ��ֱ�ӷ���
                //mid��ǰһ��Ԫ�ز����� target
                if (mid==0||data[mid-1]!=target) return mid;

                else right=mid-1;

            }else if (target<data[mid]){


                 right=mid-1;

            }else {

                left=mid+1;
            }

        }



        return -1;



    }

    /**
     * ���ֲ���--���ҵ�һ�����ڵ���Ŀ��Ԫ�ص��±�
     * @param data
     * @param target
     * @return
     */
    public static int fisrtGETargetElement(int[] data,int target){
        if (data==null||data.length==0) return -1;
        int left=0;
        int right=data.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (data[mid]>=target){
                //�����������������֮һ�ͷ���mid
                //1.mid ������ĵ�һ��Ԫ��
                //2.min ǰ����Ǹ�Ԫ��С��target
                if (mid==0 || data[mid-1]>target) return mid;
                else right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    /**
     * ���ֲ���--���ҵ����һ������Ŀ��Ԫ�ص��±�
     * @param data
     * @param target
     * @return
     */
    public static int lastTargetElement(int[] data,int target){

        if (data==null||data.length==0) return -1;
        int left=0;
        int right=data.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (target==data[mid]){
                if (mid==data.length-1||data[mid+1]!=target) return mid;
                else left=mid+1;
            }else if (target<data[mid]){

                right=mid-1;

            }else {

                left=mid+1;
            }

        }



        return -1;



    }

    /**
     * ���ֲ���-���ҵ����һ��С�ڵ���Ŀ��ֵ���±�
     * @param data
     * @param target
     * @return
     */
    public static int lastLETragetElement(int[] data,int target){

        if (data==null||data.length==0) return -1;

        int left=0;
        int right=data.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (data[mid]<=target){
                if (mid==data.length-1|| data[mid+1]>target) return mid;
                else left=mid+1;
            }else {
                right=mid-1;
            }
        }

        return -1;
    }

}