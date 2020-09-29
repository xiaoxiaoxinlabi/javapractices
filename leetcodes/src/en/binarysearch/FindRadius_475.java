package en.binarysearch;

import java.util.Arrays;

public class FindRadius_475 {
//    冬天来了！比赛期间的第一项工作是设计一个固定半径的标准加热器，以加热所有房屋。
//    现在，您将获得房屋和加热器的位置在一条水平线上，找出加热器的最小半径，以便所有房屋都可以被这些加热器覆盖。
//    因此，您的输入将分别是房屋和加热器的位置，而您的预期输出将是加热器的最小半径标准。
//
//    给出的房屋和取暖器数量是非负数，并且不会超过25000。
//    给出的房屋和加热器的位置为非负数，并且不会超过10 ^ 9。
//    只要房屋在加热器的加热半径范围内，就可以对其进行加热。
//    所有加热器均遵循您的半径标准，并且加热半径将相同。

//    Input: [1,2,3],[2]
//    Output: 1
//    Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
//            通过方法 check 判
            if (check(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private boolean check(int[] houses, int[] hearters, int range) {
        int i = 0, j = 0;
//        依次遍历，判断两个数组相对应的值是否大于 range
        while (i < houses.length && j < hearters.length) {
            if (Math.abs(houses[i] - hearters[j]) > range) {
//                如果大于，则hearters 的索引继续往前
                j++;
            } else {
//                否则houses 的索引往前
                i++;
            }
        }
//        返回索引i 是否等于 houses的长度（即 索引i 是否全部便遍历完）
        return i == houses.length;
    }

    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {

            int startIndex = 0;
            int endIndex = heaters.length - 1;
            int curMinDinstance = Integer.MAX_VALUE;
            while (startIndex <= endIndex) {
                int midPoint = (startIndex + endIndex) / 2;
                if (heaters[midPoint] == houses[i]) {
                    curMinDinstance = 0;
                    break;
                }
                curMinDinstance = Math.min(curMinDinstance, Math.abs(heaters[midPoint] - houses[i]));
                if (houses[i] > heaters[midPoint]) {
                    startIndex = midPoint + 1;
                } else {
                    endIndex = midPoint - 1;
                }
            }
            result = Math.max(result, curMinDinstance);


        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
