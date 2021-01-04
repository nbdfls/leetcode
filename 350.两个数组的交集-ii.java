import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       List<Integer> result = new ArrayList();
       for(int i=0,j=0;i<nums1.length &&j<nums2.length;){
           if(nums1[i]==nums2[j]){
            result.add(nums1[i]);
            i++;
            j++;
           }
           else if(nums1[i]<nums2[j]){
               i++;
           }else {
               j++;
           }
       }
       int[] m = new int[result.size()];
       for(int i=0;i<result.size();i++){
           m[i]=result.get(i);
       }
       return m;
    }
}

