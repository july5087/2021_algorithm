import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean []ck = new boolean[N+1];
        int p = 2;
        int cnt = 0;
        boolean bk = true;
        int ans = 0;
        while (bk){
            for (int i = p; i <= N; i++) {
                if(!ck[i]){
                    p = i;
                    break;
                }
            }
            for (int i = p; i <= N; i+=p) {
                if(ck[i])continue;
                ck[i] = true;
                cnt++;
                if(cnt == K){
                    bk = false;
                    ans = i;
                    break;
                }
            }

        }
        System.out.println(ans);

    }
}
