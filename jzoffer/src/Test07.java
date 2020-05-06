import java.util.HashMap;



public class Test07 {

//  重建二叉树
//  输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

//  前序遍历特点： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序
//  中序遍历特点： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序
//  解题思路：
//前序遍历的首个元素即为根节点 root 的值；
//在中序遍历中搜索根节点 root 的索引 ，可将中序遍历划分为 [ 左子树 | 根节点 | 右子树 ]
//  根据中序遍历中的左（右）子树的节点数量，可将前序遍历划分为 [ 根节点 | 左子树 | 右子树 ]

//  自此可确定 三个节点的关系 ：1.树的根节点、2.左子树根节点、3.右子树根节点（即前序遍历中左（右）子树的首个元素）。
  class TreeNode{

    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int val){
      this.data = val;
    }


  }

  HashMap<Integer, Integer> dic = new HashMap();
  int [] po;

  public TreeNode buldTree(int [] preorder, int [] inorder){
//    将先序遍历赋给po
    po = preorder;

//    依次将中序遍历存放在map中
    for(int i = 0; i < inorder.length; i++){
      dic.put(inorder[i], i);
    }

    return recur(0,0, inorder.length - 1);
  }
//  递推参数： 前序遍历中根节点的索引pre_root、中序遍历左边界in_left、中序遍历右边界in_right
  TreeNode recur(int pre_root, int in_left, int in_right){
//    当 in_left > in_right ，子树中序遍历为空，说明已经越过叶子节点，此时返回 null。
    if(in_left > in_right){
      return null;
    }
//    建立根节点root，值为前序遍历中索引为pre_root的节点值。
    TreeNode root = new TreeNode(po[pre_root]);
//    搜索根节点root在中序遍历的索引i： 为了提升搜索效率，本题解使用哈希表 dic 预存储中序遍历的值与索引的映射关系，每次搜索的时间复杂度为 O(1）
    int i = dic.get(po[pre_root]);

//    构建根节点root的左子树和右子树：
//    左子树： 根节点索引为 pre_root + 1 ，中序遍历的左右边界分别为 in_left 和 i - 1
//    右子树： 根节点索引为 i - in_left + pre_root + 1（即：根节点索引 + 左子树长度 + 1），中序遍历的左右边界分别为 i + 1 和 in_right。

    root.left = recur(pre_root + 1, in_left, 1);
    root.right = recur(pre_root+i-in_left+1, i+1, in_right);
    return root;

  }

}
