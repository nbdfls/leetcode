/*
 * @Author: lishui fan
 * @Date: 2021-02-08 11:08:20
 * @LastEditors: your name
 * @LastEditTime: 2021-03-10 14:05:46
 * @Description: 滑动窗口
 */
/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {

    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    public String minWindow(String s, String t) {
        
        int tLen = t.length();//目标字符串
        int sLen = s.length();
        if(tLen == 0 || sLen==0) return "";

        //先把t中的字符放到need表中，计数
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE, start = 0;
        int valid = 0; //已经匹配成功的字符种类数（非字符个数）

        //当右指针去到字符串末尾前
        while (right < sLen) {
            char c = s.charAt(right);
            right++;//右指针向右滑

            //如果右指针现在滑到的字符是目标字符串的一个，那么更新窗口中的数据
            if (need.containsKey(c)) {

                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            
            //窗口开始从左边收缩
            while (valid == need.size() ) {
                if (right - left  < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                //如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，                   
                //就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即valid-1 
                if (need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// class Solution {
//     public String minWindow(String s, String t) {
//         if(s == null || s=="" ||t=="" || t==null||s.length()<t.length()){
//             return "";
//         }
//          //维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数         
//          //ASCII表总长128
//          int[] need = new int[128];
//          int[] have = new int[128];

//          //记录目标字符串指定字符的出现次数
//          for(int i = 0;i<t.length();i++){
//              need[t.charAt(i)]++;
//          }
//          //左指针，右指针，子串最小长度
//          int left = 0,right = 0,min = s.length()+1;
//         //已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置 
//          int count = 0,start = 0;
//          while(right<s.length()){
//              char r = s.charAt(right);
//               //说明该字符不被目标字符串需要，此时有两种情况             
//               // 1.循环刚开始，那么直接移动右指针即可，不需要做多余判断            
//                // 2.循环已经开始一段时间，此处又有两种情况             
//                //  2.1 上一次条件不满足，已有字符串指定字符出现次数不满足目标字符串指定字符出现次数，
//                //那么此时如果该字符还不被目标字符串需要，就不需要进行多余判断，右指针移动即可            
//                 //  2.2 左指针已经移动完毕，那么此时就相当于循环刚开始，同理直接移动右指针
//              if(need[r]==0){
//                 right++;
//                 continue;
//              }
//              //当且仅当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1             /
//              //是为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符，不需要挨个比对字符出现的次数
//              if(have[r]<need[r]){
//                  count++;
//              }
//              //已有字符串中目标字符出现次数+1
//              have[r]++;
//              //右指针移动
//              right++;
//                //当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
//              while(count==t.length()){
//                  //当窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
//                  if(right-left<min){
//                      min = right-left;
//                      start = left;
//                  }
//                  char l = s.charAt(l);
//                  if(need[l]==0){
//                      left++;
//                      continue;
//                  }
//                   //如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
//                  //就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次(count）-1 
//                  if(have[l]==need[l]){
//                      count--;
//                  }
//                  //已有字符串中目标字符出现的次数-1
//                  have[l]--;
//                  left++;
//              }
//          }
//          if(min==s.length()+1){
//              return "";
//          }
//          return s.substring(start, start+min);
         

//     }
// }
// // @lc code=end

