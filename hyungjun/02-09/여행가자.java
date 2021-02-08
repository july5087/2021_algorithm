import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 여행가자 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        boolean[] ck = new boolean[N];
        int[][]map = new int [N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        ck[start] = true;
        for (int i = 1; i < M; i++) {
            int go = Integer.parseInt(st.nextToken())-1;
            ck[go] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visit = new boolean[N];
        visit[start] = true;
        while (!q.isEmpty()){
            int c = q.poll();
            for (int i = 0; i < N; i++) {
                if(map[c][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }

        }
        String ans = "YES";
        for (int i = 0; i < N; i++) {
            if(ck[i] && !visit[i]){
                ans = "NO";
                break;
            }
        }
        System.out.println(ans);


    }
}
