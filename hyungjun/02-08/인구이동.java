import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {
    static int N,L,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int [][]map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> qre = new LinkedList<>();
        int []wy = {-1,1,0,0};
        int []wx = {0,0,-1,1};
        boolean [][] ck = new boolean[N][N];
        boolean go = true;
        int cnt = 0;
        while (go){
            go = false;
            ck = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum =map[i][j];
                    if(!ck[i][j]){
                        ck[i][j] = true;
                        q.add(i);
                        q.add(j);
                        qre.add(i);
                        qre.add(j);
                        while (!q.isEmpty()){
                            int y = q.poll();
                            int x = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int ny = y + wy[k];
                                int nx = x + wx[k];
                                if(ny >= 0 && nx >=0 && ny < N && nx < N && !ck[ny][nx]){
                                    if(Math.abs(map[y][x] - map[ny][nx])>= L &&  Math.abs(map[y][x] - map[ny][nx])<= R){
                                        ck[ny][nx] = true;
                                        q.add(ny);
                                        q.add(nx);
                                        qre.add(ny);
                                        qre.add(nx);
                                        sum+=map[ny][nx];
                                    }
                                }
                            }

                        }

                        if(qre.size() > 2){
                            int di = sum/(qre.size()/2);
                            while (!qre.isEmpty()){
                                int y = qre.poll();
                                int x = qre.poll();
                                map[y][x] = di;
                                go = true;
                            }

                        }else{
                            qre.clear();
                        }
                    }

                }
            }
            if(go)cnt++;


        }
        System.out.println(cnt);
    }
}
