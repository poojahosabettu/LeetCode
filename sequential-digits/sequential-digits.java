class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int n = String.valueOf(low).length();
        List<Integer> sol = new ArrayList<Integer>();
        StringBuilder number = helper(n);
        
        while(Integer.parseInt(String.valueOf(number))<=high && n<10){
            int num = Integer.parseInt(String.valueOf(number));
            if(num>= low)
                sol.add(num);
            if(num == 123456789)
                break;
            else{
                int app =  number.charAt(number.length()-1)-'0';
                if( app == 9){
                    number = helper(++n);
                }
                else{
                    number = new StringBuilder(number.substring(1)).append(++app);
                }
            }
        }
        return sol;
    }
    
    public StringBuilder helper(int n){
        int m =1;
        StringBuilder number = new StringBuilder();
        while(n-->0){
            number.append(m++);
        }
        return number;
    }
}