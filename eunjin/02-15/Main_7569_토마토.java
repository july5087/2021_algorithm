import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M, H;
	static int[][] dxy =  { { 0, -1, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[H][N][M];
		que = new LinkedList<>();
		visited = new boolean[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 1) {
						que.add(new int[] { h, i, j, 0 });
						visited[h][i][j] = true;
					}
				}
			}
		}
		bfs(map);
		boolean flag = true;
		out: for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) {
						flag = false;
						break out;
					}
				}
			}
		}
		System.out.println(flag == true ? ans : -1);
	}

	static Queue<int[]> que;
	static int ans = 0;

	static void bfs(int[][][] map) {

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			ans = Math.max(ans, cur[3]);
			for (int k = 0; k < dxy.length; k++) {
				int nh = cur[0] + dxy[k][0];
				int nx = cur[1] + dxy[k][1];
				int ny = cur[2] + dxy[k][2];
				if (!isRange(nh, nx, ny) || visited[nh][nx][ny])
					continue;
				if (map[nh][nx][ny] == 0) {
					map[nh][nx][ny] = 1;
					visited[nh][nx][ny] = true;
					que.add(new int[] { nh, nx, ny, cur[3] + 1 });
				}
			}
		}

	}

	static boolean isRange(int h, int x, int y) {
		if (h < 0 || x < 0 || y < 0 || h >= H || x >= N || y >= M)
			return false;
		else
			return true;
	}

}
