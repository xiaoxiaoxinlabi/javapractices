package en.hashTable;

import java.util.Arrays;

public class MyHashMap_706 {

//    在不使用任何内置哈希表库的情况下设计HashMap。
//    具体来说，您的设计应包括以下功能：
//
//    put（key，value）：将（key，value）对插入HashMap中。如果HashMap中已经存在该值，请更新该值。
//    get（key）：返回指定键所映射到的值；如果此映射不包含该键的映射，则返回-1。
//    remove（key）：如果此值包含键的映射，则删除值键的映射

//    int [] map;
//
//    public MyHashMap_706() {
//        map = new int[1000001];
//        Arrays.fill(map, -1);
//    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        map[key] = value;
//
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        return map[key];
//
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        map[key] = -1;
//
//    }


//    ====================方法二=======================

    Node[] buckets;

    static class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int getAddress(int key){
        return key % buckets.length;
    }

    public MyHashMap_706(){
        buckets = new Node[100];
    }

    public void put(int key, int value){
        int index = getAddress(key);
        if(buckets[index] == null){
            buckets[index] = new Node(key, value);
        }else{
            Node temp = buckets[index];

            while(temp.next != null){
                if(temp.key == key){
                    temp.val = value;
                    break;
                }
                temp = temp.next;
            }

            if(temp.key == key){
                temp.val = value;
                return;
            }
            Node n = new Node(key, value);
            temp.next = n;
        }
    }

    public int get(int key){
        int index = getAddress(key);
        if(buckets[index] == null){
            return -1;
        }

        Node temp = buckets[index];
        while(temp != null){
            if(temp.key == key){
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int key){
        int index = getAddress(key);
        if(buckets[index] == null){
            return;
        }
        if(buckets[index].key == key){
            buckets[index] = buckets[index].next;
            return;
        }
        Node prev = null;
        Node prevRef = null;
        Node temp = buckets[index];

        while(temp != null){
            if(temp.key == key){
                prevRef = prev;
                break;
            }

            prev = temp;
            temp = temp.next;
        }
        if(prevRef == null){
            return;
        }else{
            prev.next = prev.next.next;
        }

    }
}
