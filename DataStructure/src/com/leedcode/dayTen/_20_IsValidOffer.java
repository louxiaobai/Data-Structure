package com.leedcode.dayTen;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lqw
 * @date 2022/4/10-11:26 上午
 */
public class _20_IsValidOffer {


    public static void main(String[] args) {

        String s="()";

        System.out.println(isValid1(s));



    }

    /**
     * 使用hash表维护左右括号,这样方便增加多种符号
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {

        if (s.length()%2==1) return false;

        //使用hash表存储映射关系
        Map<Character,Character> map=new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        //创建一个栈进行弹入和弹出

        ArrayDeque<Character> stack=new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (map.containsKey(c)){//如果map中包含这个键则进行入栈


                stack.push(c);

            }else {
                //进行判断栈是否为空,为空则之间返回false
                if (stack.isEmpty()) return false;
                //进行出栈操作
                Character pop = stack.pop();
                if (c!=map.get(pop)) return false;

            }
        }

        return stack.isEmpty();

    }

    /**
     * 思路:使用栈进行操作:遇到( { [ 入栈 遇到)} ] 出栈,出栈的时候 需要看 是否匹配,在出栈之前 需要判断
     * 栈是否为空,如果为空则一定是不能匹配的.
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        //进行特判断
        if(s.length()==0||s.length()==1) return false;


        //创建一个栈用来存储 符号

        Stack<Character> stack=new Stack<>();


        for (char c : s.toCharArray()) {

            if (c=='('||c=='{'||c=='[') stack.push(c);//入栈操作
            if (c==')'||c=='}'||c==']'){
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();//出栈操作
                if (c==')'&&pop!='(') return false;
                if (c=='}'&&pop!='{') return false;
                if (c==']'&&pop!='[') return false;
            }

        }
        return stack.isEmpty();


    }


}