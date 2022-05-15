package com.line.linkedlist;

/**
 * @author lqw
 * @date 2021/9/18-11:53 上午
 */
public class LinkedList<E> {


    private  class Node<E> {//私有内部类

        E e;
        Node next;

        public Node(E e, Node next) {

            this.e = e;
            this.next = next;

        }

        public Node(E e) {


            this(e, null);

        }

        public Node() {


            this(null, null);

        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node dummyHead;//头节点
    private int size;//定义长度

    public  LinkedList(){

         dummyHead=new Node();
         size=0;
    }


    public  int getSize(){

        return size;
    }

    public  boolean isEmpty(){

        return  size==0;
    }

    /**
     * 查询指定节点索引的值
     * @param index
     * @return
     */
    public E get(int index){

        //检查index的合法性

        if (index<0||index>=size){

            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }

       Node curr=dummyHead.next;

        for (int i = 0; i<index; i++) {

            curr=curr.next;

        }

        return (E) curr.e;
    }

    /**
     * 查询第一个索引
     * @return
     */
    public E getFirst(){

        return  get(0);

    }

    /**
     * 查询最后一个节点的值
     * @return
     */
    public  E getLast(){


        return get(size-1);

    }

    /**
     * 修改元素节点的值
     * @param index
     * @param e
     */

    public void  set(int index,E e){

        //检查index的合法性
        if (index<0||index>=size){

            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }

        Node curr=dummyHead;

        for (int i = 0; i<index; i++) {

            curr=curr.next;

        }
        curr.e=e;

    }

    /**
     * 在链表表头新增节点
     * @param e
     */
    public void addFirst(E e){

        //Node newNode=new Node(e);
        //newNode.next=head;
        //head=newNode;
        //head=new Node(e,head);
        //size++;
        add(0, e);
    }

    /**
     * 在链表某位插入一个元素
     * @param e
     */
    public void addLast(E e){

        add(size,e);

    }

    /**
     * 在链表中间插入一个元素
     * @param index
     * @param e
     */
    public  void add(int index,E e){

        //检查index的合法性

        if (index<0||index>size){

            throw new IllegalArgumentException("get failed, index must>0 and <=size");

        }

        //找到要插入位置的前一个节点

        Node prev=dummyHead;

        for (int i = 0; i <index ; i++) {

            prev=prev.next;

        }
        //进行修改链表的指向

        //Node newNode=new Node(e);

        //newNode.next=prev.next;

        //prev.next=newNode;

        //简洁写法

        prev.next= new  Node(e,prev.next);

        size++;

    }

    /**
     * 删除头节点
     * @return
     */
    public  E removeFirst(){

            return remove(0);
    }

    /**
     * 删除最后一个节点
     * @return
     */
    public E removeLast(){

        return remove(size-1);

    }

    /**
     * 删除中间节点
     * @param index
     * @return
     */
    public E remove(int index){

        //检查index的合法性

        if (index<0||index>=size){

            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }
        Node preNode=dummyHead;
        for (int i = 0; i <index; i++) {//找到要删除节点的前一个节点

            preNode=preNode.next;
        }

        Node delNode=preNode.next;

        preNode.next=delNode.next;

        delNode.next=null;

        size--;

        return (E) delNode.e;//返回要删除节点的值

    }

    /**
     * 判断链表是否包含指定的元素
     * @param e
     * @return
     */
    public boolean contains(E e){

            Node curr=dummyHead.next;

            while (curr!=null){

                 if (curr.e.equals(e)) return true;

                 curr=curr.next;
            }
            return false;

    }

    /**
     * 删除指定的元素
     * @param e
     */
    public void removeElement(E e){

        if (dummyHead.next==null) throw new IllegalArgumentException("链表为空,删除失败");

        Node prev=dummyHead;
        Node curr=dummyHead.next;
        while (curr!=null){


            if (curr.e.equals(e)){

                break;

            }

            prev=curr;

            curr=curr.next;
        }
        prev.next=curr.next;
        curr.next=null;

    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder();

        Node curr=dummyHead.next;
        while (curr!=null){

            sb.append(curr+"=>");
            curr=curr.next;
        }

        sb.append("null");

        return sb.toString();

    }
}