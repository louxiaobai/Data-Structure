package com.line.quequ;


import java.lang.Object;

/**循环队列额
 * @author lqw
 * @date 2021/9/23-7:25 下午
 */
public class LoopQueue<E> implements Quequ<E> {

    private E[] data;//定义一个静态指针
    private int head;//队首指针
    private int tail;//队尾指针的下一个为空的元素
    private int size;


    public LoopQueue(int capacity){

        data=(E[])new Object[capacity];

        head=tail=0;

        size=0;



    }

    /**
     * 获取当前队列的容量
     * @return
     */
    public int getCapacity(){

        return data.length-1;

    }

    public void resize(int capacity){

        capacity=capacity+1;

        E[] newData=(E[]) new Object[capacity];

        for (int i = 0; i <size ; i++) {

            newData[i]=data[(i+head)%data.length];

        }

        data=newData;
        head=0;
        tail=size;




    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public void enqueue(E e) {

        //牺牲一个空间 不去存值用来判断 队列是否满了
        if ((tail+1)%data.length==head){

            //对列满了

            resize(getCapacity()*2);

        }

        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }



    @Override
    public E dequeue() {

        if (isEmpty()){

            throw  new RuntimeException("dequeue error,No Element for dequeue");

        }

        E res=data[head];

        data[head]=null;

        head=(head+1)%data.length;

        size--;

        if (size==getCapacity()/4){

            resize(getCapacity()/2);

        }

        return res;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder();

        sb.append(String.format("Queue:size=%d,capacity=%d\n", size,getCapacity()));

        sb.append("队首:[");

        for (int i = head; i !=tail; i=(i+1)%data.length) {


            sb.append(data[i]);

            if ((i+1)%data.length!=tail){

                sb.append(",");
            }


        }
        sb.append("]");


        return sb.toString();




    }
}