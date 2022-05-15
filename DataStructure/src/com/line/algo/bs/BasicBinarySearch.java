package com.line.algo.bs;

/**�����汾�Ķ��ֲ���
 * @author lqw
 * @date 2021/10/10-9:39 ����
 */
public class BasicBinarySearch {

    public static void main(String[] args) {
        int[] data={5,3,1};
        System.out.println(contain02(data, 0,data.length-1,1));
    }
    /**
     * ʵ�ֻ����Ķ��ֲ���--������
     * @param data
     * @param target
     * @return
     */
    public static boolean contain(int[] data,int target){

        if (data==null||data.length==0) return false;
        int left=0;
        int right=data.length-1;
        while (left<=right){//���в��ҵ�����
            //int mid=(left+right)/2;//����ȡ�м�ֵ���ܻ����--��Ϊ��������м�ֵ�ķ���
            int mid=left+((right-left)>>1);//λ��������ȼ��ϵ�---ȡ���

            if (target==data[mid]){//�ҵ�Ԫ�ط���true
                return true;
            }else  if (target<data[mid]){//�м�Ԫ�ر�Ŀ��Ԫ�ش� ����һ�ε������ռ�Ϊ[left....mid-1]
                right=mid-1;
            }else{//�м�Ԫ�ر�Ŀ��Ԫ��С ����һ�ε������ռ�Ϊ[mind+1.....right]
                left=mid+1;
            }
        }
        return false;
    }


    /**
     * ʵ�ֻ����Ķ��ֲ���--�ݹ�
     * @param data
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static boolean contain02(int[] data,int left,int right,int target){

        if (left>right)  return false;//�ݹ��������

        int mid=left+(right-left)/2;
        if (data[mid]==target){

            return true;

        } else if (data[mid]>target){


            return contain02(data, left, mid-1, target);

        }else{

            return contain02(data, mid+1, right, target);

        }

    }
}