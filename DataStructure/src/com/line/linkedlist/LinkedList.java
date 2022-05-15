package com.line.linkedlist;

/**
 * @author lqw
 * @date 2021/9/18-11:53 ����
 */
public class LinkedList<E> {


    private  class Node<E> {//˽���ڲ���

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

    private Node dummyHead;//ͷ�ڵ�
    private int size;//���峤��

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
     * ��ѯָ���ڵ�������ֵ
     * @param index
     * @return
     */
    public E get(int index){

        //���index�ĺϷ���

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
     * ��ѯ��һ������
     * @return
     */
    public E getFirst(){

        return  get(0);

    }

    /**
     * ��ѯ���һ���ڵ��ֵ
     * @return
     */
    public  E getLast(){


        return get(size-1);

    }

    /**
     * �޸�Ԫ�ؽڵ��ֵ
     * @param index
     * @param e
     */

    public void  set(int index,E e){

        //���index�ĺϷ���
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
     * �������ͷ�����ڵ�
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
     * ������ĳλ����һ��Ԫ��
     * @param e
     */
    public void addLast(E e){

        add(size,e);

    }

    /**
     * �������м����һ��Ԫ��
     * @param index
     * @param e
     */
    public  void add(int index,E e){

        //���index�ĺϷ���

        if (index<0||index>size){

            throw new IllegalArgumentException("get failed, index must>0 and <=size");

        }

        //�ҵ�Ҫ����λ�õ�ǰһ���ڵ�

        Node prev=dummyHead;

        for (int i = 0; i <index ; i++) {

            prev=prev.next;

        }
        //�����޸������ָ��

        //Node newNode=new Node(e);

        //newNode.next=prev.next;

        //prev.next=newNode;

        //���д��

        prev.next= new  Node(e,prev.next);

        size++;

    }

    /**
     * ɾ��ͷ�ڵ�
     * @return
     */
    public  E removeFirst(){

            return remove(0);
    }

    /**
     * ɾ�����һ���ڵ�
     * @return
     */
    public E removeLast(){

        return remove(size-1);

    }

    /**
     * ɾ���м�ڵ�
     * @param index
     * @return
     */
    public E remove(int index){

        //���index�ĺϷ���

        if (index<0||index>=size){

            throw  new IllegalArgumentException("get failed, index must>0 and <=size");
        }
        Node preNode=dummyHead;
        for (int i = 0; i <index; i++) {//�ҵ�Ҫɾ���ڵ��ǰһ���ڵ�

            preNode=preNode.next;
        }

        Node delNode=preNode.next;

        preNode.next=delNode.next;

        delNode.next=null;

        size--;

        return (E) delNode.e;//����Ҫɾ���ڵ��ֵ

    }

    /**
     * �ж������Ƿ����ָ����Ԫ��
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
     * ɾ��ָ����Ԫ��
     * @param e
     */
    public void removeElement(E e){

        if (dummyHead.next==null) throw new IllegalArgumentException("����Ϊ��,ɾ��ʧ��");

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