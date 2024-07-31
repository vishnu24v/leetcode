class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length];
        Arrays.fill(dp, -1);
        int ans = solve(0, books, shelfWidth, dp);
        return ans;
    }
    private int solve(int i,int[][] books, int shelfWidth, int[] dp){
        if(i>=books.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int width=0, maxH=0;
        int ans=Integer.MAX_VALUE;
        for(int j=i;j<books.length;j++){
            width+=books[j][0];
            if(width>shelfWidth) break;
            maxH = Math.max(maxH, books[j][1]);
            ans = Math.min(maxH + solve(j+1, books, shelfWidth,dp),ans);
        }
        return dp[i]=ans;
    }
}