public class DefangIPaddr_1108 {

//  给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
//所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。

  public String defangIPaddr1(String address){
    StringBuilder res = new StringBuilder();

    for(int i = 0; i < address.length(); i++){

      if(address.charAt(i)=='.'){
        res.append("[.]");
      }else{
        res.append(address.charAt(i));
      }

    }
    return res.toString();

  }

  public String defangIPaddr2(String address){

    char [] chars = address.toCharArray();
    char [] res = new char[chars.length + 3*2];
    int j = 0;
    for(int i = 0; i < chars.length; i ++){
      if(chars[i] != '.'){
        chars[j] = chars[i];

      }else{
        res[j++] ='[';
        res[j++]='.';
        res[j++]=']';
      }
    }

    return String.valueOf(res);





  }

}
