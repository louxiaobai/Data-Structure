package com.leedcode.bs;

/**ɽ�������в���Ŀ��ֵ--leedcode 1095
 * @author lqw
 * @date 2021/10/20-8:56 ����
 */
public class FindInMountainArray {

    public static void main(String[] args) {

        int[] mountainArr={0,5,3,1};

        System.out.println(findInMountainArray(1,mountainArr));

    }

    public static int findInMountainArray(int target, int[] mountainArr) {


        //1.�Ƚ��ж��ֲ����ҵ���ֵ

        int peakIndex=FindPeakIndex(mountainArr);

        //��ȥ�ҷ�ֵ���--���Ƿ���Ŀ��ֵ

        int leftIndex=FindLeftIndex(mountainArr,0,peakIndex,target);

        if (leftIndex!=-1){

            return leftIndex;
        }

        int rightIndex=FindRightIndex(mountainArr,peakIndex+1,mountainArr.length-1,target);

        if (rightIndex!=-1){

            return rightIndex;
        }

        return -1;
}

    public static int FindRightIndex(int[] mountainArr, int left, int right, int target) {

        while (left<=right){

            int mid=left+(right-left)/2;

            if (mountainArr[mid]==target){

                return mid;
            }else  if (mountainArr[mid]<target){

                  right=mid-1;
            }else {

                left=mid+1;
            }

        }

        return -1;

    }

    public static int FindLeftIndex(int[] mountainArr, int i, int peakIndex, int target) {

            int left=i;
            int right=peakIndex;

            while (left<=right){

                int mid=left+(right-left)/2;

                if (mountainArr[mid]==target){

                    return mid;

                }else  if (mountainArr[mid]<target){

                        left=mid+1;

                }else {

                    right=mid-1;
                }

            }

        return  -1;
    }

    public static int FindPeakIndex(int[] mountainArr) {

        int left=0;
        int right=mountainArr.length-1;
        int mid=0;
        while (left<=right){

            mid=left+(right-left)/2;

            if (mountainArr[mid]>mountainArr[mid+1]&&mountainArr[mid]>mountainArr[mid-1]){

                return  mid;//�õ���ֵ���±�

            }else if (mountainArr[mid]<mountainArr[mid+1]){

                left=mid+1;

            }else {

                right=mid;

            }

        }

        return mid;

    }

}

