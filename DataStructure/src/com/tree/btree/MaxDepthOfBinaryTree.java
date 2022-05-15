package com.tree.btree;

import java.util.*;

/**
 * @author lqw
 * @date 2022/1/2-11:07 上午
 */
public class MaxDepthOfBinaryTree {

    //定义一个私有类

     private class Node{

         int depth;
         TreeNode<Integer> node;

         public Node(int depth, TreeNode<Integer> node) {
             this.depth = depth;
             this.node = node;
         }
     }

    /**
     * 使用前序遍历进行计算出树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode<Integer> root){



        if (root==null) return 0;

        int maxDepth=0;

        //创建一个栈进行存储信息
        ArrayDeque<Node> stack = new ArrayDeque<>();



        stack.push( new Node(1, root));

        while (!stack.isEmpty()){

            Node currNode = stack.pop();

            TreeNode<Integer> node=currNode.node;

            maxDepth= Math.max(maxDepth, currNode.depth);//取出较大值

            if (root.right!=null){

                stack.push( new Node(maxDepth+1, node.right));
            }
            if (root.left!=null){

                stack.push(new Node(maxDepth+1, node.left));
            }


        }

        return maxDepth;


    }

    /**
     * 使用层序遍历得到树的最大深度(BFS)
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode<Integer> root){


        int level=0;

        if (root==null) return 0;

        //创建一个队列
        Queue<TreeNode<Integer>> qeue = new LinkedList<>();
        qeue.offer(root);

        while (!qeue.isEmpty()){

            int size=qeue.size();//得到该层树的数目

            for (int i=0;i<size;i++){

                TreeNode<Integer> curr = qeue.poll();
                //将遍历处理的节点的左右子节点入队,等待后续的处理
                if (curr.left!=null) qeue.offer(curr.left);
                if (curr.right!=null) qeue.offer(curr.right);

            }

            level++;

        }
        return level;


    }

    /**
     * 递归实现 求树的最大深度(DFS)
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root){

        if (root==null) return 0;

        int leftMaxDepth=maxDepth3(root.left);
        int rightMaxDepth=maxDepth3(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth);

    }

}