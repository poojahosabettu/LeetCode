class Solution {
    int id = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Stack<Integer> stack = new Stack<Integer>();
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        boolean[] inStack = new boolean[n];
        boolean[] visited = new boolean[n];
        int[] low = new int[n];
        int[] ids = new int[n];
        Arrays.fill(ids,-1);
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i =0;i<n;++i)
            adj[i] = new ArrayList<Integer>();
        for(List<Integer> list:connections){
            adj[list.get(0)].add(list.get(1));
            adj[list.get(1)].add(list.get(0));
        }
        
        for(int i =0;i<n;++i){
            if(ids[i] == -1)
                dfs(-1,i,adj,inStack,ids,low,stack);
        }
        
        for(List<Integer> list:connections){
            if(low[list.get(0)]!=low[list.get(1)])
                sol.add(new ArrayList<Integer>(list));
        }
        return sol;
    }
    
    public void dfs(int parent, int i, ArrayList<Integer>[] adj, boolean[] inStack, int[] ids, int[] low, Stack<Integer> stack){
        low[i] = ids[i] = id++;
        inStack[i] = true;
        stack.push(i);
        
        for(int j:adj[i]){
            if(j == parent)
                continue;
            if(ids[j] == -1)
                dfs(i,j,adj,inStack,ids,low,stack);
            if(inStack[j])
                low[i] = Integer.min(low[j],low[i]);
        }
        
        if(ids[i] == low[i]){
            for(int node = stack.pop();;node= stack.pop()){
                inStack[node] = false;
                low[node] = ids[i];
                if(node == i)
                    break;
            }
        }
    }
}