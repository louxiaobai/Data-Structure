package com.tree.Test;


import com.line.stack.Stack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/1/2-10:21 下午
 */
public class Root {


    public static void main(String[] args) {


        TreeNode<Integer> root = new TreeNode<>(23);
        TreeNode<Integer> node1 = new TreeNode<>(34);
        TreeNode<Integer> node2 = new TreeNode<>(21);
        TreeNode<Integer> node3 = new TreeNode<>(99);
        TreeNode<Integer> node4 = new TreeNode<>(77);
        TreeNode<Integer> node5 = new TreeNode<>(90);
        TreeNode<Integer> node6 = new TreeNode<>(45);
        TreeNode<Integer> node7 = new TreeNode<>(60);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node3.right=node5;
        node3.left=node4;
        node2.left=node6;
        node2.right=node7;


        System.out.println(minRoute(root,34));

    }


    /**
     * 判定根节点到目标节点是否有路径--前序遍历
      * @param root
     * @param target
     * @return
     */
   public static boolean isHave(TreeNode<Integer> root,Integer target){


       //创建一个栈用来存储节点信息
       ArrayDeque<TreeNode<Integer>> stack=new ArrayDeque<>();

       stack.push(root);

       while (!stack.isEmpty()){


           TreeNode<Integer> curr = stack.pop();

           if (curr.data==target){

               return true;
           }

           //进行存储右子树

           if (curr.right!=null) stack.push(curr.right);
           //进行存储左子树
           if (curr.left!=null) stack.push(curr.left);

       }
       return false;


   }

    /**
     * 判定根节点到目标节点是否有路径--中序遍历
     * @param root
     * @param target
     * @return
     */
    public static boolean isHave2(TreeNode<Integer> root,Integer target){


        if (root==null) return false;
        //创建一个栈进行存储节点信息
        ArrayDeque<TreeNode<Integer>> stack=new ArrayDeque<>();

        TreeNode<Integer> curr=root;

        while (curr!=null||!stack.isEmpty()){

            //先进行存储左子树的节点
            while (curr!=null){
                if (curr.data==target) return true;
                stack.push(curr);
                curr=curr.left;
            }
            TreeNode<Integer> node = stack.pop();
            if (node.data==target) return true;
            curr=node.right;
        }
        return false;
    }


    /**
     * 找出二叉树根节点root到目标节点target的最短路径--层序遍历
     * @param root
     * @param target
     * @return
     */
    public static int minRoute(TreeNode<Integer>root,Integer target){

        if (root==null) return -1;
        //创建一个队列进行存储树的节点信息
        Queue<TreeNode<Integer>> qeue = new LinkedList<>();
        qeue.offer(root);

        if (root.data==target) return 0;

        int route=1;

        while (!qeue.isEmpty()){

            //得到改层的节点的数目
            int size=qeue.size();

            for (int i=0;i<size;i++){
                TreeNode<Integer> curr = qeue.poll();
                //将遍历处理的节点的左右子节点入队,等待后续的处理
                if (curr.left!=null){
                    if (curr.left.data==target) return route;
                    qeue.offer(curr.left);
                }
                if (curr.right!=null) {
                    if (curr.right.data==target) return route;
                    qeue.offer(curr.right);
                }
                route++;
            }
        }
        return -1;
    }



}