package juc.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        System.out.println(lruCache.doubleLinkedList);
        lruCache.put(2,2);
        System.out.println(lruCache.doubleLinkedList);
        lruCache.get(1);
        System.out.println(lruCache.doubleLinkedList);
        lruCache.put(2,3);
        System.out.println(lruCache.doubleLinkedList);
        lruCache.put(3,3);
        System.out.println(lruCache.doubleLinkedList);
    }

    public LRUCache(int cap) {
        size = cap;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList();
    }

    int size;
    Map<Integer, Node> map;
    DoubleLinkedList doubleLinkedList;

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            Node node = map.get(k);
            doubleLinkedList.remove(node);
            node.v = v;
            doubleLinkedList.addHead(node);
        } else {
            if (size == map.size()) {
                Node tail = doubleLinkedList.getTail();
                map.remove(tail.k);
                doubleLinkedList.remove(tail);
            }
            Node node = new Node(k, v);
            map.put(k, node);
            doubleLinkedList.addHead(node);
        }

    }//设计模式

    public int get(int k) {
        if (map.containsKey(k)) {
            Node node = map.get(k);
            doubleLinkedList.remove(node);
            doubleLinkedList.addHead(node);
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

    public Node() {

    }

    public Node(int key, int val) {
        k = key;
        v = val;
        pre = next = null;
    }

}

class DoubleLinkedList {
    Node head;
    Node tail;

    @Override
    public String toString(){
        Node temp = head.next;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != tail) {
            stringBuilder.append("[").append(temp.k).append(",").append(temp.v).append("]");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    public DoubleLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = node.next = null;
    }

    public void addHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public Node getTail() {
        return tail.pre;
    }

}