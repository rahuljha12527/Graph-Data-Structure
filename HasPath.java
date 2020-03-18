import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    public static boolean hasPathBFS(int adjMatrix[][],int V,int a,int b,boolean visited[]){
        
        Queue<Integer> pendingNodes=new LinkedList<>();
        pendingNodes.add(0);
        visited[0]=true;
        
        while(!pendingNodes.isEmpty()){
            
            int currentVertex=pendingNodes.poll();
            if(currentVertex==b){
                return true;
            }
            
            for(int i=0;i<V;i++){
                if(adjMatrix[i][currentVertex]==1 && !visited[i]){
                    visited[i]=true;
                    pendingNodes.add(i);
                }
            }
            
        }
        return false;
        
        
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		
        int adjMatrix[][]=new int[V][V];
        
        for(int i=0;i<E;i++){
            int V1=s.nextInt();
            int V2=s.nextInt();
            adjMatrix[V1][V2]=1;
            adjMatrix[V2][V1]=1;
            
        }
        
        int a=s.nextInt();
        int b=s.nextInt();
        
        boolean visited[]=new boolean[V];
        
        boolean  ans=hasPathBFS(adjMatrix,V,a,b,visited);
        
        if(ans){
            System.out.println(true);
            
        }else{
            System.out.println(false);
        }
            
        
        
	}
}
