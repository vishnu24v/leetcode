int dp[100005][27];
class Solution {
public:
    int n,k;
    string s;
    int rec(int i,int last){
        if(i==n) return 0;
        if(dp[i][last]!=-1) return dp[i][last];
        int ans=0;
        if(last==26 or abs(s[i]-'a'-last)<=k) ans=rec(i+1,s[i]-'a')+1;  
        ans=max(ans,rec(i+1,last));
        return dp[i][last]=ans;
    }
    int longestIdealString(string s, int k) {
        n=s.length();
        this->k=k;
        this->s=s;
        for(int i=0;i<n;i++) for(int j=0;j<27;j++) dp[i][j]=-1;
        return rec(0,26);
    }
};