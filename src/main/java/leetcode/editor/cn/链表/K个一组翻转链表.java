//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1862 👎 0

package leetcode.editor.cn.链表;

/**
 * K 个一组翻转链表
 *
 * @author wangyanji
 * @date 2022-12-06 15:41:12
 */
public class K个一组翻转链表 {
    public static void main(String[] args) {
        Solution solution = new K个一组翻转链表().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = solution.reverseKGroup(l1, 3);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            //计算head的长度
            ListNode countHead = head;
            //计数器
            int count = 0;
            while (countHead != null) {
                countHead = countHead.next;
                count++;
            }
            //如果长度小于k，直接返回
            if (count < k) {
                return head;
            }
            //设置新头结点
            ListNode newHead = head;
            //设置头结点的下一个结点，交换结点后头结点可以找到原始链表的下一个结点
            ListNode nextHead = head.next;
            //设置标记，只有第一次将头结点放在尾结点的后面时使用递归
            boolean flag = true;
            //设置尾结点，为第k个结点
            ListNode tail = head;
            for (int i = 0; i < k - 1; i++) {
                tail = tail.next;
            }
            //循环k-1次将链表反转，尾插法
            for (int i = 0; i < k - 1; i++) {
                if (flag) {
                    //利用尾插法，依次将头结点插入tail后面，头节点指向下一组
                    newHead.next = reverseKGroup(tail.next, k);
                    flag = false;
                } else {
                    newHead.next = tail.next;
                }
                //2 -> 3 -> 1 -> 4 -> 5
                tail.next = newHead;
                //头结点变成原来头结点下一个
                head = nextHead;
                //头结点下一个往下走
                nextHead = nextHead.next;
                //
                newHead = head;
            }
            //反转结束后，尾结点为第一个了，返回就行
            return tail;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}