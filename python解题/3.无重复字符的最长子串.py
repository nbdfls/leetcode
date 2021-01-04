#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
# 哈希表中存放的是每一个英文字符在字符串中的index，在遍历过程中，如果字符在
# 哈希表中并且该字符对应的位置在开始标记之后，就需要更新开始计数的位置，如果不在，则用当前位置减去开始标记计算最大长度即可。
# 

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = {}
        start = maxLength = 0
        for i,c in enumerate(s):
            if c in hashmap and start<=hashmap[c]:
                start = hashmap[c]+1
            else:
                maxLength = max(maxLength,i - start+1)
            hashmap[c]=i
        print(hashmap)
        return maxLength
# @lc code=end

