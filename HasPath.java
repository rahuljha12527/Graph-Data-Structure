//HasPath using BFS
//Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), check if there exists any path between them or not. Print true or false.
//V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
//E is the number of edges present in graph G.
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
//Line (E+2) : Two integers v1 and v2 (separated by space)
//Output Format :
//true or false
//Constraints :
//2 <= V <= 1000
//1 <= E <= 1000
//0 <= v1, v2 <= V-1
//Sample Input 1 :
//4 4
//0 1
//0 3
//1 2
//2 3
//1 3
//Sample Output 1 :
//true
//Sample Input 2 :
//6 3
//5 3
//0 1
//3 4
//0 3
//Sample Output 2 :
//false	



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
