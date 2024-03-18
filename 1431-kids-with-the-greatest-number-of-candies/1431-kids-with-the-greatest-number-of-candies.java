class Solution {
    public List<Boolean> kidsWithCandies(int[] arr, int e) {
        int max = -1;
        List<Boolean> res = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] + e >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}