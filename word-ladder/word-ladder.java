class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int n = beginWord.length();
        int ans = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        Set<String> set2 = new HashSet<>(wordList);
        
        while(!queue.isEmpty()){
            int m = queue.size();
            for(int j = 0;j<m;++j){
            String poppedString = queue.poll();
            if(poppedString.equals(endWord)){
                return ans;
            }
            char[] charArray = poppedString.toCharArray();
            for(int i = 0;i<n;++i){
               
                for(char c = 'a';c<='z';++c){
                        char tempChar = charArray[i];
                        charArray[i] = c;
                        String tempString = String.valueOf(charArray);
                        if(set2.contains(tempString)){
                            queue.offer(tempString);
                            set2.remove(tempString);
                        }
                        charArray[i] = tempChar;
                    }
                }
            }
            ans = ans+1;
        }
        return 0;
    }

}