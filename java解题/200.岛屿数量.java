/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */
class Solution {
    int go[] = {1,0,-1,0,0,1,0,-1};
    int n,m;
    int ans = 0;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        n  = grid.length;
        m = grid[0].length;
        boolean[][] mark = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mark[i][j]==true) continue;
                if(grid[i][j]=='0') continue;
                DFS(i, j, grid, mark);
                ans++;
            }
        }
        return ans;

    }
    public void DFS(int x,int y,char[][] grid,boolean[][] mark){
        for(int i = 0;i<=3;i++){
            int nx = x + go[i*2];
            int ny = y + go[i*2+1];
            if(nx<0||nx>n-1||ny<0||ny>m-1) continue;
            
            if(grid[nx][ny]=='0') continue;
            if(mark[nx][ny]==true) continue;
            
            mark[nx][ny] = true;
            DFS(nx, ny, grid, mark);
            
        }
    }
}

