import java.util.Scanner;
  import java.util.Arrays;
  class Edge implements Comparable<Edge>{

    int v1;
    int v2; 
    int weight;
      Edge(int v1,int v2,int weight){
      this.v1=v1;
      this.v2=v2;
      this.weight=weight;
    } 

     @Override
    public int compareTo(Edge o){
      return this.weight-o.weight;
     }
  } 
  public class Solution {
   
       public static int findParent(int currentEdge,int parent[]){

        if(currentEdge==parent[currentEdge]){
          return currentEdge;
        }

        return findParent(parent[currentEdge],parent);
      }

      public static Edge[] KruskalAlgotithm(Edge edges[],int n){
          Arrays.sort(edges);

          Edge mst[]=new Edge[n-1];
           
           int parent[]=new int[n];
           for(int i=0;i<n;i++){
                parent[i]=i;
           }
          int count=0,i=0;
          while(count!=n-1){
              
              Edge currentEdge=edges[i++];
              int v1Parent=findParent(currentEdge.v1,parent);
              int v2Parent=findParent(currentEdge.v2,parent);

              if(v1Parent!=v2Parent){
                  mst[count]=currentEdge;
                  count++;
                  parent[v1Parent]=v2Parent;  
              }
            //count++;
          }
          
          return mst;

      }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);


      int n=sc.nextInt();
        int E=sc.nextInt();

        Edge edges[]=new Edge[E];
        
        for(int i=0;i<E;i++){
          int v1=sc.nextInt();
          int v2=sc.nextInt();
          int weight=sc.nextInt();
          Edge edge=new Edge(v1,v2,weight);
          edges[i]=edge;
        }
      
        Edge mst[]=KruskalAlgotithm(edges,n);
      
        for(int i=0;i<mst.length;i++){
            if(mst[i].v1<mst[i].v2){
              System.out.println(mst[i].v1 +" " +mst[i].v2+" "+mst[i].weight);
            }
            else{
              System.out.println(mst[i].v2+" "+mst[i].v1+" "+mst[i].weight);
            }
        }
    }
  }


// 2 errors
