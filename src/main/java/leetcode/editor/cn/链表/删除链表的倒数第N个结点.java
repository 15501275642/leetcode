//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2138 👎 0

package leetcode.editor.cn.链表;

import leetcode.editor.cn.common.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author wangyanji
 * @date 2022-07-25 16:38:35
 */
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode listNode = new Solution().removeNthFromEnd1(l1, 4);

        //打印单链表
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        /**
         * 标准答案(未考虑删除坐标超长的问题)
         */
        public ListNode removeNthFromEnd1(ListNode head, int n) {
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;

            ListNode fastIndex = dummyNode;
            ListNode slowIndex = dummyNode;

            // 只要快慢指针相差 n 个结点即可
            for (int i = 0; i <= n; i++) {
                fastIndex = fastIndex.next;
            }

            while (fastIndex != null) {
                fastIndex = fastIndex.next;
                slowIndex = slowIndex.next;
            }

            //此时 slowIndex 的位置就是待删除元素的前一个位置。
            //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
            slowIndex.next = slowIndex.next.next;
            return dummyNode.next;
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (n <= 0) {
                return head;
            }
            //删除需要用到虚拟节点
            ListNode pre = new ListNode(-1, head);
            //快指针
            ListNode fast = head;
            //慢指针
            ListNode slow = head;
            ListNode preSlow = pre;

            //先让快指针走n步
            for (int i = 0; i < n; i++) {
                if (fast == null) {
                    return head;
                }
                fast = fast.next;
            }
            //快指针和慢指针一起走直到快指针到队尾
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
                preSlow = preSlow.next;
            }
            //慢指针就是需要删除的目标节点, 删除
            preSlow.next = slow.next;
            return pre.next;
        }
    }

    public static class ListNode {
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
//leetcode submit region end(Prohibit modification and deletion)

}


