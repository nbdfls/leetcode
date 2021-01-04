/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {
    public int reverse(int x) {
        long re = 0,k=1;
        String res = String.valueOf(Math.abs(x));
        char[] c_res = new char[res.length()];
        for(int i = res.length()-1,j=0;i>=0;i--,j++){
            c_res[j] = res.charAt(i);
        }
        int zeroIndex = 0;
        while(c_res[zeroIndex]==0){
            zeroIndex++;
        }
        for(int i = res.length()-1;i>=zeroIndex;i--){
            re = re + (c_res[i]-'0')*k;
            k*=10;
        }
        if(x<0) re = re*-1;
        return (int)((re>Integer.MAX_VALUE||re<Integer.MIN_VALUE)?0:re);
    }
}

