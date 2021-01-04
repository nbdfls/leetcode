import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        int index = 0;
        long re = 0,k = 1;

        while(index<str.length()-1&&str.charAt(index)==' '){
            index++;
        }
        char temp = str.charAt(index);
        if(temp=='-'){
            List<Integer> ints =new ArrayList<>();
            index++;
            while(index<str.length()&&str.charAt(index)=='0'){
                index++;
            }
            for(;index<str.length();index++){
                char temp1 = str.charAt(index);
                if(temp1<='9'&&temp1>='0'){
                    ints.add(temp1-'0');
                }else{
                    break;
                }

            }

            if(ints.size()>10){
                return Integer.MIN_VALUE;
            }
            for(int j = ints.size()-1;j>=0;j--){
            
                re = re+k*ints.get(j);
                k*=10;
            }
            if((-re)<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
           
            return (int) ((int) -1 * re);

            
              
        }else if(temp<='9'&&temp>='0'||temp=='+'){
            if(temp=='+'){
                index++;
            }
            List<Integer> ints =new ArrayList<>();
            while(index<str.length()&&str.charAt(index)=='0'){
                index++;
            }
            for(;index<str.length();index++){
                char temp1 = str.charAt(index);
                if(temp1<='9'&&temp1>='0'){
                    ints.add(temp1-'0');
                }else{
                    break;
                }
            }
            if(ints.size()>10){
                return Integer.MAX_VALUE;
            }
            for(int j = ints.size()-1;j>=0;j--){

                re = re+k*ints.get(j);
                k*=10;
            }
            if(re>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
 
            return (int) re;
        }else{
            return 0;  

        }
        
    }
}

