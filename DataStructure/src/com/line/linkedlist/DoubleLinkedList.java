package com.line.linkedlist;

import sun.jvm.hotspot.debugger.win32.coff.DebugVC50TypeLeafIndices;

import javax.xml.bind.Binder;
import java.util.NoSuchElementException;

/**
 * @author lqw
 * @date 2021/9/19-9:26 ����
 */
public class DoubleLinkedList<E> {

    private  class Node<E> {//˽���ڲ���

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
     * ��ѯָ��������ֵ
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
     * ��������ĵ�һ���ڵ�
     * @return
     */
    public  Node getFirst(){

        return  first;

    }

    /**
     * ������������һ���ڵ�
     * @return
     */
    public Node getLast(){


        return  last;

    }

    /**
     * ���ҵ�ָ�������Ľڵ�
     * @param index
     * @return
     */
    private Node node(int index){

        if (index<0||index>=size){

            return null;
        }

        if (index<size/2){//���indexС�������һ������д�ǰ�������

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
     * ���ͷ����һ���ڵ�
     * @param e
     */
    public void addFirst(E e){

        Node newNode=new Node(e);//����һ���µĽڵ�

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
     * ���β����һ���½ڵ�
     * @param e
     */
    public  void addLast(E e){

        Node newNode=new Node(e);//����һ���½ڵ�
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
     * ����в���һ���½ڵ�
     * @param e
     */
    public void add(int index,E e){

        //���index�ĺϷ���

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

            //����һ���½ڵ�

            Node newNode=new Node(prev,e,oldNode);

            oldNode.prev=newNode;

            prev.next=newNode;

            size++;
        }

    }


    /**
     * ɾ��ͷ�ڵ�
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
     * ɾ��β�ڵ�
     * @return
     */
    public E removeLast(){

        if (last==null){

            throw  new NoSuchElementException();

        }

        E e=(E)last.e;

        Node prev=last.prev;

        if (prev==null){//˵����ʱ����ֻ��һ���ڵ�
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
     * ɾ��������м�ڵ�
     * @param index
     * @return
     */
    public E remove(int index){

        //���index�ĺϷ���

        if (index<0||index>=size){

            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }

        if (index==0){//ɾ���Ƕ�ͷ�ڵ�

           return removeFirst();

        }else if (index==size-1){//ɾ������ĩβ�ڵ�

            return removeLast();
        }

        Node delNode=node(index);//�ҵ�Ҫɾ���Ľڵ�

        //�ҵ�Ҫɾ���ڵ��ǰ��ڵ�
        Node prev=delNode.prev;
        Node next= delNode.next;

        //��ɾ���ڵ��ǰ��ڵ������������
        prev.next=next;
        next.prev=prev;

        //ɾ��ָ���ڵ�
        delNode.next=null;
        delNode.prev=null;

        size--;
        return (E) delNode.e;







    }

}