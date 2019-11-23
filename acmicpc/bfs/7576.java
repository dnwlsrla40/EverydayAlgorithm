// 토마토

/*
*   최소 일수를 구하는 프로그램이므로 bfs일거라 생각하였다. 큰 틀은 이전 문제와 동일하고, 조금 다른게 여기선 1인 경우에 횟수를 증가시켜주기에
*   최종결과에서 -1을 해주었다. 전체를 탐색한 뒤에도 방문한적없고 익지않은 토마토가 있으면 -1을 출력하도록 하였다.
*/

// 제출 결과: [메모리: 171348KB 시간: 896ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java_7576 {
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n,m;
    static Queue<Integer> qx = new LinkedList<Integer>();
    static Queue<Integer> qy = new LinkedList<Integer>();
    static int[][] map;
    static boolean[][] visit;
    static int count = 0;
    static boolean flag = false;

    static void bfs(){
        int x, y;
        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];
                if(0<=dx && 0<=dy && dx<n && dy<m){
                    if(!visit[dx][dy] && map[dx][dy] == 0){
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
        n = Integer.parseInt(Input[1]);
        m = Integer.parseInt(Input[0]);
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(Input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    qx.add(i);
                    qy.add(j);
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = Math.max(count, map[i][j]);
                if(!visit[i][j] && map[i][j] == 0){
                    flag=true;
                }
            }
        }
        
        if(flag)
            System.out.println(-1);
        else{
            System.out.println(count-1);
        }
    }
}
