/*
 * @lc app=leetcode.cn id=310 lang=cpp
 *
 * [310] 最小高度树
 */
class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        map<int,int> M;
        vector<int> T[n];
        for(int i = 0;i<edges.size();i++){
            int a = edges[i][0];
            int b = edges[i][1];
            T[a].push_back(b);
            T[b].push_back(a);
        }
        vector<int> res;
        queue<int> Q;

        for(int i = 0;i<n;i++){
            Q.push(i);
            M[i] = 1;
            while(!Q.empty()){
                int tmp = Q.front();
                bool flag = true;
                Q.pop();
                for(int j = 0;j<T[tmp].size();j++){
                    Q.push(T[tmp][j]);
                    if(flag)
                     { M[i]++;
                       flag=false;
                     }
                }
            }
            while(!Q.empty()) Q.pop();
            
        }
        int min = 0x7ffff;
        for(int i = 0;i<n;i++){
            if(M[i]<=min){
                min = i;
            }
        }
        for(int i = 0;i<=n;i++){
            if(M[i]==min) res.push_back(i);
        }
            return res;
    
    }
    
};

