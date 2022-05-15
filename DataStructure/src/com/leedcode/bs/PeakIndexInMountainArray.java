package com.leedcode.bs;

/**ɽ������ķ嶥���� leedcode 852 -��
 * @author lqw
 * @date 2021/10/19-9:11 ����
 */
public class PeakIndexInMountainArray {

    public static void main(String[] args) {

        int[] arr={0,5,3,1};;

        System.out.println(peakIndexInMountainArray(arr));

    }


    /**
     * ʹ�ö��ֲ��ҽ����ҵ���ֵ
     * @param arr
     * @return
     */

    public static int peakIndexInMountainArray(int[] arr){

        int left=0;
        int right= arr.length-1;

        int mid=0;
        //����֪��fɽ������һ���� �������� һ������������
       while (left<=right){

            mid=left+(right-left)/2;

            if (arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){

                  return  mid;//�õ���ֵ���±�

            }else if (arr[mid]<arr[mid+1]){

                 left=mid+1;

            }else {

                right=mid;
            }



        }

        return mid;

    }



}