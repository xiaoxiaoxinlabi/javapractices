package tests;

public class IsSameTreeTest {

    public boolean isSameTree(TreeNode p, TreeNode q){
        boolean falg = false;
        if (p == null && q == null){
            return true;
        }else if ((p == null && q != null) || (p != null && q == null)){
            return false;
        }else {
            if (p.val != q.val){
                return false;
            }else {
                 if (isSameTree(p.left,q.left) && isSameTree(p.right,q.right)){
                     falg = true;
                 }
            }
        }

        return falg;


    }

    public boolean isSameTree1(TreeNode p, TreeNode q){
        if (p == null && q == null)return true;
        if (p == null || q == null)return false;
        return (p.val == q.val) && isSameTree1(p.left , q.left) && isSameTree1(p.right , q.right);

    }

    public boolean isSameTree2(TreeNode p, TreeNode q){

        if (p == null && q == null)return true;
        if (p == null || q == null)return false;
        boolean currentValue = p.val == q.val;
        boolean leftValue = isSameTree2(p.left,q.left);
        boolean rightValue = isSameTree2(p.right,q.right);
        return currentValue && leftValue && rightValue;
    }

    public static void main(String [] args){

        IsSameTreeTest sameTreeTest = new IsSameTreeTest();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(1);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);

        boolean result = sameTreeTest.isSameTree2(t1,t2);
        System.out.println(result);


    }
}
