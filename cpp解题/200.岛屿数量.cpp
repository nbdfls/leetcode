/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 */

class Solution {

public:
  
    int numIslands(vector<vector<char>>& grid) {
    int row = grid.size();
    int clo = grid[0].size();
   int ans = 0;
    for(int i =0;i<row;i++){
        for(int j = 0;j<clo;j++){
            
            if(grid[i][j]=='1'){
                ans++;
                queue<pair<int,int>> Q;
                grid[i][j] = '0';
                Q.push(make_pair(i,j));
                while(!Q.empty()){
                    pair<int,int> tmp = Q.front();
                    Q.pop();
                    for(int k=0;k<4;k++){
                        int r = tmp.first+dis[k],c = tmp.second+dis[k+1];
                        if(r>=0&&r<=row-1&&c>=0&&c<clo&&grid[i][j]=='1'){
                            Q.push({r,c});
                            grid[r][c] = 0;
                        }
                    }
                }

            }
        }
    }
    return ans;
    }
   
private:
    int dis[5] = {0,1,0,-1,0};
    



};
