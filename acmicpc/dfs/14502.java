// 연구소

/*
*   많이 어려웠던 문제다. 로또에서 사용한 백트레킹을 2차원으로 사용해야 한다는 개념 잡는 것부터 어려웠다.
*   하지만 로또에서 사용법을 감을 잡았기에 개념을 잡고 난 후에는 solve 메서드는 구현하는데 어려움이 없었다.
*   그 뒤에는 전체를 체크하며 바이러스가 있으면 퍼지게 시키는 dfsAll() 메서드를 구현하고, 직접 바이러스를 퍼지게 하는 dfs()를 구현하였다.
*   dfs가 끝난 뒤에는 방문(바이러스가)한 적없고, 맵에서도 안전지역이며, 벽을 새로 설치하지 않은 구역을 찾아 갯수를 출력하였다.
*/

// 제출 결과: [메모리: 29684KB 시간: 292ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_14502 {
    static int n,m;
    static int[][] map;
    static int[][] ans;
    static boolean[][] visit;
    static int[][] check = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int result = 0;

    // 탐색하면서 바이러스 퍼지게 하는 메서드
    public static void dfs(int x, int y){
        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];
            if(0<=dx && 0<=dy && dx<n && dy<m){
                if(ans[dx][dy] != 1 && !visit[dx][dy] && map[dx][dy] == 0){
                    visit[dx][dy] = true;
                    dfs(dx,dy);
                }
            }
        }
    }

    // 바이러스 퍼지게 하는 메서드
    public static int dfsAll(){
        visit = new boolean[n][m];
        int secure_area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    visit[i][j] = true;
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 0 && ans[i][j] == 0){
                    secure_area++;
                }
            }
        }
        return secure_area;
    }

    // 3개의 벽을 세우는 모든 경우의 수 탐색
    public static void solve(int x, int y, int count){
        if(count == 3){
            result = Math.max(result, dfsAll());
            return;
        }

        if(x==n && count<3)
            return;

        if(y==m){
            solve(x+1,0, count);
            return;
        }

        if(map[x][y]==0){
            ans[x][y] = 1;
            solve(x,y+1,count+1);
            ans[x][y] = 0;
        }

        solve(x,y+1,count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        n = Integer.parseInt(Input[0]);
        m = Integer.parseInt(Input[1]);
        map = new int[n][m];
        ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            Input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(Input[j]);
            }
        }

        solve(0,0,0);
        System.out.println(result);
    }
}
