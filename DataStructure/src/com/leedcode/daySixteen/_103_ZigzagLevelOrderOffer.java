package com.leedcode.daySixteen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/14-3:56 下午
 */
public class _103_ZigzagLevelOrderOffer {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        //进行特殊情况的判断
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        if (root.left==null&&root.right==null){
            List<Integer> list=new ArrayList<>();
            list.add(root.data);
            res.add(list);
            return res;
        }

        //进行层序遍历
        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);

        boolean flag=true;

        while (!queue.isEmpty()){

            int size = queue.size();

            List<Integer> list=new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();


                list.add(curr.data);

                if (flag){

                    if (curr.right!=null) queue.offer(curr.right);

                    if (curr.left!=null) queue.offer(curr.left);


                }else{

                    if (curr.left!=null) queue.offer(curr.left);
                    if (curr.right!=null) queue.offer(curr.right);

                }
            }
            flag=!flag;
            res.add(list);
        }

        return res;

    }
}