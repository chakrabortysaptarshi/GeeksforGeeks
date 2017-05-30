package DynamicProgram;

import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	public int binarySearch(int start, int end, List<Integer> li, int key) {
		int mid = (start+end)/2;
		if(start == end)
			return end;
		if(li.get(mid) == key)
			return mid;
		if(li.get(mid) > key )
			return binarySearch(start, mid, li, key);
		else
			return binarySearch(mid+1, end, li, key);
	}
	
	public int LCS(int[] num) {
		LinkedList<Integer> li = new LinkedList<Integer>();
		//int[] parent = new int[num.length];
		li.add(num[0]);
		for(int i=1; i<num.length; i++) {
			int lastNum = li.get(li.size()-1);
			if(lastNum < num[i]) {
				li.add(num[i]);
			}
			else {
				int index = binarySearch(0, li.size()-1, li, num[i]);
				li.set(index, num[i]);
			}
		}
		return li.size();
	}

	public static void main(String[] args) {
		int[] num = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int size = new LongestIncreasingSubsequence().LCS(num);
		System.out.println(size);
		
		
	}

}
