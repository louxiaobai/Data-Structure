package com.leedcode.daySixteen;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/14-12:01 下午
 */
public class _111_MinDepth {

    /**
     * 递归版本求解最小深度(这个最小深度需要包含叶子节点)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root==null) return 0;

        if (root.left==null&&root.right==null) return 1;

        int left=minDepth(root.left);

        int right=minDepth(root.right);

        //需要进行判断左右子树是否为空

        if (root.right==null){

            return left+1;

        }else if (root.left==null){

            return right+1;

        }else {

            return Math.min(left, right)+1;

        }


    }


    /**
     * 层序遍历求解树的最小深度问题
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root){

        if (root==null) return 0;

        //创建一个队列对树进行操作

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            res++;
            //求解该层树的个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left==null&&curr.right==null){
                    return res;
                }
                if (curr.left!=null) queue.offer(curr.left);
                if (curr.right!=null) queue.offer(curr.right);
            }
        }
        return res;
    }

}
