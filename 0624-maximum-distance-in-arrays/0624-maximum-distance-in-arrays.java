class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
       int m =arrays.size();
        int minval = arrays.get(0).get(0);
        int maxval = arrays.get(0).get(arrays.get(0).size()-1);
        
        int maxDistance=0;
        for(int i=1;i<m;i++){
            List<Integer> array = arrays.get(i);
            maxDistance = Math.max(maxDistance, Math.abs(array.get(array.size()-1)-minval));
            maxDistance = Math.max(maxDistance, Math.abs(maxval-array.get(0)));
            minval=Math.min(minval, array.get(0));
            maxval=Math.max(maxval,array.get(array.size()-1));
        }
        return maxDistance;
    }
}