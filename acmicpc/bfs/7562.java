// 나이트의 이동

/*
*   최소 이동 거리이므로 bfs를 사용하였고, 처음에는 count를 static 변수로 두어 구하였지만, Node의 필드로 두어 이동할때마다 +1증가시켰다.
*   이전까진 x와y에 해당하는 queue를 따로 두어 사용하였지만, 이번에는 Node 클래스를 구현하여 사용해보았다.
*/

// 제출 결과: [메모리: 72264KB 시간: 264ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java_7562 {
    static int n;
    static int[][] map;
    static int[][] check = {{-2,1},{-1,2},{1,2},{2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    static Queue<Node> q = new LinkedList<Node>();
    static boolean[][] visit;
    static int start_x, start_y, end_x, end_y,count;

    static class Node {
      int x;
      int y;
      int count;

      public Node(int x, int y, int count){
          this.x = x;
          this.y = y;
          this.count = count;
      }
    }

    public static void bfs(Node node){
        q.clear();
        visit[node.x][node.y] = true;
        q.add(node);
        count = 0;
        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int count = temp.count;

            if(x==end_x && y==end_y) {
                System.out.println(temp.count);
                break;
            }

            for (int i = 0; i < 8; i++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];

                if(0<=dx && 0<=dy && dx<n && dy<n){
                   if(!visit[dx][dy]){
                       q.add(new Node(dx,dy,count+1));
                       visit[dx][dy] =true;
                   }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        while(Tc-- > 0){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visit = new boolean[n][n];

            String[] Input = br.readLine().split(" ");
            start_x = Integer.parseInt(Input[0]);
            start_y = Integer.parseInt(Input[1]);

            Input = br.readLine().split(" ");
            end_x = Integer.parseInt(Input[0]);
            end_y = Integer.parseInt(Input[1]);

            bfs(new Node(start_x,start_y, 0));
        }
    }
}
