#include<iostream>
#include<vector>
using namespace std;
int dp[5000];
int coin[5000];
int max(int a,int b) {return a>b?a:b;}
int main(){
    int amount;
    int coins;
    while(cin>>amount>>coins){
        for(int i = 0;i<coins;i++){
            cin>>coin[i];
        }
        for(int i = 0;i<amount;i++){
            dp[i] = 0;
        }
        for(int i = 0;i<coins;i++){
            for(int j = coin[i];j<amount;j++){
                dp[j] = max(dp[j],dp[j-coin[i]]+coin[i]);
            }
        }
        
    }
}