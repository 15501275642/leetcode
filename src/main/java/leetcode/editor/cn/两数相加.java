//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 8391 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

/**
 * 两数相加
 *
 * @author wangyanji
 * @date 2022-07-25 10:04:52
 */
public class 两数相加 {
    public static void main(String[] args) {
        Solution solution = new 两数相加().new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode head = null;
            ListNode listNode = null;
            while (l1 != null || l2 != null || carry > 0) {
                int v1 = l1 != null ? l1.val : 0;
                int v2 = l2 != null ? l2.val : 0;
                //相加
                int sum = v1 + v2 + carry;
                //本位
                int i = sum % 10;
                //进位
                carry = sum / 10;
                if (listNode != null) {
                    listNode.next = new ListNode(i);
                    listNode = listNode.next;
                } else {
                    listNode = head = new ListNode(i);
                }
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


