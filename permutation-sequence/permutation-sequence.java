class Solution {
    //List<String> sol = new LinkedList<>();
    int K = 0;
    String solution = "";
    public String getPermutation(int n, int k) {
        K = k;
        getPermutation(n , "", new boolean[n]);
        //return sol.get(k-1);
        return solution;
    }
    
    public void getPermutation(int n,String val, boolean[] used){
        if(K>0){
            if(n == val.length()){
                --K;
                if(K == 0)
                    solution = val;
            } else{
                for(int i = 1;i<=n;++i){
                    if(used[i-1])
                        continue;
                    char c = (char)('0'+i);
                    used[i-1] = true;
                    getPermutation(n,val+c,used); 
                    used[i-1] = false;
                }
            }
        }
    }
}