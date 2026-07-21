class Solution {
    public int findCircleNum(int[][] arr) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();        
        int ans = 0;

        for(int i = 0; i < arr.length; i++){
            
            if( !visited[i] ){
                ans++;
                visited[i] = true;

                q.offer(i);
                
                while( !q.isEmpty() ){
                    int temp = q.poll();
                    for( int j = 0; j < arr.length; j++){
                        if(arr[temp][j] == 1 && visited[j] == false){
                            visited[j] = true;
                            q.offer(j);
                        } 
                    }
                }
                
            }
        }

        return ans;
    }
}