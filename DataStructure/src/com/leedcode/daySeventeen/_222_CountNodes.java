package com.leedcode.daySeventeen;

import org.w3c.dom.html.HTMLIsIndexElement;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lqw
 * @date 2022/5/15-2:38 下午
 */
public class _222_CountNodes {


    /**
     * 简单方法:使用层次遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {

        if (root==null) return 0;

        if (root.left==null&&root.right==null) return 1;

        Queue<TreeNode> queue=new LinkedList<>();


        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){

            int size = queue.size();
            res+=size;
            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                if (curr.left!=null) queue.offer(curr.left);
                if (curr.right!=null) queue.offer(curr.right);

            }


        }

        return res;

    }

    /**
     * 使用前序遍历-使用栈
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root){

        if (root==null) return 0;

        if (root.left==null&&root.right==null) return 1;


        ArrayDeque<TreeNode> stack=new ArrayDeque<>();

        stack.push(root);
        int res=0;
        while (!stack.isEmpty()){


            TreeNode curr = stack.pop();

            if (curr.right!=null) stack.push(curr.right);

            if (curr.left!=null) stack.push(curr.left);


            res++;

        }


        return res;




    }

    /**
     * 使用中序遍历:--使用栈
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root){

        if (root==null) return 0;

        if (root.left==null&&root.right==null) return 1;

        ArrayDeque<TreeNode> stack=new ArrayDeque<>();

        TreeNode curr=root;

        int res=0;

        while (curr!=null||!stack.isEmpty()){

            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            //将栈顶的元素进行弹出

            TreeNode node = stack.pop();
            res++;
            //然后尝试去遍历左子树的的右子树
            curr=node.right;
        }

        return res;


    }

    /**
     * 使用后续遍历
     * 前序遍历:中左右
     * 后续遍历:左右中
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root){

        if (root==null) return 0;

        if (root.left==null&&root.right==null) return 1;

        //创建一个栈用来操作树

        ArrayDeque<TreeNode> stack=new ArrayDeque<>();


        //创建链表用来存储遍历得到的数据

        LinkedList<Integer> list=new LinkedList<>();

        stack.push(root);

        int res=0;

        while (!stack.isEmpty()){

            TreeNode curr = stack.pop();

            list.addFirst(1);

            if (curr.left!=null) stack.push(curr.left);

            if (curr.right!=null) stack.push(curr.right);

            res++;
        }

        return res;
    }

}