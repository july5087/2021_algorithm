import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken()) - 1;
			int from = Integer.parseInt(st.nextToken()) - 1;
			arr[to][from] = 1;
			arr[from][to] = 1;
		}

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(0);
		int result = 0;
		boolean[] visited = new boolean[N];
		visited[0] = true;
		
		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 0; i < N; i++) {
				if (i == cur)
					continue;
				if (!visited[i] && arr[cur][i] == 1) {
					que.add(i);
					visited[i] = true;
					result++;
				}
			}

		}

		System.out.println(result);

	}

}
