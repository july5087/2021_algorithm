import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 연구소 {

    static ArrayList<Integer> arr;
    static ArrayList<Integer> vir;
    static Set<int[][]> set = new HashSet<>();
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][]map = new int[N][M];
        arr = new ArrayList<>();
        vir = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    arr.add(i);
                    arr.add(j);
                }else if(map[i][j] == 2){
                    vir.add(i);
                    vir.add(j);
                }
            }
        }
        //벽 3개 고르기
        int arrsize = arr.size()/2;
        boolean[] wallck = new boolean[arrsize];
        wall(0,wallck,0);
        //bfs돌리기
        Iterator<int[][]> iter = set.iterator();
        while (iter.hasNext()){

            bfs(iter.next(), map);

        }
        System.out.println(ans);

    }
    public static void wall(int idx, boolean[]wallck, int cnt){
        if(cnt == 3 || idx == wallck.length){
            if(cnt !=3) return;
            int [][] walled = new int [3][2];
            int wallidx = 0;
            for (int i = 0; i < wallck.length; i++) {
                if(wallck[i]){
                    walled[wallidx][0] = arr.get(i*2);
                    walled[wallidx][1] = arr.get(i*2+1);
                    wallidx++;
                }
            }
            set.add(walled);
        }else{
            wall(idx+1, wallck, cnt);
            wallck[idx]=true;
            wall(idx+1, wallck, cnt+1);
            wallck[idx]=false;
        }
    }
    public static void bfs(int[][] o, int [][]map){
        int [][]cmap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                cmap[i][j] = map[i][j];

            }

        }

        int[] wy = {-1,1,0,0};
        int[] wx = {0,0,-1,1};
        for (int i = 0; i < 3; i++) {
            cmap[o[i][0]][o[i][1]] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < vir.size(); i+=2) {
            q.add(vir.get(i));
            q.add(vir.get(i+1));
        }
        while (!q.isEmpty()){
            int y = q.poll();
            int x = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + wy[i];
                int nx = x + wx[i];
                if(ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length && cmap[ny][nx] == 0){
                    cmap[ny][nx] = 2;
                    q.add(ny);
                    q.add(nx);
                }
            }

        }
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if(cmap[i][j] == 0){
                    cnt++;
                }
            }

        }

        ans = Math.max(ans, cnt);

    }

}
