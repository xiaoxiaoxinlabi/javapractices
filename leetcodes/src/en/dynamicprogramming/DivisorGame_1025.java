package en.dynamicprogramming;

public class DivisorGame_1025 {

//    丽丝和鲍勃轮流玩游戏，爱丽丝先开始
//    最初，黑板上有一个数字N。在每个玩家的回合上，该玩家进行以下操作：
//    Choosing any x with 0 < x < N and N % x == 0.
//    Replacing the number N on the chalkboard with N - x.
//     同样，如果玩家不能采取任何行动，他们就会输掉比赛。
//    当且仅当爱丽丝（Alice）赢得比赛时才返回True（假定两个玩家都表现最佳）。

//    Example 1:
//    Input: 2
//    Output: true
//    Explanation: Alice chooses 1, and Bob has no more moves.

    public boolean divisorGame(int N) {

        return N % 2 == 0;

    }

    public boolean divisorGame1( int N){
        boolean [] moves = new boolean[N+1];
        moves[1] = false;
        for(int i = 1; i <= N; i ++){
            moves[i] = false;
            for(int j = 1; j < i; j ++){
                if(i % j == 0){
                    if(!moves[i-j]){
                        moves[i] = true;
                        break;
                    }
                }
            }
        }
        return moves[N];
    }

    public boolean divisorGame2(int N){
        int count = 0;
        int i = 1;
        while((N - i) > 0){
            if(N % i == 0 && i > 0 && i < N){
                count++;
                N = N-i;
            }else{
                i++;
            }
        }
        if(count % 2 != 0){
            return true;
        }
        return false;
    }
}
