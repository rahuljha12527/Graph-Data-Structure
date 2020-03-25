Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in
the given matrix which makes the sentence “CODINGNINJA” .

There is a path from any cell to all its neighbouring cells. A neighbour may share an edge or a corner.

Input Format :
Line 1 : Two space separated integers N  and M, where N is number of rows and M is number of columns in the matrix.
Next N lines : N rows of the matrix. First line of these N line will contain 0th row of matrix, second line will 
contain 1st row and so on

Assume input to be 0-indexed based
Output Format :
Return 1 if there is a path which makes the sentence “CODINGNINJA” else return 0.
Constraints :
1 <= N <= 100
1 <= M <= 100
Sample Input :
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output :
1

public class solution {
	
	int solve(String[] Graph , int N, int M)
	{
		int [] row = {0,-1,0,1,1,-1,1,-1};
        int [] col = {-1,0,1,0,1,-1,-1,1};
        char arr [] ="CODINGNINJA".toCharArray();
        //searching for C
        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(Graph[i].charAt(j)=='C'){
                   //make boolean array
                    boolean vis[][] = new boolean[N][M];
                    //call for ODINGNIAS
                    //index will be 1 as O woul be at index 1
                    int index = 1;
                    boolean x = dfs(Graph, i, j, vis, row, col,index, N, M, arr);
                    if(x==true){
                        return 1;
                    }
                }
            }
        }
        return 0;

	}	
   boolean dfs(String [] Graph, int x, int y, boolean [][]vis, int []row, int [] col, int index, int N, int M, char[] arr){
       //make visited true
       vis[x][y] = true;
       //call for 8 dirction
       boolean ans = false;
       for(int i =0; i<8; i++){
           int newx = x+ row[i]; int newy = y+ col[i];
           if(index==arr.length){
               return true;
           }
           if(newx <N && newy<M && newx>=0 && newy>=0){
               //check if new position is O or not
               if(Graph[newx].charAt(newy)== arr[index] && vis[newx][newy]==false){
                  ans = ans || dfs(Graph, newx, newy, vis, row, col, index+1, N, M, arr);
                   vis[newx][newy]=false;
                   if(ans==true){
                       return true;
                   }
                }
           }
       }
       vis[x][y] = false;
       return false;
   }
}
8
