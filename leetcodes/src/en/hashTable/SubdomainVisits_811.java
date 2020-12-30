package en.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits_811 {
//    诸如“ discuss.leetcode.com”之类的网站域由多个子域组成。在顶层，我们拥有“ com”，在下一层，我们拥有“ leetcode.com”，在最低层，我们拥有“ discuss.leetcode.com”。当我们访问“ discuss.leetcode.com”之类的域时，我们还将隐式访问父域“ leetcode.com”和“ com”。
//    现在，将“计数配对的域”称为一个计数（代表该域收到的访问次数），然后是一个空格，然后是地址。计数配对域的一个示例可能是“ 9001 describe.leetcode.com”。
//    我们给出了计数配对域的列表cpdomains。我们想要一个成对计数的域列表（以与输入相同的格式，并且以任意顺序），该列表明确地计算了每个子域的访问次数。

//    Example 1:
//    Input:
//            ["9001 discuss.leetcode.com"]
//    Output:
//            ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]


    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();

        for(String domain: cpdomains){
            String [] temp = domain.split(" ");
            int cnt = Integer.valueOf(temp[0]);

            int index = 0;
            String basedomain = temp[1];

            while(index != -1){
                map.put(basedomain, map.getOrDefault(basedomain, 0) + cnt);
                index = basedomain.indexOf(".");
                basedomain = basedomain.substring(index+1);
            }
        }

        List<String> out = new ArrayList();
        for(String key : map.keySet()){
            out.add(new StringBuilder().append(map.get(key)).append(" ").append(key).toString());
        }

        return out;

    }


}
