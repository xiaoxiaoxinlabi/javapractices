package tree;


import java.util.Stack;

//二叉树，是有序的树，其  左子树< root < 右子树
public class BinaryTree {

  private class Node{
    private int key;
    private int value;
    private Node left;
    private Node right;
//    以该结点为根的子树中的结点的总数
    private int N;

   public Node (int value){
      this.value = value;
      right = null;
      left = null;
      N = 0;

    }

  }

  private Node root;

//  获取根结点的子树中的节点总数

  public int size(Node node){
    if(node == null){
      return 0;
    }else{
      return node.N;
    }

  }
//insert emelent 插入元素

  public Node addRecursive(Node current, int value){

//    如果当前节点为空，则新创建一个节点
    if (current == null){
       return new Node(value);
    }

//    如果要插入的值小于当前节点，则在当前节点的左子树进行插入
    if(value < current.value){
      current.left = addRecursive(current.left, value);

//      如果要插入的值大于当前节点，则在当前节点的右子树进行插入
    }else if (value > current.value){
      current.right = addRecursive(current.right, value);
    }else{

//      如果相等，则已经存在不用插入
//      value alreadys exists
      return current;
    }

    return current;

  }

//  查找元素是否包含某元素

  public boolean contains(Node current, int value){
    if(current == null){
      return  false;
    }
    if (value == current.value){
      return true;
    }
    return value < current.value
        ? contains(current.left,value)
        : contains(current.right,value);
  }

//  查找最小结点
  public Node findMin(Node node){
    if(node == null){
      return null;
    }else if (node.left == null){
      return node;
    }
    return findMin(node.left);
  }

//  查找最大的结点

  public Node findMax(Node node){
    if(node !=null){
      while(node.right!=null){
        node = node.right;
      }
    }
    return node;
  }


//  删除元素（delete element）

  public Node delete(Node current, int value){
   if(current == null){
     return current;
   }
//   判断删除的数在左子树，还是右子树
   if(value < current.value){
     current.left = delete(current.left,value);
   }else if(value > current.value){
     current.right = delete(current.right, value);
   }else if(current.left !=null && current.right !=null){
//     找到右子树中最小的值
     current.value = findMin(current.right).value;
     current.right = delete(current.right, current.value);
   }else{
     current =(current.left !=null)? current.left:current.right;
   }
   return current;
  }


//  删除最小元素

  public Node deleteMin(Node node){
    if(node.left == null){
      return node.right;
    }
    node.left = deleteMin(node.left);
    return node;
  }


//  遍历二叉树--中序遍历
//  left --root --right

  public void traverseInOrder(Node node){
    if(node !=null){
      traverseInOrder(node.left);
      System.out.println(node.value);
      traverseInOrder(node.right);
    }
  }

//  先序遍历（root --left --right）
  public void traversePreOrder(Node node){
    if(node !=null){
      System.out.println(node.value);
      traversePreOrder(node.left);
      traversePreOrder(node.right);
    }
  }

//  后续遍历（left--right--root）

  public void traversePostOrder(Node node){
    if(node !=null){
      traversePostOrder(node.left);
      traversePostOrder(node.right);
      System.out.println(node.value );
    }
  }


//  深度遍历
  public void traversedeepOrder(Node node){
    Stack<Node> stack = new Stack();

    stack.push(node.right);
    stack.push(node.left);
    while(!stack.isEmpty()){
      Node tmp = stack.pop();
      System.out.println(tmp.value);
      if(null != tmp.right){
        stack.push(tmp.right);
      }
      if(null !=tmp.left){
        stack.push(tmp.left);
      }
    }
  }

//  求树的高度

  public int height(Node node){
    if(node == null){
      return 0;
    }
    int hleft = height(node.left) + 1;
    int hright = height(node.right)+1;
    return hleft > hright?hleft:hright;
  }

//  节点的个数

  public int numberofTreeNode(Node node){
    if(node == null){
      return 0;
    }
    int left = numberofTreeNode(node.left);
    int right = numberofTreeNode(node.right);
    return 1+left+right;
  }

//  叶子节点的个数

  public int numberofnode(Node node){
    if(node == null){
      return 0;
    }
    if(node.left == null && node.right == null){
      return  1;
    }
    return numberofnode(node.left) + numberofnode(node.right);
  }

//  第K层节点的个数

  public int numsOfkLevelTreeNode(Node node, int k){
    if(node == null || k < 1){
      return 0;
    }
    if(k == 1){
      return 1;
    }
    int numleft = numsOfkLevelTreeNode(node.left, k-1);
    int numright = numsOfkLevelTreeNode(node.right, k-1);
    return numleft+numright;
  }

//  翻转二叉树

  public Node mirrorTreeNode(Node node){
    if(node == null){
      return null;
    }
    Node left = mirrorTreeNode(node.left);
    Node right = mirrorTreeNode(node.right);
    node.left = right;
    node.right = left;
    return node;
  }

//  最大深度
  public int maxdeepth(Node node){
    if(node == null){
      return 0;
    }
    int left = maxdeepth(node.left);
    int right = maxdeepth(node.right);
    return Math.max(left, right)+1;

  }

  
//  最小深度
  public int getMindeepth(Node node){
    if(node == null){
      return 0;
    }else if(node.left == null && node.right == null){

      return 1;
    }
    return Math.min(getMindeepth(node.left), getMindeepth(node.right)) + 1;
  }
}


