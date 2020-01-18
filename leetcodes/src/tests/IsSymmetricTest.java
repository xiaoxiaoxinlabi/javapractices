package tests;

public class IsSymmetricTest {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        return isTheChildSame(root.left,root.right);

    }

    public boolean isTheChildSame(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null)return true;
        if (node1 == null || node2 == null)return false;
        return (node1.val == node2.val) && isTheChildSame(node1.left,node2.right) && isTheChildSame(node1.right,node2.left);
    }



    public static void main(String[] args) {
        IsSymmetricTest isSymmetricTest = new IsSymmetricTest();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);
        System.out.println(isSymmetricTest.isSymmetric(t1));


    }
}
