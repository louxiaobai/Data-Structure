package com.leedcode.dayThree;

/**
 * @author lqw
 * @date 2022/2/14-10:39 上午
 */
public class _48_RotateaTop {

    //90度旋转矩阵的规律:
    //矩阵中的第row行第col列
    //旋转之后变为倒数第row列的第col行位置

    //情况一：顺时针转 90 度：先转置再左右镜像
    //1 2 3               7 4 1
    //4 5 6               8 5 2
    //7 8 9               9 6 3
    //情况二：顺时针转 180 度:先上下镜像，再左右镜像（先左右再上下也可）
    //1 2 3               9 8 7
    //4 5 6               6 5 4
    //7 8 9               3 2 1
    //情况三：顺时针转 270 度：先转置再上下镜像
    //1 2 3              3 6 9
    //4 5 6              2 5 8
    //7 8 9              1 4 7
    
    /**
     * 不实用额外空间,原地旋转数组
     * @param matrix
     */
    public void rotate(int[][] matrix){

        //旋转数组

        int n=matrix.length;

        //1.先对二维数组进行逆置
        for (int i = 0; i < n; i++) {
            for (int j = 0;i>j&& j <n ; j++) {//只对 对角线下方的元素进行逆置即可
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //2.然后对二维数组进行左右镜面反转

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n/2; j++) {

                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];

                matrix[i][n-j-1]=temp;

            }
            
        }


    }


    /**
     * 使用额外空间解决这个问题
     * 时间复杂度O(n^2)
     * 空间复杂度O(n^2)
     * @param matrix
     */
    public void rotate1(int[][] matrix) {

        //申请一个额外的二维数组

        int n=matrix.length;

        int[][] res=new int[n][n];


        for (int row = 0; row < n; row++) {

            for (int col=0; col <n ; col++) {

                res[col][n-row-1]=matrix[row][col];

            }
        }


        for (int i = 0; i <n ; i++) {

            for (int j = 0; j < n; j++) {

                matrix[i][j]=res[i][j];

            }

        }









    }


}