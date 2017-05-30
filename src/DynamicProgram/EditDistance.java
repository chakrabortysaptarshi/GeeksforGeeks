package DynamicProgram;

public class EditDistance {

	int LCS(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int mat[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n ;j++) {
				if(i==0 || j==0) {
					mat[i][j] =0;
				} else if(s1.charAt(i-1) == s2.charAt(j-1)) 
					mat[i][j]= mat[i-1][j-1]+1;
				else
					mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
			}
		}
		return mat[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "sunday";
		String s2 = "saturday";
		int n = new EditDistance().LCS(s1, s2);
		
		System.out.println(Math.max(s1.length(), s2.length()) - n);

	}

}
