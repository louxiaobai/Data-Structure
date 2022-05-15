package com.leedcode.ms;



import java.util.*;

/**
 * @author lqw
 * @date 2022/1/22-10:11 上午
 */
public class _653_FindTarget {

    //创建一个私有内部类

    private class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉树的遍历-先使用递归遍历将二叉树存储到一个动态数组中,然后使用双指针进行求解。
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {

        if (root==null) return false;

        //将二叉搜索数变成一个有序数组
        List<Integer> list = new ArrayList<>();


        inOrder(root, list);

        //使用双指针进行求解

        int left=0;
        int right=list.size()-1;

        while (left<right){

            if (list.get(left)+list.get(right)==k){

                return true;
            }else if (list.get(left)+list.get(right)<k){

                left=left+1;
            }else {
                right=right-1;
            }


        }

        return false;


    }

    //二叉树的递归
    public void inOrder(TreeNode root,List<Integer> list) {

        if (root == null) return ;//递归结束条件
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }


    /**
     * hash存储法
     * 时间复杂度O(n)
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget2(TreeNode root, int k){

        if (root==null) return false;

        return find(root,new HashSet<Integer>(), k);

    }

    public boolean find(TreeNode node, Set<Integer> set,int target){

        if (node ==null) return false;//递归结束条件

        if (set.contains(target-node.val)) return true;

        set.add(node.val);

        return find(node.left, set,target)||find(node.right, set,target);

    }



    //二叉树的迭代-- 使用栈进行实现
    public void inOrder2(TreeNode root,List<Integer> list) {

        //创建一个栈

        Stack<TreeNode> stack=new Stack<>();

        TreeNode curr=root;

        while (stack!=null||curr!=null){

            while (curr!=null){
                list.add(curr.val);
                curr=curr.left;
            }

            TreeNode pop = stack.pop();
            list.add(pop.val);
            stack.push(pop.right);
        }





    }




}