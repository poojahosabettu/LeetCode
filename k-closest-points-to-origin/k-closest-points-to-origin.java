class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((int[] p1, int[] p2)->Integer.compare((p2[0]*p2[0])+(p2[1]*p2[1]),(p1[0]*p1[0])+(p1[1]*p1[1])));
        
        for(int[] p:points){
            heap.add(p);
            if(heap.size()>k)
                heap.poll();
        }
        
        int[][] sol = new int[k][2];
        int i = 0;
        while(heap.size()>0){
            int[] temp = heap.poll();
            sol[i][0] = temp[0];
            sol[i++][1] = temp[1];
        }
        
        return sol;
    }
}