package com.leedcode.dayTen;

import java.util.ArrayDeque;

/**
 * @author lqw
 * @date 2022/4/11-12:10 上午
 */
public class _394_DecodeStringOffer {

    public static void main(String[] args) {
        String s="3[a]2[bc]";

        System.out.println(decodeString(s));
    }

    /**
     * 双栈解法:创建一个 数字栈(用于存储数字1-300) 一个 字符栈，创建一个StringBuilder方便用来存储和操作字符串
     * 对字符进行遍历--碰见数字进行 num=num*10+(c-'0') 碰见 [  执行入栈操作 将数字 存储 将字符串存入,并且将 字符串
     * 进行置空, 碰见]则说明需要执行重复操作,同时将 字符串栈的第一位进行拼接
     * 时间复杂度:O(n)
     * 时间复杂度:O(n)
     * @param s
     * @return
     */
    public static String decodeString(String s) {

        int num=0;//存储在遍历过程中出现的数字

        StringBuilder sb=new StringBuilder();//字符串的拼接

        ArrayDeque<Integer> numStack=new ArrayDeque<>();//存储数字的栈

        ArrayDeque<String> strStack=new ArrayDeque<>();//存储字符串的栈


        for(char c:s.toCharArray()){//进行字符串的遍历

            if (c>='0'&&c<='9'){

                num=num*10+(c-'0');//因为整数的取值范围位0-300
            }else if (c=='['){//如果碰到[需要将字符串和数字执行入栈操作

                String str=sb.toString();
                numStack.push(num);
                strStack.push(str);
                num=0;//将数字清除为0

                sb.delete(0, sb.length());//将字符串拼接也进行删除

            }else if (c==']'){//将字符串执行拼接操作

                String str=sb.toString();

                int count=numStack.pop();

                //从1开始 是因为本来就有一个了
                for (int i = 1; i < count; i++) {
                    sb.append(str);
                }
                //将字符串的栈顶元素进行插入到最前面,这个完整的字符串才是下次需要进行拼接的

                sb.insert(0, strStack.pop());

            }else {

                sb.append(c);
            }
        }

        return sb.toString();

    }


}