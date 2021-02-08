import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 일루미네이션 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int []wy = {-1,-1,0,1,1,0};
        int []wx = {0,1,1,1,0,-1};
        int []wx2 = {-1,0,1,0,-1,-1};
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> qre = new LinkedList<>();
        boolean [][]ck = new boolean[H][W];
        for (int i = 1; i < H-1; i++) {
            for (int j = 1; j < W-1; j++) {
                if(map[i][j] == 0 &&!ck[i][j]){
                    q.add(i);
                    q.add(j);
                    ck[i][j] = true;
                    qre.add(i);
                    qre.add(j);
                    boolean qck = false;
                    while(!q.isEmpty()){
                        int y = q.poll();
                        int x = q.poll();
                        for (int k = 0; k < 6; k++) {
                            int ny =0;
                            int nx=0;
                            if(y%2 == 1){
                                ny = y + wy[k];
                                nx = x + wx2[k];
                            }else{
                                ny = y + wy[k];
                                nx = x + wx[k];
                            }
                            if(ny >= 0 && nx >=0 && ny < H && nx <W ){
                                if(map[ny][nx] == 0&& !ck[ny][nx]){
                                    ck[ny][nx] = true;
                                    q.add(ny);
                                    q.add(nx);
                                    qre.add(ny);
                                    qre.add(nx);
                                }
                            }else{
                                qck = true;
                            }

                        }

                    }
                    if(qck){
                        q.clear();
                        qre.clear();

                    }
                    while(!qre.isEmpty()){
                        int y = qre.poll();
                        int x = qre.poll();

                        map[y][x] = 2;
                    }

                }
            }
        }



        int ans =0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int cnt = 0;
                if(map[i][j] == 1){
                    cnt=6;
                   for (int k = 0; k < 6; k++) {
                       int ny =0;
                       int nx=0;
                       if(i%2 == 1){
                           ny = i + wy[k];
                           nx = j + wx2[k];
                       }else{
                           ny = i + wy[k];
                           nx = j + wx[k];
                       }
                       if(ny >= 0 && nx >=0 && ny < H && nx <W){
                           if(map[ny][nx] != 0){
                              cnt--;
                           }
                       }

                   }
               }
               ans+=cnt;
            }
        }
        System.out.println(ans);


    }
}
