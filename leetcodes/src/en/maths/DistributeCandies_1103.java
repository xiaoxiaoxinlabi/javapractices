package en.maths;

public class DistributeCandies_1103 {

//    我们通过以下方式将一定数量的糖果分配给n = num_people行：
//    然后，我们给第一个人一个糖果，第二个人两个糖果，依此类推，直到最后一个人给n个糖果。
//    然后，我们返回到行的开头，将n + 1个糖果分配给第一个人，将n + 2个糖果分配给第二个人，依此类推，直到将2 * n个糖果分配给最后一个人。
//    重复此过程（每次我们再给一个糖果，并在到达终点后移到行的开头），直到糖果用完。最后一个人将收到我们所有剩余的糖果（不一定比以前的礼物多一个）。
//    返回一个数组（长度为num_people个糖果，总和为糖果），该数组代表糖果的最终分布。

    public int[] distributeCandies(int candies, int num_people) {

        int give = 1, person = 0;
        int [] res = new int[num_people];
        while(candies - give > 0){
            res[(person++)%num_people] += give;
            candies -= give++;
        }
        res[person % num_people] += candies;
        return res;


    }

    public int[] distributeCandies1(int candies, int num_people){
        int [] candyDistribution = new int[num_people];
        int temp = candies;
        int index = 0, counter = 0;
        while(counter < temp){
            candyDistribution[index++] += ++counter;
            temp = temp - counter;

            if(index == num_people){
                index = 0;
            }
        }
        candyDistribution[index++] += temp;
        return candyDistribution;
    }
}
