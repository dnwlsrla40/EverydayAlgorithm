// 물통

/*
*   처음엔 문제를 어떻게 dfs나 bfs로 풀어야 할지 몰라서 감을 못잡다가 완전탐색 방식으로 해보자 해서 풀었다. 일일이 넘겨주는 모든 경우를 체크해주었는데 후에 코드를 보니 비슷해서 다행이었다.
*/

// 제출 결과: [메모리: 22164KB 시간: 84ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java_2251 {
    static Queue<Node> q = new LinkedList<>();
    static boolean[][][] visit = new boolean[201][201][201];
    static int c_a,c_b,c_c;
    static ArrayList ans = new ArrayList();

    static class Node{
        int a;
        int b;
        int c;

        public Node(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Node temp = q.poll();
            int a = temp.a;
            int b = temp.b;
            int c = c_c-a-b;
            if(a==0 && !ans.contains(c))
                ans.add(c);

            if(!visit[a][b][c]){
                visit[a][b][c] = true;

                // a->b
                if(a + b > c_b ){
                    q.add(new Node((a+b)-c_b,c_b,c));
                } else{
                    q.add(new Node(0,a+b,c));
                }

                // a->c
                if(a + c > c_c){
                    q.add(new Node((a+c)-c_c, b,c_c));
                } else{
                    q.add(new Node(0,b,a+c));
                }

                // b->a
                if(b + a > c_a){
                    q.add(new Node(c_a, (b+a)-c_a,c));
                } else{
                    q.add(new Node(b+a,0,c));
                }

                // b->c
                if(b + c > c_c){
                    q.add(new Node(a, (b+c)-c_c,c_c));
                } else{
                    q.add(new Node(a,0,b+c));
                }

                // c->a
                if(c + a > c_a){
                    q.add(new Node(c_a, b,(c+a)-c_a));
                } else{
                    q.add(new Node(c+a,b,0));
                }

                // c->b
                if(c + b > c_b){
                    q.add(new Node(a, c_b,(c+b)-c_b));
                } else{
                    q.add(new Node(a, c+b, 0));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] Input = br.readLine().split( " ");
        c_a = Integer.parseInt(Input[0]);
        c_b = Integer.parseInt(Input[1]);
        c_c = Integer.parseInt(Input[2]);

        q.add(new Node(0, 0,c_c));
        bfs();

        Collections.sort(ans);
        for(int i = 0; i<ans.size(); i++)
            System.out.print(ans.get(i)+" ");
    }

}
