class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> set = new HashMap<Character,Integer>();
        int n = s.length();
        int j = 0;
        int max = 0;
        int count = 0;
        for(int i = 0;i<n &&j<n;){
            Integer val = set.get(s.charAt(j));
            if(val == null || val<i){
                count = j-i+1;
                set.put(s.charAt(j),j);
                ++j;
            }else{
                i = val+1;
            }                
            max = Integer.max(max,count);
        }
        return max;
    }
}