package en.strings;

public class JudgeCircle_657 {

//    在2D平面上，有一个机器人从原点位置（0，0）开始。给定一系列移动，判断该机器人在完成移动后是否以（0，0）结尾。
//    移动序列由字符串表示，字符move [i]表示其第i个动作。有效的移动是R（右），L（左），U（上）和D（下）。如果机器人在完成所有移动后返回原点，则返回true。否则，返回false。
//    注意：机器人“面对”的方式无关紧要。 “ R”将始终使机器人向右移动一次，“ L”将始终使机器人向左移动，依此类推。此外，假设每次移动的机器人的幅度相同。

//    计算上下移动次数相同 并且左右移动次数相同的时候，则说明返回了原点
    public boolean judgeCircle1(String moves){
        int cntU = 0, cntD = 0, cntR = 0, cntL = 0;
        for(int i = 0; i < moves.length(); i ++){
            if(moves.charAt(i) == 'U'){
                cntU++;
            }
            if(moves.charAt(i) == 'D'){
                cntD++;
            }
            if(moves.charAt(i) == 'R'){
                cntR++;
            }
            if(moves.charAt(i) == 'L'){
                cntL++;
            }
        }
        return (cntD == cntU) && (cntR == cntL);
    }

//    定义两个变量 y ：代表向上移动增加，向下移动则减少； x: 代表向左移动步数增加，向右移动则减少
    public boolean judgeCircle2(String moves){
        int x = 0, y = 0;
        boolean flag = false;
        for(int i = 0; i < moves.length(); i ++){
            char c = moves.charAt(i);

            if(c == 'L'){
                x++;

            }else if(c == 'R'){
                x--;
            }else if(c == 'U'){
                y++;
            }else{
                y--;
            }

        }
//        当x, y 的值都为 0 时，则返回了原点
        if(x == 0 && y == 0){
            flag = true;
        }
        return flag;
    }
}
