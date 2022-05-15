package com.line.linkedlist;

/**
 * @author lqw
 * @date 2021/9/18-4:15 ÏÂÎç
 */
public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        linkedList.addLast(5);
        linkedList.addFirst(10);
        linkedList.add(2,20);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);



    }
}