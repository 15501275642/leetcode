//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5029 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author wangyanji
 * @date 2022-07-25 15:59:30
 */
public class 三数之和 {
    public static void main(String[] args) {
        Solution solution = new 三数之和().new Solution();
        int[] nums = {3, 5, 4, 2, 1, 4};
        System.out.println(Arrays.toString(nums));
        solution.quickSort(nums, 0, nums.length - 1);
        System.out.println();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            //校验
            if (nums == null || nums.length < 3) {
                return res;
            }
            int length = nums.length;
            //排序
            quickSort(nums, 0, length - 1);
            //遍历数组所有元素, 当遍历到(倒数第二个的时候)就没有必要接着遍历了
            for (int i = 0; i < length - 2; i++) {
                //定义temp
                int temp = nums[i];
                //保证不重复
                if (i > 0 && temp == nums[i - 1]) continue;
                //定义接下来的左右指针
                int left = i + 1, right = length - 1;
                //需要求得目标和
                int target = -temp;
                while (left < right) {
                    int leftValue = nums[left], rightValue = nums[right];
                    int sum = leftValue + rightValue;
                    if (sum == target) {
                        //添加到结果集中
                        res.add(Arrays.asList(-target, leftValue, rightValue));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;
        }


        public void quickSort(int[] nums, int left, int right) {
            //校验
            if (left > right) return;
            //i < j
            int i = left, j = right;
            int temp = nums[left];
            while (i < j) {
                //从右向左找个第一个比temp小的值
                while (temp <= nums[j] && i < j) {
                    j--;
                }
                //从左向右找到第一个比temp大的值
                while (temp >= nums[i] && i < j) {
                    i++;
                }
                //判断i<j
                if (i < j) {
                    //找到了就交换
                    swap(nums, i, j);
                }
            }
            //最后和中间值交换
            swap(nums, left, i);
            //递归调用左边 调用quickSort(nums, left, right)
            quickSort(nums, left, i - 1);
            //递归调用右边 调用quickSort(nums, left, right)
            quickSort(nums, i + 1, right);
        }

        public void swap(int[] nums, int a, int b) {
            if (a == b) return;
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


