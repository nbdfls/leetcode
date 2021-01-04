/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0,costSum = 0;
        for(int i = 0;i<gas.length;i++){
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(gasSum<costSum){
            return -1;
        }
        int acu = 0,start = 0;
        for(int i = 0;i<gas.length;i++)
        {
           int curAcu = gas[i]-cost[i];
           if(acu+curAcu<0){
               start = i+1;
               acu = 0;
           } 
           else{
            acu+=curAcu;
           }
        }
        return start;
    }
}

