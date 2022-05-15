package com.leedcode.daySixteen;

import java.util.*;

/**
 * @author lqw
 * @date 2022/5/14-5:03 下午
 */
public class _199_RightSideViewOffer {

    /**
     * DFS深度优先遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {


        ArrayList<Integer> list=new ArrayList<>();



        //进行特殊判断
        List<Integer> res=new ArrayList<>();

        if (root==null) return res;

        if (root.left==null&&root.right==null){

            res.add(root.data);

            return res;
        }

        //创建一个栈

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){


            //得到每层的个数

            int size=queue.size();

            for (int i = 0; i < size; i++) {


                TreeNode curr = queue.poll();
                if (i==size-1) res.add(curr.data);
                if (root.left!=null) queue.offer(curr.left);
                if (root.right!=null) queue.offer(curr.right);

            }



        }
        return res;

    }

}