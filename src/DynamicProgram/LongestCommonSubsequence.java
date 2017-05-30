package DynamicProgram;

public class LongestCommonSubsequence {
	
	
	int LCS_Size(String s1, String s2) {
		int[][] m = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<=s1.length(); i++) {
			for(int j=0; j<=s2.length(); j++) {
				if(i == 0 || j==0)
					m[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					m[i][j] = m[i-1][j-1]+1;
				else
					m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
			}
		}
		return m[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = new LongestCommonSubsequence().LCS_Size("D", "AEDFHR");
		System.out.println(n);
	}

}
