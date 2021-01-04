/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        if (strs == null || strs.length == 0) {
            return "";
        }
        String tempStr = strs[0];
        for(int i = 1;i<count;i++){
            tempStr = commonPrex(tempStr,strs[i]);
            if(tempStr.length()==0){
                return tempStr;
            }
        }
        
        return tempStr;
    }
    private String commonPrex(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        String prex = new String();
        int index = 0;
        for(int i = 0;i<length;i++){
            if(str1.charAt(i)==str2.charAt(i)){
                index++;
            }else{
                break;
            }
        }
        return str1.substring(0,index);
    }

}
// @lc code=end

