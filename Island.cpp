void dfs(vector<vector<int>> &adj,int sv,bool *visited){
    
    visited[sv]=true;
    
    for(int i=0;i<adj[sv].size();i++){
        
       
        if(!visited[adj[node][i]])
            dfs(adj,adj[node][i],visited);
        }
    }
}

int solve(int n,int m,vector<int>u,vector<int>v)
{
     
    vector<vector<int>> adj(n+1);
    
    for(int i=0;i<m;i++){
        adj[u[i]].push_back(v[i]);
        adj[v[i]].push_back(u[i]);
    }
    
    bool *visited=new bool[n+1];
    for(int i=0;i<=n;i++){
        visited[i]=false;
    }
    
    int count=0;
    for(int i=1;i<=n;i++){
        
        if(!visited[i]){
            
            dfs(adj,i,visited);
            count++;
        }
    }
    
    return count;
    
}