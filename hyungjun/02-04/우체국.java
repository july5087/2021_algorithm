import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 우체국 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<vp> ar= new ArrayList<>();
        long total = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            ar.add(new vp(x,a));
            total += a;
        }
        Collections.sort(ar, new Comparator<vp>() {
            @Override
            public int compare(vp o1, vp o2) {
                return o1.x - o2.x;
            }
        });


        long ans = 0;

        int vill =0;
        for (int i = 0; i < N; i++) {
            ans +=ar.get(i).a;
            if( ans >= ((total+1)/2)){
                vill = ar.get(i).x;
                break;
            }

        }
        System.out.println(vill);



    }
    static public class vp{
        int x;
        int a;

        public vp(int x, int a) {
            this.x = x;
            this.a = a;
        }
    }
}
