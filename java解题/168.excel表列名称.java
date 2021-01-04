/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */
class Solution {
    public String convertToTitle(int n) {
        StringBuilder re = new StringBuilder();
        while(n>0){
            n--;
            re.insert(0,(char)('A'+n%26));
            n/=26;
        }
        return re.toString();
    }
}

