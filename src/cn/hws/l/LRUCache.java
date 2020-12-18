package cn.hws.l;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    Map<Integer,Integer> map;
    //队列，对首是越久未使用的，对尾是最近使用的
    Queue<Integer> queue;
    int cap;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.cap = capacity;
    }

    public int get(int key) {
        //如果key存在，移除重新添加就能靠近队尾
        if(queue.contains(key)){
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        //如果使用的是已经存在的key
        if(queue.contains(key)){
            queue.remove(key);
            queue.add(key);
            map.put(key,value);
            //如果缓存已经满了，删除最久未使用的
        }else if(cap == 0){
            map.remove(queue.poll());
            queue.add(key);
            map.put(key,value);
        }else{
            //有空闲的位置，第一次添加，直接添加进去
            queue.add(key);
            map.put(key,value);
            cap--;
        }
    }
}
