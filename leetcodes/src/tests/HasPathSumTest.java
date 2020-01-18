package tests;

public class HasPathSumTest {

//    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和
    public boolean hasPathSum(TreeNode root, int sum){

        if (root == null) return false;

        if (root != null && root.left == null && root.right == null){
            return root.val - sum == 0;
        }

        return hasPathSum(root.left,root.val - sum) || hasPathSum(root.right,root.val - sum);


    }




    public static void main(String [] args){

        HasPathSumTest hasPathSumTest = new HasPathSumTest();
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(2);

        System.out.println(hasPathSumTest.hasPathSum(t,5));

    }
}
