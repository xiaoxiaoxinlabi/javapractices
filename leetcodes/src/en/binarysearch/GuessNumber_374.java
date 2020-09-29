package en.binarysearch;

public class GuessNumber_374 {
//    我们正在玩猜猜游戏。游戏如下：
//    我选择一个从1到n的数字。您必须猜测我选了哪个号码。
//    每次您猜错了，我都会告诉您数字是高还是低。
//    您调用一个预定义的APIguess（int num），它返回3种可能的结果（-1、1或0）：
//
//            -1：我的电话号码较低
//            1：我的电话号码更高
//            0：恭喜！你说对了！

    public int guessNumber1(int n){

        int low = 1, high = n;
        while(low <= high){

            int mid = low + (high - low)/2;

            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) == 1){
                low = mid + 1;
            }else if(guess(mid) == -1) {
                high = mid - 1;
            }
        }
        return 0;

    }
    private int guess(int n){
        return 0;
    }

}
