/*
 * @Author: fanfan
 * 从外向内，一层一层进行旋转，将边分成四分，每一分为边长-1
 */
class Solution {
    public void rotate(int[][] matrix) {
        // if(matrix.length == 0 || matrix.length != matrix[0].length) {
        //     return;
        // }
        int depth = 0;
        int len = matrix.length;
        while(depth<(len/2)){
            int tempLen = len-depth*2;
            for(int i = 0;i<tempLen;i++){
                int temp = matrix[depth][depth+i];
                matrix[depth][depth+i]=matrix[depth+tempLen-1-i][depth];
                matrix[depth+tempLen-1-i][depth]=matrix[depth+(tempLen-1)][depth+(tempLen-1-i)];
                matrix[depth+(tempLen-1)][depth+(tempLen-1-i)]=matrix[depth+i][depth+tempLen-1];
                matrix[depth+i][depth+tempLen-1]=temp;
            }  
            int temp = matrix[depth+tempLen-1][depth];
            matrix[depth+tempLen-1][depth] = matrix[depth][depth];
            int temp1 = matrix[depth+(tempLen-1)][depth+(tempLen-1)];
            matrix[depth+(tempLen-1)][depth+(tempLen-1)] = temp;
            int temp2 = matrix[depth][depth+tempLen-1];
            matrix[depth][depth+tempLen-1] = temp1;
            matrix[depth][depth]=temp2;

            depth++;
        }
       

    }
}