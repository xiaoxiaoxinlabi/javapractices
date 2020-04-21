public class Test60 {

//  n个骰子的点数
//  把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率

//  你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

//  输入: 1
//  输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]


//  方法一：动态规划法

//  解题思路

//  n个骰子，每个骰子6个面，总情况数为6^n。
//  当n=1时，F(1,s)=1,其中s=1,2,3,4,5,6
//  当n≥2时，F(n,s)=F(n−1,s−1)+F(n−1,s−2)+F(n−1,s−3)+F(n−1,s−4)+F(n−1,s−5)+F(n−1,s−6)

public double []twoSum1(int n){

//  第n个筛子的“当前和”的出现次数
//  转移方程：dp[n][j]=dp[n][j-1]+dp[n][j-2]+...+dp[n][j-6]
  int [][]dp = new int[n+1][6*n+1];

//  边界条件
//  n=1 的时候，每一面出现的情况为1
  for(int s=1 ; s<=6; s++){
    dp[1][s]=1;

  }

//n >=2 的时候
  for(int i = 2; i <=n; i++){

    for(int s = i; s<=6*i; s++){
      //求dp[i][s]
      for(int d=1; d<=6; d++){
//        为0了
        if(s-d < i-1){
          break;
        }
        dp[i][s]+=dp[i-1][s-d];
      }
    }
  }

//  总情况数为6^n。6的n次方
  double total = Math.pow((double)6, (double)n);
//  每个和的情况
  double[] ans = new double[5*n+1];

  for(int i = n; i<=6*n; i ++){
    ans[i-n] = ((double)dp[n][i])/total;
  }
  return ans;
}


public double [] twoSum2(int n){
  int[][] dp=new int[n+1][6*n+1];
  double[] ans=new double[5*n+1];
  double all=Math.pow(6,n);

  for(int i = 1; i <=6; i ++){
    dp[1][i]=1;
  }

  for(int i = 1; i <=n; i++){
    for(int j=i; j<=6*n; j ++){
      for(int k = 1; k<=6; k++){
        dp[i][j]+=j>=k?dp[i-1][j-k]: 0;

        if(i==n){
          ans[j-i]=dp[i][j]/all;
        }
      }
    }
  }

  return ans;

}


}
