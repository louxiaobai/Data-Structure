package com.line;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.text.Caret;
import java.util.Arrays;

/**����Ĭд���������㷨
 * @author lqw
 * @date 2021/10/25-2:04 ����
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr={123,232,12,32,1};
        //selectSort01(arr);//ѡ������
        //insertSort01(arr);//��������1.0�汾
        //insertSortO2(arr);//��������2.0�汾
        //shellSort(arr);//��������3.0�汾
        //bubbleSort(arr);//ð������1.0�汾
        //bubbleSort02(arr);//ð������2.0�汾
        //quickSort(arr,0,arr.length-1);//��������
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * ����ѡ������
     * ���ȶ�����
     * @param arr
     */
    public static void selectSort01(int[] arr){
        //ÿ�δӺ���ѡ��һ����С��Ԫ��
        for (int i = 0; i <arr.length ; i++) {
            int minIndex=i;
            for (int j=i; j <arr.length ;j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            if (minIndex!=i){//˵���ҵ��� ��С��Ԫ�� --���и���
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]= temp;

            }
        }





    }
    /**
     * �������� 1.0�汾
     * @param arr
     */
    public static  void insertSort01(int[] arr){

        //�Ӻ���ǰ����в������
        for (int i=1;i<arr.length;i++){

            for (int j = i; j >0 ; j--) {

                if (arr[j]<arr[j-1]){//���н���Ԫ��

                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }

            }
        }
    }
    /**
     * ��������2.0�汾
     * @param arr
     */
    public static void insertSortO2(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int temp=arr[i];
            int j;
            for (j=i; j >0 ; j--) {
                if (temp<arr[j-1]){//�����ƶ�Ԫ��
                    arr[j]=arr[j-1];
                }else{
                    break;
                }
            }
            arr[j]=temp;
        }
    }
    /**
     * �������� 3.0�汾��ϣ������--����������Ż���
     *
     *���ȶ�����
     * @param arr
     */
    public static void shellSort(int[] arr){

        int n=arr.length;
        int h=1;
        while (h<n/3){
            h=3*h+1;
        }

        while (h>=1){


            for (int i = 0; i <arr.length ; i++) {

                for (int j = i; j >=h; j=j-h) {

                     if (arr[j]<arr[j-h]){

                         int temp=arr[j];
                         arr[j]=arr[j-h];
                         arr[j-h]=temp;
                     }else{

                         break;
                     }

                }

            }




            h=h/3;
        }




    }
    /**
     * ð������1.0�汾
     * �ȶ�����
     * @param arr
     */
    public static void bubbleSort01(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if (arr[j]>arr[j+1]){//���н���Ԫ��
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }

        }

    }
    /**
     * ð������2.0
     * �ȶ�����
     * @param arr
     */
    public static void bubbleSort02(int[] arr){

        //�����Ż��ķ�ʽ:����
        int index=arr.length-1;//������־�ڲ�ѭ��
        int last=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            //��һ���Ż�-����һ����־����
            boolean flag=true;
            for (int j = 0; j <index; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;//�Ż�һ
                    last=j;//�Ż���
                }
            }
            index=last;
            if (flag){//����û�н�����Ԫ��--Ԫ��ȫ������ �����ٴν���ѭ������
                break;
            }
        }
    }
    /**
     * ��������
     * ���ȶ������㷨
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr,int lo,int hi){

        if (arr==null||arr.length==1) return ;
        if (lo>=hi) return ;//�ݹ��������
        //���з���
        int pivot=arr[hi];
        int left=lo;
        int right=hi;
        int i=left;//����Ԫ��ʹ��
        while (i<=right){//���н���Ԫ�ص�����
            if (arr[i]<pivot){
                //���н���Ԫ��
                int temp=arr[left];
                arr[left]=arr[i];
                arr[i]=temp;
                i++;
                left++;
            }else  if (arr[i]>pivot){
                int temp=arr[right];
                arr[right]=arr[i];
                arr[i]=temp;
                right--;
            }else{
                i++;
            }
        }
        //���ֽ���
        quickSort(arr, lo, left-1);
        quickSort(arr, right+1, hi);
    }
    /**
     * �鲢����
     * �ȶ�����
     * @param arr
     */
    public static void mergeSort(int[] arr,int startIndex,int endIndex){
        if (arr==null||arr.length==1) return;
        if (startIndex==endIndex) return;
        int mid=startIndex+(endIndex-startIndex)/2;
        //�������߽�������
        mergeSort(arr,startIndex,mid);
        mergeSort(arr, mid+1, endIndex);
        merge(arr,startIndex,mid,endIndex);//�ϲ�����
    }
    /**
     * �鲢����
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr,int left,int mid,int right){
        int p1=left;
        int p2=mid+1;
        int index=0;//����������±�
        int[] copyArr=new int[right-left+1];//����һ����������
        while (p1<=mid&&p2<=right){
            copyArr[index++]=arr[p1]<=arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            copyArr[index++]=arr[p1++];
        }
        while (p2<=right){
            copyArr[index++]=arr[p2++];
        }
        //��ԭ������и�ֵ
        for (int i = 0; i < copyArr.length; i++) {
            arr[left+i]=copyArr[i];
        }

    }


}