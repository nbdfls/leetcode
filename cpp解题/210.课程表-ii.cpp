/*
 * @lc app=leetcode.cn id=210 lang=cpp
 *
 * [210] 课程表 II
 */
class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        int inDegree[numCourses]={0};
 //    int map[numCourses][numCourses];
      //  int sMap[numCourses];
        queue<int> Q;
        vector<int> res;
        int num = 1;
        vector<int> edge[numCourses];
        for(int i = 0;i<numCourses;i++){
            inDegree[prerequisites[i][0]]++;
            //map[prerequisites[i][1]][prerequisites[i][0]] = 1;
            edge[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                Q.push(i);
                res.push_back(i);
            }
        }
        while(!Q.empty()){
            int tmp = Q.front();
            Q.pop();
            num++;
            for(int i = 0;i<edge[tmp].size();i++){
                inDegree[edge[tmp][i]]--;
                if(inDegree[edge[tmp][i]]==0){
                    Q.push(edge[tmp][i]);
                    res.push_back(edge[tmp][i]);
                }
            }
            
        }
        if(num==numCourses){
            return res;
        }else{
            return  res;
        }

    }
private:
   
};

