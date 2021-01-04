/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */
class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        StringBuffer res = new StringBuffer();
        for(int i =a.length()-1,j=b.length()-1;(i>=0&&j>=0);i--,j--){
            
                int temp1 = a.charAt(i)-'0',temp2 = b.charAt(j)-'0';
                if(carry)
                temp1 = temp1+temp2+1;
                else{
                    temp1 = temp1+temp2;
                }
                int indexRes = temp1%2;
                res.insert(0,indexRes);
                if(temp1/2>0){
                    carry = true;
                }else{
                    carry = false;
                }
        }
        int min = Math.min(a.length(), b.length());
        int max = Math.max(a.length(), b.length());
        int index = max-min-1;
        if(a.length()>b.length()){
            if(carry){
                while(index>=0&&carry){
                    
                    int re = a.charAt(index)-'0'+1;
                    int indexRes = re%2;
                    res.insert(0,indexRes);
                     if(re/2>0){
                    carry = true;
                     }else{
                    carry = false;      
                    }
                    index--;
                }
            }else{
                while(index>=0){
                    res.insert(0, a.charAt(index)-'0');
                    index--;
                }
            }
        }else if(b.length()>a.length()){
            if(carry){
                while(index>=0&&carry){
                    
                    int re = b.charAt(index)-'0'+1;
                    int indexRes = re%2;
                    res.insert(0,indexRes);
                     if(re/2>0){
                    carry = true;
                     }else{
                    carry = false;      
                    }
                    index--;
                }
        }
        else{
            while(index>=0){
                res.insert(0, b.charAt(index)-'0');
                index--;
            }
        }
    }
        
    if(a.length()>b.length()){
            while(index>=0){
                res.insert(0, a.charAt(index)-'0');
                index--;
            }
        
    }else{
       
        while(index>=0){
            res.insert(0, b.charAt(index)-'0');
            index--;
        }
    
    }
    if(carry){
        res.insert(0, 1);
    }
       
        return res.toString();
    }
}

