package en.maths;

public class DivisorGame_1025 {

//    爱丽丝和鲍勃轮流玩游戏，爱丽丝先开始。
//    最初，黑板上有一个数字N。在每个玩家的回合上，该玩家进行以下操作：
//    选择0 <x <N并且N％x == 0的任何x。
//    用N-x替换黑板上的数字N。
//    同样，如果玩家不能采取任何行动，他们就会输掉比赛。
//    当且仅当爱丽丝（Alice）赢得比赛时才返回True（假定两个玩家都表现最佳）。

    public boolean divisorGame(int N) {

        if(N % 2 == 0){
            return true;
        }
        return false;

    }

    public boolean divisorGame1(int N){
        int x = 0, i ;
        if(N == 1){
            return false;
        }
        for(i = 2; i < N; i ++){
            if(N % i == 0){
                x++;
                N = N - i;
                i = 0;
            }
            x++;
        }
        if(x % 2 == 0){
            return true;
        }
        return false;
    }
}
