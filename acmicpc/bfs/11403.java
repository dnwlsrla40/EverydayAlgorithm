// 경로 찾기

/*
*   dfs인지 bfs인지 잘 모르겠다 처음 부터 모든 경우를 보긴하지만, 하나씩 재귀를 돌려 깊숙히 들어가는 방식으로 풀었다.
*   처음 시작지점을 dfs의 인자로 넘겨주고 그 시작지점부터 갈 수 있는 곳을 모두 체크한 뒤 그 체크한 곳에서 또 갈 수 있는 곳을 체크하는 식으로 풀었다.
*/

// 제출 결과: [메모리: 17212KB 시간: 212ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Boolean.FALSE;

public class Java_11403 {
    static int[][] map;
    static int[][] ans;
    static boolean[] visit;
    static int n;

    static void dfs(int start){
        for (int i = 0; i < n; i++) {
            if(!visit[i] && map[start][i]==1){
                visit[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        ans = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] Input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(Input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i);
            for (int j = 0; j < n; j++) {
                ans[i][j] = (visit[j]) ? 1 : 0;
            }
            Arrays.fill(visit, FALSE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
