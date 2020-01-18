package tests;

import java.util.Stack;

public class MinStackTest {
//    设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//    push(x) -- 将元素 x 推入栈中。
//    pop() -- 删除栈顶的元素。
//    top() -- 获取栈顶元素。
//    getMin() -- 检索栈中的最小元素。
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();



//    将最大的值放于栈低，最小值放在栈顶
    public void push(int x){
//        如果当前值小于等于min则将min push到stack中，并且把 当前值赋给 min

//        if(){}; if(){}else{}区别


//        if(x <= min){
//            如果if 为true则执行
//            stack.push(min);
//            min = x;
//        }else{
//           如果if为false则执行
//            stack.push(x);
//        }

        if (x <= min){
            stack.push(min);
            min = x;
        }
//        如果当前值大于min，则将当前值push到stack中;
//        注意：stack.push()不论if条件是否为true都会执行（即该语句紧接着if判断后执行）
        stack.push(x);
    }

    public void pop(){
//        如果删除的元素 = min，则将删除的元素赋值给min
        if (stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top(){
//        获取栈顶元素
        return stack.peek();
    }

    public int getMin(){

//        获取最小元素
        return min;
    }


    public static void main(String [] args){
        MinStackTest minStackTest = new MinStackTest();
        minStackTest.push(-2);
        minStackTest.push(0);
        minStackTest.push(-3);
        minStackTest.getMin();
        minStackTest.pop();
        minStackTest.top();
        int min = minStackTest.getMin();
        System.out.println(min);

    }
}


