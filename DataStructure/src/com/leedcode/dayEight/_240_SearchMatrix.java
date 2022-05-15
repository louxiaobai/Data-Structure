package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/4-10:13 上午
 */
    public class _240_SearchMatrix {


    /**
     * 思路:因为此个二维数组并不是连续有序的所以不能采用 74题那种方法
     * 因为这个最大值一定在没行的最右边,所以可以先从每行的最有一个进行比较
     * 如果target>当前行的最后一个值说明 和target相等的数一定在下面的列此时需要m++
     * 如果target<当前值说明可能在这一行 只需要n--来进行寻找,taget>当前值
     * 时间复杂度:O(m+n)
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 空间复杂度:O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {


        int m=0;

        int n=matrix[0].length-1;

        while (m<matrix.length&&n>=0){


            if (matrix[m][n]==target){

                return true;

            }else if (matrix[m][n]>target){//说明 如果存在此target一定在这一列

                n--;

            }else{//说target一定不在本列在下一列

                m++;

            }

        }

        return false;

    }

    /**
     *暴力解法:挨个进行遍历--不能使用
     *时间复杂度:O(n*m)
     *空间复杂度:O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {

        int m=matrix.length-1;

        int n=matrix[0].length-1;

        for (int i = 0; i <=m; i++) {

            for (int j = 0; j <=n ; j++) {

                if (matrix[i][j]==target) return true;

            }

        }

        return false;


    }



}