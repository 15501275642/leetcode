//你可以选择使用单链表或者双链表，设计并实现自己的链表。 
//
// 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。 
//
// 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。 
//
// 实现 MyLinkedList 类： 
//
// 
// MyLinkedList() 初始化 MyLinkedList 对象。 
// int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。 
// void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。 
// void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。 
// void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 
//index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。 
// void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", 
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//输出
//[null, null, null, null, 2, null, 3]
//
//解释
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//myLinkedList.get(1);              // 返回 2
//myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//myLinkedList.get(1);              // 返回 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。 
// 
//
// Related Topics 设计 链表 👍 992 👎 0

package leetcode.editor.cn.链表;

/**
 * 设计链表
 *
 * @author wangyanji
 * @date 2024-01-31 16:06:52
 */
public class 设计链表 {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyLinkedList {
        int size;
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode();
        }

        /**
         * 获取第几个节点的值
         *
         * @param index 目标坐标
         */
        public int get(int index) {
            if (index < 0 || index > size - 1) {
                return -1;
            }
            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * 头插入节点
         *
         * @param val 节点值
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * 尾插入节点
         *
         * @param val 节点值
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * 在第n个节点前插入节点
         *
         * @param val 节点值
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size ++;
            //找到添加元素的位置
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode newListNode = new ListNode(val);
            newListNode.next = pre.next;
            pre.next = newListNode;
        }

        /**
         * 删第n个节点
         *
         * @param index 节点坐标
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index > size - 1) {
                return;
            }
            size--;
            ListNode pre = null;
            ListNode cur = head;
            for (int i = 0; i <= index ; i++) {
                pre = cur;
                cur = cur.next;
            }
            //cur为要删除的元素
            pre.next = cur.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}