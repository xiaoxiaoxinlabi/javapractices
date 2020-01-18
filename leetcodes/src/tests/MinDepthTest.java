package tests;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthTest {


//    给定一个二叉树，找出其最小深度。
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//    说明: 叶子节点是指没有子节点的节点。


//    方法一：
    public int minDepth(TreeNode node) {

        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList();
//        queue.add():增加一个元素；如果队列已满，则抛出一个IIIegaISlabEepeplian异常
        queue.offer(node);

        int num = 0;

        while (!queue.isEmpty()) {

            num++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {

//                返回第一个元素，并在队列中删除：queue.poll()；如果队列为空，则返回null

                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) return num;
                if (currentNode.left != null) {
//                    queue.offer():添加一个元素并返回true；如果队列已满，则返回false；
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

        }

        return num;


    }

//    方法二：

    public int minDepth1(TreeNode root){

//        判断树为空 则返回 0
        if (root == null) return 0;
//        如果左子节点和右节点都不为空
        if (root.right != null && root.left != null){
//            利用递归的方式计算左节点最小深度，右节点最小深度
            int left = minDepth1(root.left);
            int right = minDepth1(root.right);
//            返回最小值
            return left > right ? right + 1 : left + 1;
        }

//        如果左节点为空；则返回有右节点的最小深度
        if (root.left == null){
            return minDepth1(root.right) + 1;
        }

//        如果右节点为空；则返回左节点的最小深度
            return minDepth1(root.left) + 1;


    }


//    方法三：


    public int minDepth2(TreeNode root){
//        如果树为空；则返回0
        if (root == null) return 0;
//        计算左节点的最小深度；利用递归法
        int left = minDepth2(root.left);
//        计算右节点的最小深度；利用递归法
        int right = minDepth2(root.right);
//        如果左节点的深度为0；或者右节点的深度为0；则返回：left + right + 1;
//        如果都不为空；则返回两者中的最小值
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    public static void main(String[] args) {
        MinDepthTest minDepthTest = new MinDepthTest();
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        minDepthTest.minDepth(t);
    }
}
