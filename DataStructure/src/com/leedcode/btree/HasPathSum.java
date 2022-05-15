package com.leedcode.btree;

import com.line.linkedlist.LinkedList;

import java.util.ArrayDeque;
import java.util.zip.Checksum;

/**
 * @author lqw
 * @date 2022/1/3-8:33 上午
 */
public class HasPathSum {

    //创建一个私有内部类
    private static class Node{
        TreeNode node;//当前树节点
        int pathSum;//从根节点到当前节点的路径和
        public Node(TreeNode node, int pathSum) {
            this.node = node;
            this.pathSum = pathSum;
        }
    }
    /**
     * leedcode-路径综合--迭代
     * @param root
     * @param targetSum
     */
    public static boolean hasPathSum(TreeNode root, int targetSum){

        if (root==null) return false;

        //创建一个栈用来存储节点信息

        ArrayDeque<Node> stack = new ArrayDeque<>();

        stack.push(new Node(root, root.val));

        while (!stack.isEmpty()){

            Node curr= stack.pop();

            //进行判断是否节点所存储的值是否等于目标值,并且进行判断是否为叶子节点

            if (curr.pathSum==targetSum&&curr.node.left==null&&curr.node.right==null){

                return true;
            }

            if (curr.node.right!=null){

                stack.push(new Node(curr.node.right, curr.pathSum+curr.node.right.val));
            }

            if (curr.node.left!=null){

                stack.push(new Node(curr.node.left, curr.pathSum+curr.node.left.val));

            }


        }

        return false;



    }


    /**
     * leedcode-路径综合--递归
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum2(TreeNode root, int targetSum){

        if (root==null) return false;
        targetSum=targetSum-root.val;
        //如果当前是叶子节点,检查sum 值 是否为0,也就是是否找到了给定的目标和
        if (root.left==null&&root.right==null){
            return targetSum==0;
        }
        boolean haPathLeft=hasPathSum2(root.left, targetSum);
        boolean haPathRight=hasPathSum2(root.right, targetSum);
        return haPathLeft||haPathRight;
    }


}