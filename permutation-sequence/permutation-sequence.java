class Solution {
    //List<String> sol = new LinkedList<>();
    int K = 0;
    String solution = "";
    public String getPermutation(int n, int k) {
        K = k;
        getPermutation(n , "");
        //return sol.get(k-1);
        return solution;
    }
    
    public void getPermutation(int n,String val){
        if(K>0){
            if(n == val.length()){
                --K;
                if(K == 0)
                    solution = val;
            } else{
                for(int i = 1;i<=n;++i){
                    char c = (char)('0'+i);
                    if(val.indexOf(c) == -1)
                       getPermutation(n,val+c); 
                }
            }
        }
    }
}