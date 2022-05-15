package com.leedcode.btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lqw
 * @date 2022/1/12-11:39 上午
 */
public class IsSameTree {


    /**
     * 递归--dfs
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p==null&&q==null) return true;

        if (p==null||q==null) return false;

        if (p.val!=q.val)  return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


    /**
     * 迭代--bfs
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        if (p==null&&q==null) return true;

        if (p==null||q==null) return false;

        //创建两个队列
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()&&!queue2.isEmpty()){

            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val!=node1.val) return false;

            TreeNode left1 = node1.left,right1=node1.right;
            TreeNode left2 = node2.left,right2=node2.right;

            if (left1==null^left2==null) return false;
            if (left2==null^left2==null) return false;

            if (left1!=null) queue1.offer(left1);
            if(right1!=null) queue1.offer(right1);
            if (left2!=null) queue2.offer(left2);
            if (right2!=null) queue2.offer(right2);
        }

        return queue1.isEmpty()&&queue2.isEmpty();




    }



}