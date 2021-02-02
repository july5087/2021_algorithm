import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<Node> virus;
	static int result;
	static int cnt;
	static Queue<Node> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		virus = new LinkedList<>();
		int wall = 3;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Node(i, j));
				}
				if (map[i][j] == 1)
					wall++;
			}
		}

		// 벽을세운다
		// 바이러스가 퍼진다
		// 0인 곳의 최대값 찾기
		int ans = N * M - wall;
		result = 987654321;
		makeWall(map, 0);
		ans -= result;
		System.out.println(ans);

	}

	static void makeWall(int[][] map, int wall) {

		if (wall == 3) {
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}
			spread(copy, new boolean[N][M]);
			result = Math.min(result, cnt);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(map, wall + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	static void spread(int[][] arr, boolean[][] visited) {
		cnt = 0;
		que = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			cnt++;
			que.add(virus.get(i));
			visited[virus.get(i).x][virus.get(i).y] = true;
		}
		while (!que.isEmpty()) {
			Node cur = que.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dxy[k][0];
				int ny = cur.y + dxy[k][1];
				if (!isRange(nx, ny) || visited[nx][ny])
					continue;
				if (arr[nx][ny] == 0) {
					visited[nx][ny] = true;
					arr[nx][ny] = 2;
					cnt++;
					que.add(new Node(nx, ny));
				}
			}
		}
	}

	static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M)
			return false;
		else
			return true;
	}
}
