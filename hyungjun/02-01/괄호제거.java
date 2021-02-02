import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 괄호제거 {
    static Stack<Integer> st = new Stack<Integer>();
    static String s ="";
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    static int[]Sarr;
    static int[]Earr;
    static Set<String> ans = new HashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int Gcnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                Gcnt++;
            }
        }
        Sarr = new int [Gcnt];
        Earr = new int [Gcnt];
        int Si = 0;
        int Ei = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                st.add(i);


            }else if(s.charAt(i) == ')'){

                Sarr[Si++]= st.pop();
                Earr[Ei++] = i;

            }
        }
        boolean[] ck = new boolean[Gcnt];
        mk(0,ck);
        Object[] ass =  ans.toArray();
        Arrays.sort(ass);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ass[i]);
        }

    }

    static public void mk(int idx, boolean[]ck){
        if(idx == ck.length){
            if(sb.length()==0) {
                sb.append("a");
                return;}
            set = new HashSet<>();
            sb = new StringBuilder();
            for (int i = 0; i < ck.length; i++) {
                if(ck[i]){
                    set.add(Sarr[i]);
                    set.add(Earr[i]);
                }
            }
            for (int i = 0; i < s.length(); i++) {
               if(set.contains(i))continue;
               sb.append(s.charAt(i));
            }
            ans.add(sb.toString());



        }else{
            mk(idx+1, ck);
            ck[idx] = true;
            mk(idx+1, ck);
            ck[idx] = false;


        }
    }
}
