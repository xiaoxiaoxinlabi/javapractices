package en.strings;

public class DefangIPaddr_1108 {

//    给定有效的（IPv4）IP地址，请返回该IP地址的脱机版本。
//
//    脱位的IP地址将替换每个句点“”.与“ [.]”。

    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < address.length(); i ++){
            if(address.charAt(i) == '.'){
                res.append('[');
                res.append('.');
                res.append(']');
            }else{
                res.append(address.charAt(i));

            }
        }

        return res.toString();

    }

    public String defangIPaddr1(String address){
        StringBuilder res = new StringBuilder();
        for(char c :address.toCharArray()){
            if(c == '.'){
                res.append("[.]");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

    public String defangIPaddr2(String address){
        String newaddress = address.replace(".", "[.]");
        return newaddress;
    }

    public String defangIPaddr3(String address){
        StringBuilder res = new StringBuilder();
        int i = 0;
        boolean break1 = true;
        while(break1){
//            从i开始查找点号出现的位置的索引
            int index = address.indexOf('.',i);
            if(index == -1){
                break1 = false;
            }else{
//                如果存在点号，则将 address 截取从i 到出现点号的索引处 并与 新的值拼接，然后添加到res中
                res.append(address.substring(i, index) + "[.]");
//                i 的值变更为当前找到点号的位置的后一个位置
                i = index + 1;
            }
        }
//        最后将最后一个点号之后的字符串的值添加到res中，并转换为字符串返回
        res.append(address.substring(i, address.length()));
        return res.toString();
    }


}
