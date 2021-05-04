class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,0,0);
    }
    
    
    public boolean isMatch(String s, String p,int m, int n) {
        if(n >= p.length())
            return m>=s.length();
        if(m>=s.length()){
            if(n<p.length()-1 && p.charAt(n+1)=='*')
                return isMatch(s,p,m,n+2);
            return false;
        }
        
        else {
                if(n<p.length()-1 &&  p.charAt(n+1) == '*'){
                    if(p.charAt(n) == '.' || p.charAt(n) == s.charAt(m))
                        return isMatch(s,p,m,n+2) || isMatch(s,p,m+1,n);
                     return isMatch(s,p,m,n+2);
                }
                else if(p.charAt(n) == '.' || p.charAt(n) == s.charAt(m))
                    return isMatch(s,p,m+1,n+1);
                else return false;
          }
    }
    
    
}