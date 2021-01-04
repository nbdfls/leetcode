import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        String re = new String();
        Queue<String> queue = new LinkedList<>();
        boolean[] indexs = new boolean[wordList.size()];
        List<List<String>> wrapList =  new LinkedList<>();
        queue.offer(beginWord);
       
        while(!queue.isEmpty()){
            int size = queue.size();
            List<String> subList = new LinkedList<>();
           
            while(size>0){
                String now = queue.element();
                for(int i = 0;i<wordList.size();i++){
                    if(indexs[i]){
                        continue;
                    } 
                    if(diff(now,wordList.get(i))==0) continue;
                    if(diff(now, wordList.get(i))==1){
                        queue.offer(wordList.get(i));
                        indexs[i] = true;
                        if(wordList.get(i).equals(endWord)){
                            re = wordList.get(i);
                            break;
                        }
                           
                        subList.add(queue.peek());
                       
                    }
                }
                queue.poll();
                size--;
            }
            wrapList.add(subList);
            if(re.equals(endWord)){
                return wrapList.size()+1;
            }
        }

        return 0;
    }
    public int diff(String word1,String word2){
        int diff = 0;
        for(int i = 0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
}

