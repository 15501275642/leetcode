////////请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
////////
//////// 实现 LRUCache 类：
////////
////////
////////
////////
//////// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
//////// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//////// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插
//入该
////组
//////
////////key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
////////
////////
//////// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
////////
////////
////////
////////
////////
//////// 示例：
////////
////////
////////输入
////////["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get",
////"get"]
////////[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
////////输出
////////[null, null, null, 1, null, -1, null, -1, 3, 4]
////////
////////解释
////////LRUCache lRUCache = new LRUCache(2);
////////lRUCache.put(1, 1); // 缓存是 {1=1}
////////lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
////////lRUCache.get(1); // 返回 1
////////lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
////////lRUCache.get(2); // 返回 -1 (未找到)
////////lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
////////lRUCache.get(1); // 返回 -1 (未找到)
////////lRUCache.get(3); // 返回 3
////////lRUCache.get(4); // 返回 4
////////
////////
////////
////////
//////// 提示：
////////
////////
//////// 1 <= capacity <= 3000
//////// 0 <= key <= 10000
//////// 0 <= value <= 10⁵
//////// 最多调用 2 * 10⁵ 次 get 和 put
////////
//////// Related Topics 设计 哈希表 链表 双向链表 👍 2263 👎 0
//////
////
//

package leetcode.editor.cn.链表;



import java.util.*;
import java.util.stream.Collectors;

/**
 * LRU 缓存
 *
 * @author wangyanji
 * @date 2022-07-11 16:10:13
 */
public class LRUCache {
    public static void main(String[] args) {


        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        Set<Integer> intersection = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toSet());
        System.out.println(intersection);

        list1.removeAll(intersection);
        list2.removeAll(intersection);
        LRUCache lruCacheDemo = new LRUCache(3);
        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        //[1, 2, 3]
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(4, 1);
        //[2, 3, 4]
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3, 1);
        //[2, 3, 4]
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        //[2, 3, 4]
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        //[2, 3, 4]
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 1);
        //[2, 3, 4]
        System.out.println(lruCacheDemo.map.keySet());
    }

    /**
     * 容量
     */
    int size;
    /**
     * map
     */
    Map<Integer, Node> map;
    /**
     * 双向链表
     */
    DoubleLinkedList doubleLinkedList;


    public LRUCache(int size) {
        this.size = size;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList();

    }
    public void put(int k, int v) {
        //判断k是否存在
        Node node = map.get(k);
        if (map.containsKey(k)) {
            //存在
            //删除节点
            //挂节点
        }else {

        }


    }

    public int get(int k) {
        if (map.containsKey(k)) {
            Node node = map.get(k);
            //删除节点
            //添加到头部
            return node.v;
        }
        return -1;
    }

}

class Node {
    int k;
    int v;
    Node pre;
    Node next;


}

class DoubleLinkedList {
    Node head;
    Node tail;


    /**
     * 删除节点
     */
    private void delNode(Node node){

    }

    /**
     * 获取节点
     */
    private void getNode(){

    }

    /**
     * 添加到头部
     */
    private void addHead(){

    }

}




