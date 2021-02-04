import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Boom {
		int x, y;

		public Boom(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] map;
	static int[][] boomMap;
	static int R, C, N;
	static Queue<Boom> que;
	static int boomTime = 3, delay;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		que = new LinkedList<>();
		map = new char[R][C];
		boomMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					que.add(new Boom(i, j));
					boomMap[i][j] = boomTime;
				}

			}
		}
		int time = 0;
		while (true) {
			if (time == N)
				break;
			bfs();
			boomman();
			time++;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	private static void bfs() {
		int size = que.size();
		for (int s = 0; s < size; s++) {
			Boom cur = que.poll();

			// 1이면폭발
			if (boomMap[cur.x][cur.y] == 1) {
				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dxy[k][0];
					int ny = cur.y + dxy[k][1];

					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					// 같은 시간대에 터지는 친구면
					if (boomMap[nx][ny] == boomMap[cur.x][cur.y])
						continue;
					map[nx][ny] = '.';
					boomMap[nx][ny] = 0;

				}
				map[cur.x][cur.y] = '.';
				boomMap[cur.x][cur.y] = 0;
			} else if (boomMap[cur.x][cur.y] > 1) {
				boomMap[cur.x][cur.y]--;
				que.add(cur);
			}

		}
	}

	private static void boomman() {
		delay++;
		if (delay % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '.') {
						map[i][j] = 'O';
						boomMap[i][j] = boomTime;
						que.add(new Boom(i, j));
					}

				}
			}
		}

	}

}
