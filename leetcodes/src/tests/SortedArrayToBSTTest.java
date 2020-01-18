package tests;

public class SortedArrayToBSTTest {

//    将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//    一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1


//    方法一：创建树的策略：
//        1，找到数组的中间节点并作为树的根节点（root）
//        2，依次将数组的左右，分别创建为二叉树的左右叶子节点
    public TreeNode sortedArrayToBST(int [] nums){

        return createTree(nums,0,nums.length - 1);
        
    }

    private TreeNode createTree(int [] nums,int start,int end){

//        如果数组指针越界，将创建一个空的节点，依附在叶节点上
        if (start > end){
            return null;
        }
//        获取数组的中心节点
        int mid = start + (end - start)/2;
//        将数组的中心节点(mid)作为二叉树的根节点（root）
        TreeNode node = new  TreeNode( nums[mid]);
//        左子树包含的节点是（start,mid -1）
        node.left = createTree(nums,start,mid - 1);
//        右子树包含的节点是（mid+1,end）
        node.right = createTree(nums,mid + 1,end);
//        将组成的平衡二叉树返回
        return node;
    }




//    方法二：

    public TreeNode sortedArrayToBST1(int [] nums){
        TreeNode node = null;
        if (nums != null && nums.length >0){
            node = new TreeNode(-1);
            createTree1(node,nums,0,nums.length - 1);
        }

        return node;
    }

    public void createTree1(TreeNode node,int [] nums, int begin,int end){
        int middle = begin + (end - begin) / 2;
        node.val = nums[middle];
        if(begin != end){
            if (begin < middle){
                TreeNode left = new TreeNode(-1);
                node.left = left;
                createTree1(left,nums,begin,middle - 1);
            }
            if (end > middle){
                TreeNode right = new TreeNode(-1);
                node.right = right;
                createTree1(right,nums,middle + 1,end);
            }
        }

    }





    public static void main(String [] args){
        SortedArrayToBSTTest sortedArrayToBSTTest = new SortedArrayToBSTTest();
        int [] arr = {-10,-3,0,5,9};
        sortedArrayToBSTTest.sortedArrayToBST(arr);


    }
}
