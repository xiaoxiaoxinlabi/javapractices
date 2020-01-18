package tests;

public class BinarySearchTest {
  /**
   * 算法 是由 静态 方法 rank() 实现 的， 它 接受 一个 整数 键 和 一个 已经 有序 的 int 数组 作为 参数。 如果 该 键 存在 于 数组 中 则 返回 它的 索引， 否则 返回 -1。
   * 1,算法 使用 两个 变量 lo 和 hi， 并 保证 如果 键 在 数组 中 则 它 一定 在 a[ lo.. hi] 中，
   * 2,然后 方法 进入 一个 循环， 不断 将 数组 的 中间 键（ 索引 为 mid） 和 被 查找 的 键 比较。
   * 3,如果 被 查找 的 键 等于 a[ mid]， 返回 mid； 否则 算法 就 将 查找 范围 缩小 一半，
   * 4,如果 被 查找 的 键 小于 a[ mid] 就 继续 在 左 半边 查找，
   * 5,如果 被 查找 的 键 大于 a[ mid] 就 继续 在右 半边 查找。
   * 6,算法 找到 被 查找 的 键 或是 查找 范围 为 空 时 该过 程 结束。
   * 二分 查找 之所以 快 是因为 它 只需 检查 很少 几个 条目（ 相对于 数组 的 大小） 就能 够 找到 目标 元素（ 或者 确认 目标 元素 不存在）。
   *
   *
   */


  public int fun1(int arg, int [] arr){
//    使用两个变量low 和high，并保证如果键在数组中则它一定 a[ low.. high]中
//    arr 必须是有序的
    int high = arr.length - 1;
    int low = 0;

    while (low <= high){
      int mid = low + (high - low) / 2;
      if (arg < arr[mid]){
        high = mid - 1;
      }else if ( arg > arr[mid]){
        low = mid + 1;
      }else{
        return mid;
      }
    }

    return -1;

  }

  public static void main(String [] args){
    int temp = 81;
    int [] arrs = {1,2,3,4,5,6,8};
    BinarySearchTest binarySearchTest = new BinarySearchTest();
    System.out.println(binarySearchTest.fun1(temp,arrs));


  }

}
