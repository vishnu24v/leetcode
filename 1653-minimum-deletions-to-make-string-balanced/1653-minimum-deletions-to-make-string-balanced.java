class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int aCount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                aCount+=1;
            }
        }
        int seenA=0;
        int bCount=0;
        int minDel = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                seenA++;
            }
            minDel = Math.min(minDel,(aCount-seenA) + bCount);
            if(s.charAt(i)=='b'){
                bCount+=1;
            }
        }
        return minDel;
    }
}