/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (35.44%)
 * Total Accepted:    12.7K
 * Total Submissions: 35.7K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList();

        for (int i = 0; i < intervals.size()-1; i++) {
            Interval temp = mergeTwo(intervals.get(i), intervals.get(i + 1));
            if (temp == null) {
                result.add(intervals.get(i));
            } else {
                result.add(temp);
            }
        }
        while(whetherMerge(result)){
            List<Interval> tempResult = result;
            result.clear();
            for(int i = 0;i<tempResult.size()-1;i++){
                Interval temp = mergeTwo(tempResult.get(i), tempResult.get(i+1));
                if(temp == null){
                    result.add(tempResult.get(i));
                }else{
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public Interval mergeTwo(Interval interval1, Interval interval2) {

        if (interval1.start <= interval2.start) {
            if (interval1.end >= interval2.start) {
                Interval res = new Interval();
                res.start = interval1.start;
                res.end = interval2.end;
                return res;
            }
            return null;
        } else {
            if (interval2.end >= interval1.start) {
                Interval res = new Interval();
                res.start = interval2.start;
                res.end = interval1.end;
                return res;
            }
            return null;
        }
    }
    Boolean whetherMerge(List<Interval> intervals){
        for(int i = 0;i<intervals.size()-1;i++){
            if(intervals.get(i).end>=intervals.get(i+1).start){
                return true;
            }
        }
        return false;
    }
}
