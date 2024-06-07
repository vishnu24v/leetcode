class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>(dict);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            for(int j=1;j<=words[i].length();j++){
                String root = words[i].substring(0, j);
                if(set.contains(root)){
                    words[i]=root;
                }
            }
            sb.append(words[i]+" ");
        }
        return sb.substring(0, sb.length()-1);
    }
}