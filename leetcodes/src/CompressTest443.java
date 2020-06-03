public class CompressTest443 {
//  压缩字符串
//  给定一组字符，使用原地算法将其压缩。
//  压缩后的长度必须始终小于或等于原数组长度。

//  示例 1：
//  输入：
//      ["a","a","b","b","c","c","c"]
//
//  输出：
//  返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
//
//  说明：
//      "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。



//  方法一：双指针 【通过】
//我们使用两个指针 read 和 write 分别标记读和写的位置。读写操作均从左到右进行：读入连续的一串字符，然后将压缩版写到数组中。最终，write 将指向输出答案的结尾。


  public static int compress(char [] chars){
//    保留指针 anchor，指向当前读到连续字符串的起始位置。
    int anchor = 0, write = 0;
    for(int read = 0; read < chars.length; read++){
      // 当达到数组最后位置或连续字符的最后位置
      if(read + 1 == chars.length || chars[read + 1]!= chars[read]){
        // 写入字符
        chars[write++] = chars[anchor];
// 写入长度
        if(read > anchor){

          char [] res = String.valueOf(read - anchor + 1).toCharArray();
          for(char c: res){
            chars[write++] = c;
          }
        }
        anchor = read + 1;
      }
    }
    return write;


  }

//  滑动窗口法
//  利用滑动窗口法，左右指针起点都为原数组的首位。
//  实现步骤如下：

//  不断右移右指针，使窗口不断增大；
//  当窗口内出现一个不同的元素时，就可以将元素及其数量（等于左右指针之差）更新在数组中，然后让左指针指向右指针；
//  遍历到最后一个字符时也需要结算，因此将右指针的终点设为数组之外一格。当右指针移到终点时也要更新数组。

  public static int compress2(char [] chars){
    int left = 0, size = 0;
    // 由于最后一个字符也需要判断，所以将右指针终点放到数组之外一格
    for(int right = 0; right <= chars.length; right++){
      // 当遍历完成，或右指针元素不等于左指针元素时，更新数组
      if(right == chars.length || chars[right] != chars[left]){
        // 更新字符
        chars[size++] = chars[left];

        // 更新计数，当个数大于 1 时才更新
        if(right - left > 1){

          char [] res = String.valueOf(right - left).toCharArray();
          for(char re: res){
            chars[size++] = re;
          }
        }
        left = right;
      }
    }
    return size;
  }
}
