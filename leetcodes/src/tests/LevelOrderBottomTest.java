package tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

public class LevelOrderBottomTest {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> warpList = new LinkedList<List<Integer>>();

//        二叉树为空，则返回空的warpList
        if (root == null)
            return warpList;

//        如果不为空，则将整个二叉树添加到队列中，队列size = 1
        queue.offer(root);
//        判断队列是否为空
        while(!queue.isEmpty()){

            int leveNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i = 0; i < leveNum; i ++){
//                如果当前队列的头部元素的左节点不为空，则将其添加到队列中
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
//                    如果当前队列的头部元素的右节点不为空，则将其添加到队列中
                }if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

//                将队列中的头元素的父节点添加到subList中
                subList.add(queue.poll().val);
            }
//            当队列的size<=0 时，将subList 中的元素添加到arrList中的index = 0 的位置（即第一个位置）
            warpList.add(0,subList);
        }
        return warpList;


    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root){
        List<List<Integer>> arrList = new ArrayList<>();
//        判断二叉树为空，则直接返回空的list
        if (root == null){
            return arrList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
//        如果不为空，将二叉树添加到队列中，add后，queue的size = 1
        queue.add(root);

//        判断队列是否为空
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList();
            for(int i = queue.size(); i > 0 ; i --){
//                将队列头部（第一个）的元素赋值给current
                TreeNode current = queue.poll();
//                将current的父节点添加到sublist
                subList.add(current.val);

//                如果current的left节点不为空，则加入到队列中，队列size+1
                if (current.left != null){
                    queue.offer(current.left);
                }
//                如果current的right节点不为空，则加入到队列中，队列size +1
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
//            当队列的size<=0 时，将subList 中的元素添加到arrList中的index = 0 的位置（即第一个位置）
            arrList.add(0,subList);
        }
//        当队列中为空的时候，返回arrList
        return arrList;
    }

    public static void main (String [] args){
        LevelOrderBottomTest levelOrderBottomTest = new LevelOrderBottomTest();
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        System.out.println(levelOrderBottomTest.levelOrderBottom1(t));




    }
}
