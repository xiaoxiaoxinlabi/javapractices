package en.strings;

public class ToLowerCase_709 {

//    实现具有字符串参数str的函数ToLowerCase（），并以小写形式返回相同的字符串。

    public String toLowerCase1(String str){

        StringBuilder res = new StringBuilder();


        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                int tmp = str.charAt(i) + 32;

                res.append((char) tmp);
            }else{
                res.append(str.charAt(i));
            }
        }

        return res.toString();


    }

    public String toLowerCase2(String str){
        String res = "";
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) >='A' && str.charAt(i) <='Z'){
                char c = (char) (str.charAt(i) + 32);
                res+=c;
                continue;
            }
            res+=str.charAt(i);
        }
        return res;
    }

    public String toLowerCase3(String str){
        char [] strArray = str.toCharArray();
        for(int i = 0; i < strArray.length; i ++){
            if(strArray[i] <=90 && strArray[i] >=65){
                strArray[i]+=32;
            }
        }
        return new String(strArray);
    }
}
