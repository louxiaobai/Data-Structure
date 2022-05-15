package com.leedcode.offer;

/**��ָ Offer 11. ��ת�������С����)(��)
 * @author lqw
 * @date 2021/10/18-4:57 ����
 */
public class MinArray {



    public static void main(String[] args) {

        int[] arr=new int[]{4,4,4,0,4,4,4,4,4,4,4};
        System.out.println(minArray(arr));

    }
    public static int minArray(int[] numbers){
        int left=0;
        int right=numbers.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (numbers[mid]>numbers[right]){
                left=mid+1;
            }else if (numbers[mid]==numbers[right]){
                right--;
            }else{
                right=mid;
            }
        }
        return numbers[left];

    }

}