//그리디
//전체 합 구하고, 마을(작은걸로 뽑아야함) 정렬한 다음 한가운데보다 같거나 큰 애들고르면


import java.io.*;
import java.util.*;
 
public class Main {
    
    static class Node{
        long num, people;
        public Node(long num, long people){
        	this.num = num;
        	this.people = people;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Node>list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            long num = Long.parseLong(st.nextToken());
            long people = Long.parseLong(st.nextToken());
            sum += people;
            list.add(new Node(num, people));
            
        }
        
        
        Collections.sort(list, new Comparator<Node>() {
            public int compare(Node p1, Node p2) {
                if(p1.num < p2.num) {
                    return -1;
                }
                else if(p1.num  == p2.num) {
                    if(p1.people < p2.people) {
                        return -1;
                    }
                }
                return 1;
            }
        });    
        
        long result = 0;
        
        for(Node cur : list) {
            result += cur.people;
            if(result >= (sum + 1) / 2) {
               System.out.println(cur.num);
                break;
            }
        }
 
    }
}
