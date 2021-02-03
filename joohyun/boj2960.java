package test;

import java.util.*;

public class boj2960 {
	static boolean isPrime(int num){
	    if (num == 0 || num == 1) return false;
	    for (int i = 2; i <= Math.sqrt(num); i++) {
	      if (num % i == 0)
	        return false;
	    }
	    return true;
	  }

	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int K = sc.nextInt();

	    boolean visited[] = new boolean[N+1];
	    boolean isFind = false;
	    int cnt = 0, answer = 0;

	    for(int i=2; i<=N; i++){
	      if(!visited[i] && isPrime(i)){
	        visited[i] = true;
	        cnt++;
	        if(cnt == K) {
	          answer = i;
	          break; 
	        }
	        for(int j=i; j<=N; j+=i){
	          if(!visited[j]){
	            visited[j] = true;
	            cnt++;
	          }
	          if(cnt == K){
	            isFind = true;
	            answer = j;
	            break;
	          }
	        }
	      }
	      if(isFind) break;
	    }    

	    System.out.println(answer + "\n");
	  }  
}
