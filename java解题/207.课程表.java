import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;
        int n = prerequisites.length;
        int[] inDigree = new int[numCourses];
        int cnt = 0;

        for(int i = 0;i<n;i++){
            int[] in = prerequisites[i];
            inDigree[in[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inDigree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
    
            int course = queue.poll();
            cnt++;
            List<Integer> pre = pre(prerequisites, course);
       
            for(int i =0;i<pre.size();i++){
                inDigree[pre.get(i)]--;
                if(inDigree[pre.get(i)]==0) {
                    queue.add(pre.get(i));
                }
            }
            
        }
        if(cnt==numCourses)
        return true;
        else 
        return false;
    }
    public List<Integer> pre(int[][] prerequisites,int num){
        int n = prerequisites.length;
        int m = prerequisites[0].length;
        List<Integer> re = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(prerequisites[i][1]==num) re.add(prerequisites[i][0]);
        }
        return re;
    }
}

