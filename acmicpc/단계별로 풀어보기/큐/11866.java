import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        System.out.print("<");

        for(int i=1; i<=count; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            for(int i = 1; i < target; i++){
                queue.add(queue.remove());
            }
            if(queue.size() == 1)
                System.out.print(queue.poll());
            else
                System.out.print(queue.poll()+", ");
        }
        System.out.print(">");
    }
}

// 나머지 연산을 이용한 방법
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a = sc.nextInt();
        int tmp = 0;
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> josepus = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++) {
            arr.add(i+1);
        }
        
        while(!arr.isEmpty()) {
            tmp = (tmp+a-1)%arr.size();
            josepus.add(arr.remove(tmp));
        }
        System.out.print("<");
        for(int i=0; i<n; i++) {
            System.out.print(josepus.get(i));
            
            if(i!=n-1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}