package en.strings;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails_929 {

//    每封电子邮件都包含一个本地名称和一个域名，以@符号分隔。
//    例如，在alice@leetcode.com中，alice是本地名称，而leetcode.com是域名。
//    除小写字母外，这些电子邮件还可以包含“。”或“ +”。
//    如果您在电子邮件地址的本地名称部分的某些字符之间添加句点（'。'），则发送到该地址的邮件将转发到相同的地址，本地名称中不带点。例如，“ alice.z@leetcode.com”和“ alicez@leetcode.com”转发到相同的电子邮件地址。 （请注意，此规则不适用于域名。）
//    如果在本地名称中添加加号（'+'），则第一个加号之后的所有内容都将被忽略。这样可以过滤某些电子邮件，例如m.y+name@email.com将转发到my@email.com。 （同样，此规则不适用于域名。）
//    可以同时使用这两个规则。给定电子邮件列表，我们向列表中的每个地址发送一封电子邮件。实际上有多少个不同的地址


//    主要是判断local地址部分
    public int numUniqueEmails1(String [] emails){
       StringBuilder sb = new StringBuilder();
       HashSet<String> set = new HashSet();

       for(String email: emails){
           int at = email.indexOf("@");
           String local = email.substring(0, at);
           String domain = email.substring(at);

//           将邮箱地址按照 @ 截取之后，判断local部分
           for (int i = 0; i < at; i ++){
               if(local.charAt(i) == '.'){
                   continue;
               }else if(local.charAt(i) == '+'){
                   break;
               }else{
                   sb.append(local.charAt(i));
               }
           }

           sb.append(domain);
           set.add(sb.toString());
           sb.setLength(0);
//           sb.delete(0,sb.length());


       }
       return set.size();
    }

    public int numUniqueEmails2(String [] emails){
        Set<String> set = new HashSet();
//        将email中按照 @ 截取 local， domain
        for(String email: emails){
            int at = email.indexOf("@");
            String local = email.substring(0, at);
            String  domain = email.substring(at);
//            并得到email中是否包含 +
            int plusIndex = email.indexOf("+");
//            如果包含，则local 为 当前local 到+出现的地方
            if(plusIndex != -1){
                local = local.substring(0, plusIndex);
            }
//            将local中的. 替换成 空
            String newlocal = local.replace(".", "");

//            replaceAll() 需要使用正则表达式
//            String newlocal = local.replaceAll("\\.", "");
//            将新的local 与domain 拼接起来，并添加到set中
            newlocal+=domain;
            set.add(newlocal);

        }
//        返回set的长度
        return set.size();
    }



}
