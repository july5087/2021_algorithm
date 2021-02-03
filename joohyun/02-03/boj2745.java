package test;
import java.util.*;

class boj2745 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String N = sc.next();
    int B = sc.nextInt();
    int len = N.length();
    long answer = 0;

    for(int i=0; i<len; i++){
      // 숫자
      if(N.charAt(i) >= '0' && N.charAt(i) <= '9'){
        answer += (N.charAt(i) - '0') * Math.pow(B, len - i - 1);
      }
      // 문자
      else{
        answer += (N.charAt(i) - 55) * Math.pow(B, len - i - 1);
      }
    }

    System.out.println(answer + "\n");
  }
}