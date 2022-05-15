package com.line.linkedlist;

import sun.jvm.hotspot.debugger.win32.coff.DebugVC50TypeLeafIndices;

import javax.xml.bind.Binder;
import java.util.NoSuchElementException;

/**
 * @author lqw
 * @date 2021/9/19-9:26 上午
 */
public class DoubleLinkedList<E> {

    private  class Node<E> {//私有内部类

        E e;
        Node next;
        Node prev;

        public Node( Node prev,E e,Node next) {

            this.e = e;
            this.next = next;
            this.prev=prev;

        }

        public  Node(E e){

            this(null,e,null);

        }


        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node first;

    private Node last;

    private int size;

    public  DoubleLinkedList(){

        first=last=null;

        size=0;

    }
    public int getSize(){

        return  size;

    }

    public  boolean isEmpty(){

        return size==0;

    }

    /**
     * 查询指定索引的值
     * @param index
     * @return
     */

    public  E get(int index){

        Node node=node(index);

        if (node==null){
            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }else{

            return (E)node.e;
        }

    }
    /**
     * 返回链表的第一个节点
     * @return
     */
    public  Node getFirst(){

        return  first;

    }

    /**
     * 返回链表的最后一个节点
     * @return
     */
    public Node getLast(){


        return  last;

    }

    /**
     * 查找到指定索引的节点
     * @param index
     * @return
     */
    private Node node(int index){

        if (index<0||index>=size){

            return null;
        }

        if (index<size/2){//如果index小于链表的一半则进行从前往后查找

            Node curr=first;
            for (int i = 0; i <index ; i++) {

                curr=curr.next;

            }

            return curr;

        }else {

            Node curr=last;

            for (int i = 0; i <size-index-1 ; i++) {

                curr=curr.prev;

            }

            return curr;

        }
    }

    /**
     * 向表头插入一个节点
     * @param e
     */
    public void addFirst(E e){

        Node newNode=new Node(e);//创建一个新的节点

        if (first==null){

            last=newNode;


        }else{

            newNode.next=first;
            first.prev=newNode;

        }

        first=newNode;
        size++;

    }

    /**
     * 向表尾插入一个新节点
     * @param e
     */
    public  void addLast(E e){

        Node newNode=new Node(e);//创建一个新节点
        if (last==null){

             first=newNode;
        }else{

             newNode.prev=last;
             last.next=newNode;
        }

        last=newNode;

        size++;
    }

    /**
     * 向表中插入一个新节点
     * @param e
     */
    public void add(int index,E e){

        //检查index的合法性

        if (index<0||index>=size){

            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }

        if (index==0){

            addFirst(e);
        }else if(index==size){

            addLast(e);
        }else{


            Node oldNode=node(index);

            Node prev=oldNode.prev;

            //创建一个新节点

            Node newNode=new Node(prev,e,oldNode);

            oldNode.prev=newNode;

            prev.next=newNode;

            size++;
        }

    }


    /**
     * 删除头节点
     * @return
     */
    public E removeFirst(){

        if (first==null){


            throw  new NoSuchElementException();

        }
        E e=(E)first.e;

        Node next=first.next;

        if (next==null){

            first=null;
            last=null;

        }else{

            first.next=null;

            next.prev=null;

            first=next;
        }

        size--;

        return e;

    }

    /**
     * 删除尾节点
     * @return
     */
    public E removeLast(){

        if (last==null){

            throw  new NoSuchElementException();

        }

        E e=(E)last.e;

        Node prev=last.prev;

        if (prev==null){//说明此时链表只有一个节点
            last=null;
            first=null;
        }else{


            last.prev=null;
            prev.next=null;

            last=prev;

        }

        size--;
        return e;



    }


    /**
     * 删除链表的中间节点
     * @param index
     * @return
     */
    public E remove(int index){

        //检查index的合法性

        if (index<0||index>=size){

            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }

        if (index==0){//删除是都头节点

           return removeFirst();

        }else if (index==size-1){//删除的是末尾节点

            return removeLast();
        }

        Node delNode=node(index);//找到要删除的节点

        //找到要删除节点的前后节点
        Node prev=delNode.prev;
        Node next= delNode.next;

        //将删除节点的前后节点进行连接起来
        prev.next=next;
        next.prev=prev;

        //删除指定节点
        delNode.next=null;
        delNode.prev=null;

        size--;
        return (E) delNode.e;







    }

}