import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class IsValid_20 {



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

//    采用map方法存储

    //    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。

    public boolean isValid1(String s){

        final Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        map.put('?','?');

        if(s.length() > 0 && map.containsKey(s.charAt(0))){
            return false;
        }
        LinkedList<Character>  stack = new LinkedList<Character>();
        stack.add('?');

        for(Character c: s.toCharArray()){
            if( map.containsKey(c)){
                stack.addLast(c);
            }else if(map.get(stack.removeLast()) !=c){
                return false;
            }

        }
        return stack.size() == 1;


    }
    public static void main(String[] args) {

        IsValid_20 is = new IsValid_20();
        String str = "";
        System.out.println(is.isValid(str));


    }
}
