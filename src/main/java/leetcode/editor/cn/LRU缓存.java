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

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @author wangyanji
 * @date 2022-07-11 16:10:13
 */
public class LRU缓存 {
    public static void main(String[] args) {

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
}

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    /**
     * 节点
     */
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
            this.pre = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }

        public void addHeadNode(Node<K, V> node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = null;
            node.next = null;
        }

        public Node<K, V> getLastNode() {
            return tail.pre;
        }
    }

    int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCache(int capacity) {
        cacheSize = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> integerIntegerNode = map.get(key);
            doubleLinkedList.removeNode(integerIntegerNode);
            doubleLinkedList.addHeadNode(integerIntegerNode);
            return integerIntegerNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> integerIntegerNode = map.get(key);
            integerIntegerNode.value = value;
            map.put(key, integerIntegerNode);
            doubleLinkedList.removeNode(integerIntegerNode);
            doubleLinkedList.addHeadNode(integerIntegerNode);
        } else {
            if (cacheSize == map.size()) {
                //删除尾节点
                Node<Integer, Integer> lastNode = doubleLinkedList.getLastNode();
                doubleLinkedList.removeNode(lastNode);
                map.remove(lastNode.key);
            }
            Node<Integer, Integer> integerIntegerNode = new Node<>(key, value);
            map.put(key, integerIntegerNode);
            doubleLinkedList.addHeadNode(integerIntegerNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)



