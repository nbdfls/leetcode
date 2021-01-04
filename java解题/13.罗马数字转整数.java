/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */
class Solution {
    public int romanToInt(String s) {
       // int res = 0;
        int temp = 0;
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i)=='I'||s.charAt(i)=='X'||s.charAt(i)=='C'){
                if(s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                    temp--;
                }else if(s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                    temp-=10;
                }else if(s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                    temp-=100;
                }else{
                    if(s.charAt(i)=='I'){
                        temp++;
                    }else if(s.charAt(i)=='X'){
                        temp+=10;
                    }
                    else if(s.charAt(i)=='C'){
                        temp+=100;
                    }
                }
            }else{
                if (s.charAt(i)=='V'){
                    temp+=5;
                }else if(s.charAt(i)=='L'){
                    temp+=50;
                }else if(s.charAt(i)=='D'){
                    temp+=500;
                }else if(s.charAt(i)=='M'){
                    temp+=1000;
                }
            }
            
        }
        int len  = s.length()-1;
        if (s.charAt(len)=='V'){
            temp+=5;
        }else if(s.charAt(len)=='L'){
            temp+=50;
        }else if(s.charAt(len)=='D'){
            temp+=500;
        }else if(s.charAt(len)=='M'){
            temp+=1000;
        }else if(s.charAt(len)=='I'){
            temp+=1;
        }else if(s.charAt(len)=='X'){
            temp+=10;
        }else if(s.charAt(len)=='C'){
            temp+=100;
        }
        return temp;
    }
}

