import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.tree.Tree;

public class Test002 {

private List<TreeNode> list = new ArrayList<>();
//private TreeNode node;


//先序遍历--递归
// 1.首先遍历左子树,遍历到叶子结点为止
//  若二叉树为空，则退出，否则进行下面操作
//
//      访问根节点
//      先根遍历左子树
//      先根遍历右子树
//      退出
  public boolean perOrder(TreeNode node){
//首先从根节点遍历
    list.add(node);
    if(node.left !=null){
      perOrder(node.left);
    }
    if (node.right !=null){
      perOrder(node.right);
    }
    return  true;
  }

//  中序遍历--递归
//  若二叉树为空，则退出，否则进行下面操作
//   中根遍历左子树
//  访问根节点
//   中根遍历右子树
//  退出

  public boolean midOrder(TreeNode node){
    if (node.left!=null){
      midOrder(node.left);
    }
    list.add(node);
    if(node.right!=null){
      midOrder(node.right);
    }
    return true;

  }

//  后续遍历--递归

//  若二叉树为空，则退出，否则进行下面操作
//
//      后根遍历左子树
//      后根遍历右子树
//      访问根节点
//      退出

  public boolean posOrder(TreeNode node){
    if (node.left !=null){
      posOrder(node.left);
    }
    if(node.right !=null){
      posOrder(node.right);
    }
    list.add(node);
    return true;
  }

//  深度遍历

  public int getTreeDepth(TreeNode node){
    if (node.left ==null && node.right ==null){
      return 1;
    }
    int le = 0, ri = 0;

    if (node.left!=null){
      le = getTreeDepth(node.left);
    }
    if(node.right!=null){
      ri = getTreeDepth(node.right);
    }

    return le > ri? le + 1: ri+1;

  }

  public static void main(String [] args){


    Test002 t = new Test002();
    TreeNode e= new TreeNode("E",null,null);
    TreeNode d= new TreeNode("D", null, null);
    TreeNode b= new TreeNode("B", d, e);
    TreeNode c= new TreeNode("C", null, null);
    TreeNode a= new TreeNode("A", b, c);
    TreeNode root = a;
    System.out.println(t.perOrder(a));




  }
}
