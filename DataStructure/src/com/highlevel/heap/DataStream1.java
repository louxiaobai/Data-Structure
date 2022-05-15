package com.highlevel.heap;

/**
 * @author lqw
 * @date 2022/1/14-10:18 上午
 */
public class DataStream1 {

    public class Node{

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node dummyNode;
    public DataStream1(Node dummyNode) {
        this.dummyNode = dummyNode;
    }
    public DataStream1() {
    }
    public void add(int val){

//       找到第一个比val小的节点
        Node prev=dummyNode;
        Node curr = dummyNode.next;

        while (curr!=null){

            if (curr.val<val){
                break;
            }

            prev=curr;

            curr=curr.next;

        }

//        将元素添加到第一个比他小的节点的前面
        Node newNode = new Node(val);

        newNode.next=curr;

        prev.next=newNode;

    }

//    O (1)
    public int removeMax(){

        if (dummyNode.next==null){

            throw new RuntimeException("removceMax 失败,因为数据流中没有元素");

        }

//        保存需要返回的最大值
        int res = dummyNode.next.val;

        Node head=dummyNode.next;

        dummyNode.next=head.next;

        head.next=null;

        return res;
    }
}