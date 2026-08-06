class Solution {
    public void dfs(int node,int[]visited,ArrayList<ArrayList<Integer>> list){
        visited[node]=1;
        for(Integer itr:list.get(node)){
            if(visited[itr]==0) dfs(itr,visited,list);
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int m=isConnected.length;
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1&&i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int[]visited=new int[m];
        Arrays.fill(visited,0);
        int res=0;
        for(int i=0;i<m;i++){
           if(visited[i]==0){
                res++;
                dfs(i,visited,list);
           }
        }
        return res;
    }
}