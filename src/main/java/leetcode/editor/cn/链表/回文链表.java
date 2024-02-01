//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1831 👎 0

package leetcode.editor.cn.链表;

/**
 * 回文链表
 *
 * @author wangyanji
 * @date 2023-12-18 17:43:03
 */
public class 回文链表{
    public static void main(String[] args) {
        ListNode l4 = new ListNode(1, null);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        Solution solution = new 回文链表().new Solution();
        boolean palindrome = solution.isPalindrome(l1);
        System.out.println(palindrome);
    }
//leetcode submit region begin(Prohibit modification and deletion)


static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return check(head);
    }

    public boolean check(ListNode node) {
        if (node != null) {
            if (!check(node.next)) {
                return false;
            }
            if (frontPointer.val != node.val) {
                return false;
            }
            frontPointer = frontPointer.next;
            return true;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}