class Solution {
public:
    int minRectanglesToCoverPoints(vector<vector<int>>& points, int w) {
        vector<pair<int,int>>v;
        for(auto it:points)
        {
            v.push_back({it[0],it[1]});
        }
        sort(v.begin(),v.end());
        int ans=1;
        int cur=v[0].first;
        for(int i=1;i<v.size();i++)
        {
            if(v[i].first<=cur+w){continue;}
            else 
            {
                ans++;
                cur=v[i].first;
            }
        }
        return ans;
    }
};