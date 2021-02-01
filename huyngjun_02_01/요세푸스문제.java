import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean [] ck = new boolean[N];
        int cnt = 0;
        int idx = -1;
        int circleIdx = -1;
        sb.append("<");
        while (cnt !=N){
            circleIdx++;
            if(!ck[circleIdx%N]){
                idx++;
                if(idx == K-1){
                    ck[circleIdx%N] = true;
                    sb.append(circleIdx%N+1).append(", ");
                    cnt++;
                    idx = -1;
                }
            }

        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());

    }
}