package com.leedcode.dayThree;

import javax.sound.midi.SoundbankResource;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/2/16-10:10 上午
 */
public class _73_SetZeroes {

    /**
     * 不实用额外空间 原地修改数组
     *使用第一行第一列来存储为零的行和列
     * @param matrix
     */
    public  void setZeroes(int[][] matrix){


        int m=matrix.length;
        int n=matrix[0].length;

        boolean flagCol=false;
        boolean flagRow=false;


        for (int i = 0; i < m; i++) {

            if (matrix[i][0]==0){
                flagCol=true;
                break;
            }

        }

        for (int i = 0; i < n; i++) {

            if (matrix[0][i]==0){

                flagRow=true;
                break;

            }

        }


        //使用二维数组的第一行和第一列记录 其他行列出现0的情况
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }

        }
        //对出现行和列的下表置零操作
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }

            }

        }

        if (flagRow){

            for (int i = 0; i < n; i++) {

                matrix[0][i]=0;

            }


        }
        if (flagCol){

            for (int i = 0; i < m; i++) {

                matrix[i][0]=0;

            }
        }



    }

    /**
     * 使用额外空间求解
     *时间复杂度:O(M*N)
     *空间复杂度:O(M*N)
     * @param matrix
     */
    public  void setZeroes3(int[][] matrix) {


        int m=matrix.length;
        int n=matrix[0].length;

        int[][] res=new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                res[i][j]=matrix[i][j];

            }
        }


        for (int row = 0; row < m; row++) {

            for (int col = 0; col < n; col++) {

                if (matrix[row][col]==0){//将res的 row 行 和col 列都置为零

                    int resRowLow=row;
                    int resRowUp=row;
                    int resColRight=col;
                    int resColLeft=col;
                    while (resRowLow<m) res[resRowLow++][col]=0;//将所在的一列下方全部置为零
                    while (resRowUp>-1) res[resRowUp--][col]=0;//将所在一列上方全部置为零
                    while (resColRight<n) res[row][resColRight++]=0;//将所在的一行右方全部置为零
                    while (resColLeft>-1) res[row][resColLeft--]=0;//将所在的一行左方全部置为零

                }


            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                matrix[i][j]=res[i][j];

            }
        }



    }

    /**
     * 使用额外空间求解
     * @param matrix
     */
    public  void setZeroes2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];//用于存储置行为零的信息
        boolean[] col = new boolean[n];//用于存储置列为零的信息

        //进行遍历二维数组

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }


            }

        }
        //对二维数组进行置零操作


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (row[i]||col[j]){
                    matrix[i][j]=0;
                }

            }

        }



    }



}