package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/2-11:38 下午
 */
public class _74_SearchMatrix {

    /**
     * 思路:想办法将二维数组转换成一纬数据,方便使用二分发-提高时间复杂度，这里非常重要的一点就是 得到 mid/n 等于在二维数组中的行的位置
     * mid%n 等于在二维数组中的的位置--其中n为 二维数组的列的长度
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int m=matrix.length;
        int n=matrix[0].length;
        int sum=m*n;//数据的总长度
        int left=0;
        int right=sum-1;

        while (left<right){

            int mid=left+(right-left)/2;

            int num=matrix[mid/n][mid%n];

            if (num<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }

        return matrix[left/n][left%n]==target;


    }
}