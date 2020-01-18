package tests;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthTest {

//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//    说明: 叶子节点是指没有子节点的节点。



    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        int leftNum = maxDepth(root.left);
        int rightNum = maxDepth(root.right);

        int maxNum = leftNum > rightNum ? leftNum + 1 : rightNum + 1;
//        int mxxNum = Math.max(leftNum + 1, rightNum + 1);
        return maxNum;

    }
//
//    分清楚：区别
//            if(){}if(){}:多个if的时候，不管前面的if是ture,false 后边的都会执行
//            if(){}elseif(){}：如果前面的有一个成立  那么后面的都不执行
//

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();

                    if (curNode.left != null) {
                        q.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        q.add(curNode.right);
                    }
            }

        }

        return depth;


    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp,max);

                if (node.left != null) {
                    stack.push(node.left);
                    value.push(temp + 1);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    value.push(temp + 1);
                }


        }
        return max;

    }


    public static void main(String[] args) {

        MaxDepthTest maxDepthTest = new MaxDepthTest();


    }

}
