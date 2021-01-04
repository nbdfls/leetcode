
/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length==0) {
            return false;
        }
        int startC = 0, endC = matrix.length - 1, midC = 0;
        while (startC <= endC) {
            midC = (startC + endC) / 2;
            System.out.println(startC+","+endC+","+midC);
            if(matrix[midC].length==0){
                return false;
            }
            if (matrix[midC][0] > target)
            {
                endC = midC-1 ;}
            else if (matrix[midC][0] < target)
            {
                startC = midC+1;}
            else
                return true;
        }
        if(matrix[midC][0]>target&&midC>=1) midC--;
        System.out.println(midC );
        int[] newM = matrix[midC];
        int startR = 0, endR = matrix[midC].length - 1, midR = 0;
        while (startR <= endR) {
            midR = (startR + endR) / 2;
            if (newM[midR] > target)
                endR = midR -1;
            else if (newM[midR] < target)
                startR = midR +1;
            else {
                return true;
            }
        }
        System.out.println("," + midR);
        if(newM.length==0){
            return false;
        }
        if (newM[midR] == target) {
            return true;
        }

        return false;
    }
}
