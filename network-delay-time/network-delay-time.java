class Solution {
    static class Edge{
        int s;
        int d;
        int w;
        Edge(int source, int destination, int weight){
            s = source;
            d = destination;
            w = weight;
        }
    }
    
    static class Pair{
        int v;
        int w;
        Pair(int vertex, int weight){
            v = vertex;
            w = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> adj = new HashMap<Integer,List<Edge>>();
        
        for(int i = 1;i<=n;++i){
            adj.putIfAbsent(i,new ArrayList<Edge>());
        }
        
        for(int[] i:times){
            adj.get(i[0]).add(new Edge(i[0],i[1],i[2])); 
        }
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((e1,e2)->Integer.compare(e1.w,e2.w));
        
        queue.add(new Pair(k,0));
        distance[k] = 0;
        
        while(queue.size()>0){
            Pair p = queue.poll();
            if(visited[p.v]) continue;
            visited[p.v] = true;
            for(Edge edge:adj.get(p.v)){
                if(!visited[edge.d] && distance[edge.d]>distance[p.v]+edge.w){
                    distance[edge.d] = distance[p.v]+edge.w;
                    queue.add(new Pair(edge.d,distance[edge.d]));
                }
            }
        }
        int max = 0;
        for(int i = 1;i<=n;++i)
            max = Integer.max(max,distance[i]);
        return max == Integer.MAX_VALUE?-1:max;
        
    }
}