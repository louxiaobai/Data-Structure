package com.leedcode.daySeventeen;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/15-1:52 下午
 */
public class _662_WidthOfBinaryTree {


    class Node{


        TreeNode treeNode;
        int index;

        Node(TreeNode treeNode,int index){

            this.treeNode=treeNode;
            this.index=index;
        }


    }


    /**
     * 层次遍历
     * 它是以最右 为基准
     * 解题方法:给每个节点进行标记下表
     * 难点:要想到如何 自己定义一个节点,进行存储 节点 和当前节点的下标
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {

        if (root==null) return 0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(root, 1));
        int res=0;
        while (!queue.isEmpty()){

            int size = queue.size();
            //记录每层的最大宽度
            int left=0,right=0;
            for (int i = 0; i < size; i++) {

                Node curr = queue.poll();

                int index=curr.index;

                if (i==0) left=curr.index;

                if (i==size-1) right=curr.index;

                if (curr.treeNode.left!=null) queue.offer(new Node(curr.treeNode.left,index*2));

                if (curr.treeNode.right!=null) queue.offer(new Node(curr.treeNode.right, index*2+1));


            }

            //进行记录每层的最大宽度

            res=Math.max(res, right-left+1);

        }

        return res;
    }



}