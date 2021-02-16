import java.io.*;
import java.util.*;
public class Main {
	static class Point implements Comparable<Point> {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			if (this.dist != o.dist)
				return this.dist - o.dist;
			else {
				if (this.x != o.x)
					return this.x - o.x;
				else
					return this.y - o.y;
			}
		}
	}

	static int N, M, fuel;
	static int[][] map;

	static class Pass {
		int sx, sy, fx, fy;

		public Pass(int sx, int sy, int fx, int fy) {
			this.sx = sx;
			this.sy = sy;
			this.fx = fx;
			this.fy = fy;
		}
	}

	static List<Pass> cus;
	static int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<Point> guest;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		st = new StringTokenizer(br.readLine());
		int dri_x = Integer.parseInt(st.nextToken()) - 1;
		int dri_y = Integer.parseInt(st.nextToken()) - 1;
		cus = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int fx = Integer.parseInt(st.nextToken()) - 1;
			int fy = Integer.parseInt(st.nextToken()) - 1;
			map[sx][sy] = i + 1;
			cus.add(new Pass(sx, sy, fx, fy));
		}
		while (true) {

			if (cus.size() == 0) {
				System.out.println(fuel);
				return;
			}

			guest = new LinkedList<>();
			shortDist(dri_x, dri_y);
			if (guest.size() == 0) {

				System.out.println(-1);
				return;
			}
			Point cur = guest.get(0);
			map[cur.x][cur.y] = 0;
			fuel -= cur.dist;

			if (fuel < 0) {
				System.out.println(-1);
				return;
			}

			int dist = 0;

			for (int i = 0; i < cus.size(); i++) {
				Pass pass = cus.get(i);
				if (pass.sx == cur.x && pass.sy == cur.y) {
					dist = getDist(pass.sx, pass.sy, pass.fx, pass.fy);
					if (dist == -1) {
						System.out.println(-1);
						return;
					}
					dri_x = pass.fx;
					dri_y = pass.fy;
					cus.remove(pass);
					break;

				}
			}
			fuel -= dist;
			if (fuel < 0) {
				System.out.println(-1);
				return;
			}

			fuel += dist * 2;

		}

	}

	private static void shortDist(int x, int y) {

		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		pq.add(new Point(x, y, 0));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (map[cur.x][cur.y] >= 1) {
				guest.add(new Point(cur.x, cur.y, cur.dist));
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dxy[k][0];
				int ny = cur.y + dxy[k][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == -1)
					continue;
				visited[nx][ny] = true;
				pq.add(new Point(nx, ny, cur.dist + 1));
			}
		}

	}

	private static int getDist(int sx, int sy, int fx, int fy) {
		Queue<Point> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		que.add(new Point(sx, sy, 0));
		visited[sx][sy] = true;

		while (!que.isEmpty()) {
			Point cur = que.poll();

			if (cur.x == fx && cur.y == fy) {
				return cur.dist;
			}

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dxy[k][0];
				int ny = cur.y + dxy[k][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == -1)
					continue;
				visited[nx][ny] = true;
				que.add(new Point(nx, ny, cur.dist + 1));
			}

		}

		return -1;
	}

}
