package en.minimax;

public class CanWinNim_292 {
//      如果堆中的宝石数n不能被4整除。
//    您正在和朋友一起玩以下Nim游戏：桌子上有一堆石头，每次你们一个人轮流删除1-3块石头。移除最后一块石头的人将成为赢家。您将第一轮将石头取下。
//    你们俩都很聪明，并且拥有最佳的游戏策略。编写一个函数，根据堆中的石头数确定您是否可以赢得比赛。
//    Points:
//            1. If n <= 3, you must can win.
//            2. If n = 4, you must lose.
//            3. If 4 < n < 8, n = 5, 6, 7, after your turn, you must can make n = 4, so now your friend is facing n = 4, he must lose.
//            4. If n = 8, you only can make n to 7, 6, 5, now your friend is facing n = 5, 6, or 7, he must can win.
//            5. If 8 < n < 12, such as n = 9, 10, 11, you must can make n = 8, now your friend is facing n = 8, he must lose.
//            6. Now we find the regulation, if n % 4 == 0, you must lost, your friend must win, but if n % 4 != 0, you must can win.
    public boolean canWinNim(int n) {

        return !(n % 4 ==0);

    }

    // here it is forming a pattern

    //1-me
    //2-me
    //3-me
    //4-frnd
    //5-me
    //6-me
    //7-me
    //8-frnd
    //9-me
    //10-me
    //11-me
    //12-frnd


    //so simply we can do here

    public boolean canWinNim1(int n){
        if(n <= 3){
            return true;
        }
        if(n % 4 == 0){
            return false;

        }
        return true;

    }
}
