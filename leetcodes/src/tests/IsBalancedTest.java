package tests;

public class IsBalancedTest {

//    给定一个二叉树，判断它是否是高度平衡的二叉树。
//    本题中，一棵高度平衡二叉树定义为：
//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

    public boolean isBalanced(TreeNode root){
//        如果二叉树为空则为平衡二叉树
        if (root == null)return true;
//        获取左子树的深度值
        int leftDepth = depthNum(root.left);

//        获取右子树的深度值
        int rightDepth = depthNum(root.right);
        System.out.println(leftDepth + "dd"+ rightDepth);

        if(Math.abs((leftDepth - rightDepth)) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
//        判断两个子树的节点深度差的绝对值
//        如果大于1；则不是高度平衡二叉树
        return false;

    }

    public int depthNum(TreeNode root){
       if (root == null) return 0;
       return 1 + Math.max(depthNum(root.left),depthNum(root.right));
    }




//  方法二

    private boolean result = true;
    public boolean isBalanced1(TreeNode root){

        maxDepth(root);
        return result;

    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l - r) > 1){
            result = false;
        }

        return 1 + Math.max(l,r);

    }

    public static void main (String [] args){
        IsBalancedTest isBalancedTest = new IsBalancedTest();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(2);
        t.left.left = new TreeNode(3);
        t.left.right = null;
        t.right.left = null;
        t.right.right = new TreeNode(4);
        t.left.left.left = null;
        t.left.left.right = null;
        t.right.right.left = new TreeNode(4);


        System.out.println(isBalancedTest.isBalanced(t));

    }


}
