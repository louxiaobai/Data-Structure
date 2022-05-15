package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/14-10:51 上午
 */
public class _1318_MinFlips {


    /**
     *思路:使用异或方法进行求解,如果a|b ^c> 的某一位是大于零的说明肯定要对 a或b进行反转--反转次数 具体分析
     * 时间复杂度:O(n)
     *空间复杂度:O(1)
     * 时间复杂度:O(n)
     * 空间复杂度O(1)
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int minFlips(int a, int b, int c){

        int aOrb=a|b;

        int equal=aOrb^c;

        if (equal==aOrb) return 0;
        int count=0;
        for (int i = 0; i <32; i++) {

            int mask=(1<<i);

            if ((equal&mask)>0){//如果异或的位置上的数字是1那么肯定需要进反反转


                if (((c&mask)==0)&&((a&mask)==(b&mask))){

                    count+=2;

                }else {

                    count++;
                }
            }
        }
        return count;
    }




    /**
     * 思路:先计算c上1的情况，然后在对 ab 的情况进行判断
     * 时间复杂度:O(n)
     * 空间复杂度O(n)
     * @param a
     * @param b
     * @param c
     * @return
     */

    public int minFlips1(int a, int b, int c) {

        //1.记录c32位上的零和1的情况

        int[] res=new int[32];

        for (int i = 0; i < 32; i++) {
            res[i]=(c>>i)&1;
        }

        // 遍历res 然后 记录对 a 和 b 的调整次数

        int count=0;

        for (int i = 0; i <res.length; i++) {
            int tem=res[i];//c的低位开始
            int resa=(a>>i)&1;
            int resb=(b>>i)&1;
            if (tem==1){
                count+=(resa==tem||resb==tem)?0:1;
            }else {
                if (resa==1&&resb==1){
                    count+=2;
                }else {
                    count+=(resa==tem&&resb==tem)?0:1;
                }
            }
        }
        return count;
    }
}