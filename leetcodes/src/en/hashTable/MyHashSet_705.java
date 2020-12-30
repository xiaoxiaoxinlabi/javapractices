package en.hashTable;

public class MyHashSet_705 {


//    在不使用任何内置哈希表库的情况下设计HashSet。
//    具体来说，您的设计应包括以下功能：
//
//    add（value）：将值插入HashSet。
//    contains（value）：返回值是否存在于HashSet中。
//    remove（value）：删除HashSet中的值。如果该值在HashSet中不存在，则不执行任何操作

//    int [] reflect = new int[1000001];
//
//    public MyHashSet_705() {
//
//    }


//    public void add(int key) {
//        if(reflect[key] == 0){
//            reflect[key] = 1;
//        }
//
//    }

//    public void remove(int key) {
//        reflect[key] = 0;
//
//    }

    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        if(reflect[key] != 0){
//            return true;
//        }else{
//            return false;
//        }
//
//    }




//    ========================方法二=======================

    boolean [] hashSet;
    public MyHashSet_705(){
        hashSet = new boolean[1000000];
    }

    public void add(int key){
        hashSet[key] = true;
    }

    public void remove (int key){
        hashSet[key] = false;
    }

    public boolean contains(int key){
        return hashSet[key];
    }

}


