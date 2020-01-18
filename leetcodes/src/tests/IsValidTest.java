package tests;

import java.util.Stack;

public class IsValidTest {


    public boolean isValid(String str) {
        if (str.length() == 0 ) {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));

            } else {
                if (stack.size() == 0) {
                    return false;
                }

                    char top = stack.pop();
                if (str.charAt(i) == ')') {
                    if (top != '(') {
                        return false;
                    }
                } else if (str.charAt(i) == '}') {
                    if (top != '{') {
                        return false;
                    }
                } else if (str.charAt(i) == ']') {
                    if (top != '[') {
                        return false;
                    }
                }

            }
        }

        return stack.size() == 0;

    }

    public static void main(String[] args) {

        IsValidTest is = new IsValidTest();
        String str = "";
        System.out.println(is.isValid(str));


    }
}
