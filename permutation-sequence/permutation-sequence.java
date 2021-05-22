class Solution {
    //List<String> sol = new LinkedList<>();
    int K = 0;
    String solution = "";
    public String getPermutation(int n, int k) {
        K = k;
        getPermutation(n , new StringBuilder());
        //return sol.get(k-1);
        return solution;
    }
    
    public void getPermutation(int n,StringBuilder val){
        if(K>0){
            if(n == val.length()){
                --K;
                if(K == 0)
                    solution = val.toString();
            } else{
                for(int i = 1;i<=n;++i){
                    char c = (char)('0'+i);
                    if(val.toString().indexOf(c) == -1){
                        //System.out.println("Before "+val);
                        getPermutation(n,val.append(c)); 
                        val.delete(val.length()-1,val.length());
                       // System.out.println("After "+val);
                    }
                }
            }
        }
    }
}