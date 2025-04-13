class Solution {
    int[][] dirs;
    int m,n; 
    public int RottingOranges(int[][] grid) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        this.m = grid.length;
        this.n = grid[0].length;

        int fresh = 0;
        Queue<int[]> myQueue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    myQueue.add(new int[]{i,j});
            }
        }
        
        int timeTaken =0;
        if(fresh ==0)
            return timeTaken;
        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            for(int i=0; i<size; i++){
                int [] curr = myQueue.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        myQueue.add(new int[]{r,c});
                        fresh --;
                    }
                }
            }
            timeTaken++;
        }

        if(fresh == 0)
            return timeTaken-1;
        return -1;
    }
}