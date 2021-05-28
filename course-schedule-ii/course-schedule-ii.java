class Solution {
    int v = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0;i<numCourses;++i)
            adj[i] = new ArrayList<Integer>();
        for(int[] i:prerequisites)
            adj[i[0]].add(i[1]);
        
        if(canFinish(numCourses,prerequisites,visited,adj)){
            visited = new boolean[numCourses];
            int index = 0;
            for(int i = 0;i<numCourses;++i)
                if(!visited[i])
                    index = dfs(index,i,order,visited,adj);
             return order;
        }
        return new int[0];
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
        
    
    public boolean canFinish(int numCourses, int[][] prerequisites,boolean[] visited,ArrayList<Integer>[] adj) {
        boolean[] recStack = new boolean[numCourses];
        for(int i = 0;i<numCourses;++i)
            if(!visited[i])
                if(dfs(i,recStack,visited,adj))
                    return false;
        return true;
    }
    
    public boolean dfs(int i, boolean[] recStack,boolean[] visited,ArrayList<Integer>[] adj){
        recStack[i] = true;
        visited[i] = true;
        for(int I:adj[i]){
            if(!visited[I] && dfs(I,recStack,visited,adj)){
                return true;
            }else if(recStack[I])
                return true;
        }
        recStack[i] = false;
        return false;
    }
    
}