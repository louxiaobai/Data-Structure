package com.leedcode.dayThree;

/**
 * @author lqw
 * @date 2022/2/19-8:15 下午
 */
public class _498_FindDiagonalOrder {


    public static void main(String[] args) {

        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};

        findDiagonalOrder(arr);

    }

    /**
     * 思路:从下往上走 row-1,col+1;从上往下走 row+1,col-1
     * 处理边界:当 row<o  ->row=0 改变方向
     * 处理边界:当 col<0  ->col 改变方向
     * 处理边界:当 row>=m ->row=m-1，col=col-2 改变方向
     * 处理边界:当 col>=n ->col=n-1, row=row-2 改变方向
     * 特别注意:需要先进行处理 row>=m 和 col>=n的情况
     * 时间复杂度:O(m*n)
     * 空间复杂度O(1)
     * @param mat
     * @return
     */
    public static int[] findDiagonalOrder(int[][] mat) {


        if (mat.length==0) return new int[0];
        int m=mat.length;
        int n=mat[0].length;
        int[] res=new int[m*n];//存储遍历过的数组
        int[][] direction = {{-1, 1}, {1, -1}};//定义一个改变方向的数组[0][0]代表从下往上走,[0][1]代表从下往上走
        int row=0;
        int col=0;
        int di=0;//进行换方向操作
        for (int i = 0; i < m*n; i++) {

            res[i]=mat[row][col];//进行存储
            row=row+direction[di][0];
            col=col+direction[di][1];
            //进行判断边界
            //1.行超出边界
            if (row>=m){ row=m-1;col=col+2;di=1-di;}
            //2。列超出边界
            if (col>=n){ row=row+2;col=n-1;di=1-di;}
            //3.行小于0
            if (row<0){row=0;di=1-di; }
            //4.列小于0
            if (col<0){ col=0;di=1-di; }
        }
    return res;
    }
}