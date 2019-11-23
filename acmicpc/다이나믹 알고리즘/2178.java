// 미로 탐색

/*
*   (1,1)에서 (n,m)까지 최단 경로이므로 bfs가 적합하다고 생각하였다.
*   x좌표 y좌표에 대한 각각의 큐를 생성하고 시작이 (1,1) 즉, 배열상의(0,0) 에서 시작하므로
*   bfs(0,0)으로 해준 뒤 (0,0)에서 부터 상하좌우를 탐색하여 방문하지 않았고 값이 1인 경우에 그쪽을 탐색하는 방식으로 값을 차례로 1씩 증가시켜주면서 가면
*   마지막으로 가는 최단경로가 된다고 생각하였다.
*
*   이번 bfs와 dfs 문제를 다루면서 상하좌우를 check하는 방법을 배열을 써서 많이 하는 것을 알게되었다.
*   특히, 2중 배열을 써서 하는 것이 편리해보였다.
*/

// 제출 결과: [메모리: 15144KB 시간: 152ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java_2178 {
    static int[][] map;
    static boolean[][] visit;
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n, m;
    static Queue<Integer> qx = new LinkedList<Integer>();
    static Queue<Integer> qy = new LinkedList<Integer>();

    static void bfs(int x, int y){
        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];

                if(0<=dx && 0<=dy && dx<n && dy<m) {
                    if(!visit[dx][dy] && map[dx][dy] ==1){
                        qx.add(dx);
                        qy.add(dy);
                        visit[dx][dy] = true;
                        map[dx][dy] = map[x][y]+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        n = Integer.parseInt(Input[0]);
        m = Integer.parseInt(Input[1]);
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(Input[j]);
            }
        }
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }
}
