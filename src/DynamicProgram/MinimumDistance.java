package DynamicProgram;

public class MinimumDistance {
	
	int minDist(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int dist[][] = new int[m][n];
		dist[0][0] = mat[0][0];
		
		for(int i=1; i<m ;i++) 
			dist[0][i] = dist[0][i-1]+mat[0][i];
		for(int j=1; j<n; j++)
			dist[j][0] = dist[j-1][0]+mat[j][0];
		
		for(int i=1;i<m; i++) {
			for(int j=1;j<n; j++) {
				dist[i][j] = Math.min((Math.min(dist[i-1][j], dist[i][j-1])),dist[i-1][j-1]) + mat[i][j];
			}
		}
		return dist[m-1][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
		System.out.println(new MinimumDistance().minDist(cost));
                                 
	}

}
