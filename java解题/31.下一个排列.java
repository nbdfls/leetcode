/*
 * @Author: your name
 * @Date: 2021-01-11 14:56:58
 * @LastEditTime: 2021-01-11 15:35:29
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /.leetcode/java解题/31.下一个排列.java
 */
/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 * 
 * 标准的“下一个排列”算法可以描述为：
    1、从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
    2、对 [j,end) 这个区间直接进行排序（升序是最小的排列状态），然后从前往后查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
    3、将 A[i] 与 A[k] 交换
    4、可以断定这时 [j,end) 必然是降序，因为交换的是第一个大于A[i]的元素，因此，A[i]<A[k+1]&&A[i]>A[k-1]
    5、如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
 */

/* Arrays类中包括的方法：
    赋值：fill
    排序：sort
    比较：equals
    查找：binarySearch
 */ 
// @lc code=start
import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for(int i = len-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                Arrays.sort(nums,i,len);
                for(int j = i;j<len;j++){
                    if(nums[j]>nums[i-1]){
                        int temp = nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
}
// @lc code=end

