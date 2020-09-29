package en.binarysearch;

public class FirstBadVersion_278 {

//    您是产品经理，目前正在领导团队开发新产品。不幸的是，您产品的最新版本未通过质量检查。由于每个版本都是基于先前版本开发的，因此错误版本之后的所有版本也都是错误的。
//    假设您有n个版本[1、2，...，n]，并且想找出第一个不良版本，这将导致随后的所有不良版本。
//    您将获得一个API bool isBadVersion（version），它将返回版本是否错误。实现一个功能以查找第一个不良版本。您应该减少对API的调用次数。

    public int firstBadVersion(int n) {

        int left = 0, right = n;

        while(left < right){

            int mid = left +(right - left)/2;
            if(isBadVersion(mid)){
//                找到的是最后一个不良值，一直往左，直到找到第一个
                right = mid;
            }else{
                left = mid + 1;
            }
            if(left == right){
                break;
            }
        }
        return left;

    }
    private boolean isBadVersion(int n){
        return false;
    }
}
