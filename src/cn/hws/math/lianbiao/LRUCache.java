package cn.hws.math.lianbiao;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。
 * 当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 *      如果此时缓存未满，则将此结点直接插入到链表的头部；
 *      如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 */
public class LRUCache {

    LinkedList<Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = -1;
        Iterator<Node> iterator = cache.iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            if (next.key == key) {
                result = next.val;
                iterator.remove();
                put(key, result);
                break;
            }
        }
        return result;
    }

    public void put(int key, int val) {
        //先遍历查找是否有key 的元素, 有则删除，重新添加到链尾
        Iterator<Node> iterator = cache.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                break;
            }
        }

        if(cache.size() == capacity){
            cache.removeFirst();
        }

        cache.add(new Node(key,val));
    }


    class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
