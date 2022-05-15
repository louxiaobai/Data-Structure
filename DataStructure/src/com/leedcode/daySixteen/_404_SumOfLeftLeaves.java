package com.leedcode.daySixteen;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/14-12:52 下午
 */
public class _404_SumOfLeftLeaves {


    /**
     * 递归求解
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {

        if (root==null) return 0;

        int res=0;
        if (root.left!=null&&root.left.left==null&&root.left.right==null){

            res=root.left.data;

        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+res;
    }

    /**
     * 使用层次遍历进行求解-较容易理解
     * @param root
     * @return
     */
    public int sumOfLeftLeaves1(TreeNode root) {

        if (root==null) return 0;

        //创建一个队列

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);

        int res=0;

        while (!queue.isEmpty()){


            //得到节点
            TreeNode curr = queue.poll();

            if (curr.left!=null&&curr.left.left==null&&curr.left.right==null){

                res+=curr.left.data;
            }

            if (curr.left!=null) queue.offer(curr.left);

            if (curr.right!=null) queue.offer(curr.right);


        }


        return res;

    }

}