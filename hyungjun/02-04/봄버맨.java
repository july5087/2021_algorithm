import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봄버맨 {
    static int R, C, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }
        int[] wy = {-1, 1, 0, 0};
        int[] wx = {0, 0, -1, 1};
        if (N >= 2) {
            for (int k = 2; k <= N; k++) {
                if (k % 2 == 0) { //설치
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (map[i][j] == -1) {
                                map[i][j] = k;
                            }
                        }
                    }

                } else { //터짐
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (map[i][j] == k - 3) {
                                map[i][j] = -1;
                                for (int l = 0; l < 4; l++) {
                                    int ny = i + wy[l];
                                    int nx = j + wx[l];
                                    if (ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] != -1 && map[ny][nx] != k - 3) {
                                        map[ny][nx] = -1;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }


    }
}
//1232 1232 1232 1