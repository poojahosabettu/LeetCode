class Solution {
    static class Edge{
        int s;
        int d;
        int cost;
        int stop;
        
        Edge(int S, int D, int C, int st){
            s = S;
            d = D;
            cost = C;
            stop = st;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((e1,e2)->Integer.compare(e1.cost,e2.cost));
        Map<Integer,List<Edge>> adj = new HashMap<Integer,List<Edge>>();
        for(int[] i:flights){
            adj.putIfAbsent(i[0],new ArrayList<Edge>());
            adj.get(i[0]).add(new Edge(i[0],i[1],i[2],0));
        }
        queue.add(new Edge(src,src,0,-1));
        while(queue.size()>0){
            Edge e = queue.poll();
            if(e.stop>k) continue;
            if(e.d == dst &&  e.stop <= k){
                return e.cost;
            }
            for(Edge i:adj.getOrDefault(e.d, new ArrayList<Edge>())){
                queue.add(new Edge(i.s,i.d,e.cost+i.cost,e.stop+1));
            }    
        }
        return -1;
    }
}