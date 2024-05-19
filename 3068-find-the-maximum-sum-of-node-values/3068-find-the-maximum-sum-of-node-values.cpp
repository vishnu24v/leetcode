typedef long long int ll;

const int N = 2e4+1;

ll dp[2][N];
int par[N];

class Solution {
    
    ll K;
    vector<vector<int>> g;
    vector<ll> val;
    
    void CalculateParent(int root, int p) {
        par[root] = p;
        
        for (auto i : g[root]) 
            if (i != p) CalculateParent(i, root);
    }
    
    ll dfs (int src, bool taken) {
        ll &ans = dp[taken][src];
        if (ans != -1) return ans;
        
        ans = 0;
        ll min_diff = 1e18;
        ll best = 0, taken_in_best = 0;
        
        min_diff = min (min_diff, abs(val[src] - (val[src]^K)));
        best += max(val[src], val[src]^K);
        if (val[src] < (val[src]^K)) taken_in_best ++;
        
        for (auto i: g[src]) {
            if (i == par[src]) continue;
            
            ll with = dfs(i, true);
            ll without = dfs(i, false);
            
            min_diff = min(min_diff, abs(with-without));
    
            best += max(with, without);
            if (with > without) taken_in_best ++;
        }
        
        taken_in_best %= 2;
        
        if (taken_in_best == taken) return (ans = best);
        return (ans = best-min_diff);
    }
    
public:
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        memset(dp, -1, sizeof(dp));
        memset(par, -1, sizeof(par));
        g.clear(), g.resize(nums.size());
        val.clear();
        
        for (auto i : nums) val.push_back(i);
        K = k;
        for (auto e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        
        CalculateParent(0, -1);
        return dfs (0, false);
    }
};