package leetcode.editor.cn.双指针;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2129 👎 0

import java.util.Arrays;

public class 移动零{
	public static void main(String[] args) {
		Solution solution = new 移动零().new Solution();
		int[] nums = {0, 1, 0, 3, 12};
		//solution.moveZeroes(nums);
		solution.moveZeroes2(nums);
		System.out.println(Arrays.toString(nums));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
		if (nums == null) {
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			//从前往后找到第一个0
			int num = nums[i];
			if (num == 0) {
				//接着找到一个不是0的数
				for (int y = i + 1; y < nums.length; y++) {
					int num1 = nums[y];
					if (num1 != 0) {
						//将r和i交换
						changeArr(nums, i, y);
						break;
						//1,0,0,3,12
					}
				}
			}
		}
    }

	public void moveZeroes2(int[] nums) {
		if (nums == null) {
			return;
		}
		int currIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			//从前往后找到第一个0
			int num = nums[i];
			if (num != 0) {
				if (currIndex != i) {
					changeArr(nums, currIndex, i);
				}
				currIndex++;
			}
		}
	}

	private void changeArr(int [] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
