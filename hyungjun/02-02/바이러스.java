import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> [] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        int a = 0;
        int b = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b= Integer.parseInt(st.nextToken()) - 1;
            arr[a].add(b);
            arr[b].add(a);

        }
        Queue<Integer>q = new LinkedList<>();

        q.add(0);
        boolean[]ck = new boolean[N];
        ck[0] = true;
        int cnt = 0;
        while (!q.isEmpty()){
            int x = q.poll();

            for (int i = 0; i < arr[x].size(); i++) {
                if(!ck[arr[x].get(i)]){
                    cnt++;
                    ck[arr[x].get(i)] = true;
                    q.add(arr[x].get(i));
                }
            }
        }
        System.out.println(cnt);

    }
}
