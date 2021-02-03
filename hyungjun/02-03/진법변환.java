import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        char[] num = new char[N.length()];
        for (int i = 0; i < N.length(); i++) {
            num[i] = N.charAt(i);
        }
        //5
        //36^4 + z
        int ans = 0;
        int X=0;
        for (int i = 0; i < N.length(); i++) {
            X = (int) Math.pow(B, N.length()-i-1);
            if(num[i] <= '9'){
                ans += (num[i]-'0')*X;
            }else{
                ans += (num[i]-'0'-7)*X;
            }
        }
        System.out.println(ans);

    }
}
