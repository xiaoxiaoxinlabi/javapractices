package en;

import java.util.Stack;

public class FinalPrices_1475 {
//    给定数组价格，其中price [i]是商店中第i个商品的价格。
//    商店中的商品有特殊折扣，如果您购买第i种商品，则您将获得与price [j]相等的折扣，其中j是最小索引，使得j> i且price [j] <=price[ i]，
//    否则，您将不会获得任何折扣。
//    返回一个数组，其中ith元素是要考虑特殊折扣的商店第ith个商品要支付的最终价格。

    public int [] finalPrices1(int [] prices){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int [] res = new int[prices.length];

//        倒序将数组存入栈中
        for(int i = prices.length - 1; i >=0; i --){
//            如果当前元素小于栈顶元素，则弹出
            while (prices[i] < stack.peek()){
                stack.pop();
            }

//            当前元素减去栈顶元素的值
            res[i] = prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return res;
    }


    public int [] finalPrices2(int [] prices){
        int [] ret = new int[prices.length];
        here:
//        遍历数组
        for(int i = 0; i < prices.length; ++i){
            for(int j = i + 1; j < prices.length; ++j){
//                如果遇到有折扣的，则折扣之后的价格为，当前价格 - 折扣价
                if(prices[i] - prices[j] >= 0){
                    ret[i] = prices[i] - prices[j];
//                    跳到标签处，重新开始
                    continue here;
                }
            }
//            否则商品不打折
            ret[i] = prices[i];
        }
        return ret;
    }

    public int [] finalPrices3(int [] prices){
//        定义一个最终的价格数组
        int [] finalPrices = new int[prices.length];
//        遍历价格数组
        for(int i = 0; i < prices.length; i ++){
//            如果是最后一个值，则不打折，直接赋值给最终价格
            if(i == prices.length - 1){
                finalPrices[i] = prices[i];
                break;
            }

//            否则基于i遍历数组
            for(int j = i+1; j < prices.length; j ++){
//                如果遇到小于当前价格的值，并且索引大于i
                if(prices[j] <= prices[i]){
//                    则进行折扣计算
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
//            将折扣后的价格赋值给最终的价格
            finalPrices[i] = prices[i];
        }
//        返回最终的价格数组
        return finalPrices;
    }
}
