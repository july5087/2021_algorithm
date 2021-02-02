import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (que.size() != 1) {
			for (int cnt = 0; cnt < K-1; cnt++) {
				que.add(que.poll());
			}
			sb.append(que.poll()+", ");

		}
		sb.append(que.poll() +">");
		System.out.println(sb.toString());
	}

}
