package com.line.stack;

/**������
 * @author lqw
 * @date 2021/9/19-3:07 ����
 */
public class ArrayStackTest {

    public static void main(String[] args) {


        Stack<Integer> stack=new ArrayStack<Integer>(5);

        stack.push(10);
        System.out.println(stack);
        stack.push(20);
        System.out.println(stack);
        stack.push(30);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peak());

    }


}