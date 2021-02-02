import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Pair{
		int leftIdx;
		int rightIdx;
		public Pair(int leftIdx,int rightIdx) {
			this.leftIdx = leftIdx;
			this.rightIdx = rightIdx;
		}
	}
	static ArrayList<Pair>list;
	static int N;
	static char[] exp;
	static String str;
	static HashSet<String>remove;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		int size = str.length();
		exp = new char[size];
		
		
		for(int i=0;i<size;i++) {
			exp[i] = str.charAt(i);
		}
		
		list = new ArrayList<>();
		Stack<Integer>stack = new Stack<Integer>();
		
		for(int i=0;i<size;i++) {
			char cur = exp[i];
			if(cur == '(') {
				stack.push(i);
			}else if(cur == ')') {
				Pair pair = new Pair(stack.pop(), i);
				list.add(pair);
			}
		}
		remove = new HashSet<>();
		N = list.size();
		
		solve(0,exp);
		
		List removeList = new ArrayList(remove);
		Collections.sort(removeList);
		
		for(int i=0;i<removeList.size();i++) {
			if(!removeList.get(i).equals(str)) {
				System.out.println(removeList.get(i));
			}
		}
		
		

	}
	private static void solve(int idx,char[] exp) {
		if(idx>=N) {
			
			String removeStr = new String(exp);
			removeStr = removeStr.replaceAll(" ", "");
			remove.add(removeStr);
			
		}else {
			Pair cur = list.get(idx);
			
			exp[cur.leftIdx] = ' ';
			exp[cur.rightIdx] = ' ';
			solve(idx+1,exp);
			
			exp[cur.leftIdx] = '(';
			exp[cur.rightIdx] = ')';
			solve(idx+1,exp);
			
			
		}
	}

}
