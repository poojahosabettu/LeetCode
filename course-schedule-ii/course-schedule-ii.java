class Solution {
    public int[] findOrder(int numCourse, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourse];
        boolean[] visited = new boolean[numCourse];
        int[] order = new int[numCourse];
        boolean[] rec = new boolean[numCourse]; 
        
        for(int i = 0;i<numCourse;++i)
            adj[i] = new ArrayList<Integer>();
        
        for(int[] i:prerequisites){
            adj[i[0]].add(i[1]);
        }
        
       
        if(canFinish(adj,visited,rec)){
            visited = new boolean[numCourse];
            int index = 0;
            for(int i = 0;i<numCourse;++i){
                if(!visited[i]){
                    //index = dfs(order,i,index,visited,adj);
                    index = dfs(index,i,order,visited,adj);
                }
            }
            return order;
        }
        return new int[0];    
    }
    
    public int dfs(int[] order, int i,int index,boolean[] visited, ArrayList<Integer>[] adj){
        visited[i] = true;
        for(int j:adj[i]){
            if(!visited[j])
                index = dfs(order,index,j,visited,adj);
        }
        order[index] = i;
        return index+1;
    }
    
    public int dfs(int index ,int i, int[] order,boolean[] visited,ArrayList<Integer>[] adj){
        visited[i] = true;
        for(int I:adj[i]){
            if(!visited[I])
                index =  dfs(index,I,order,visited,adj);
        }
        order[index] = i;
        return index+1;
    }
         
    public boolean canFinish(ArrayList<Integer>[] adj, boolean[] visited, boolean[] rec){
        int numCourse = adj.length;
        for(int i = 0;i<numCourse;++i){
            if(!visited[i] && dfs(i,adj,visited,rec))
                return false;
        }
        return true;
    }
    
    public boolean dfs(int i,ArrayList<Integer>[] adj, boolean[] visited, boolean[] rec){
        visited[i] = true;
        rec[i] = true;
        for(int j:adj[i]){
            if(!visited[j] && dfs(j,adj,visited,rec))
                return true;
            if(rec[j])
                return true;
        }
        rec[i] = false;
        return false;
    }
    
}