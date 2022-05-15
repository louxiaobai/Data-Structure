package com.highlevel.heap;

/**
 * @author lqw
 * @date 2022/1/14-10:18 上午
 */
public class DataStream {

    public class Node{

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node dummyNode;
    public DataStream(Node dummyNode) {
        this.dummyNode = dummyNode;
    }
    public DataStream() {
    }
    public void add(int val){

        Node newNode = new Node(val);
        newNode.next=dummyNode.next;
        dummyNode.next=newNode;

    }

    public int removeMax(){

        if (dummyNode.next==null){

            throw new RuntimeException("removceMax 失败,因为数据流中没有元素");

        }
        //找到最大值节点的前一个节点
        Node curr=dummyNode.next;

        Node maxValueNode=curr;

        while (curr!=null){

            if (curr.val>maxValueNode.val){

                maxValueNode=curr;
            }
            curr=curr.next;

        }

        //找到最大值的节点的前一个节点
        curr=dummyNode.next;
        Node maxValueNodePrev=dummyNode;
        while(curr!=null){

            if (curr==maxValueNode){
                break;
            }

            maxValueNodePrev=curr;
            curr=curr.next;

        }
        //进行删除最大值节点
        maxValueNodePrev.next=maxValueNode.next;
        maxValueNode.next=null;
        return maxValueNode.val;

    }
}