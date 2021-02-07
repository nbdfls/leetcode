/*
 * @Author: fanfan
 */
//两种做法：将key设为单词，或者将key设置为字母的出现次数
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> end = new ArrayList<>();
        Map<String, List<String>> res = new HashMap<>();
        for(String temp:strs){
            char[] sc = temp.toCharArray();
            Arrays.sort(sc);

            String key = new String(sc);
            List<String> l = res.getOrDefault(key, new ArrayList<String>());
            l.add(temp);
            res.put(key,l);
        }
        return new ArrayList<List<String>>(res.values());
    }
}