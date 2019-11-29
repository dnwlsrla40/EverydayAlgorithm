// 유기농 배추

/*
*   전의 문제와 매우 비슷하다. 다만, 입력 값이 m이 먼저오기 때문에 유의하여서 풀어야 한다.
*/

// 제출 결과: [메모리: 16452KB 시간: 124ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1012 {
    static int[][] map;
    static int count;
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n,m;

    static void dfs(int x, int y, int ac){
        map[x][y] = ac;
        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];
            if(0<=dx && 0<=dy && dx<=n && dy<=m){
                if(map[dx][dy] == 1)
                    dfs(dx,dy,ac);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        while(Tc-- > 0){
            count=1;
            String[] Input = br.readLine().split(" ");
            n = Integer.parseInt(Input[1]);
            m = Integer.parseInt(Input[0]);
            int k = Integer.parseInt(Input[2]);
            map = new int[n+1][m+1];
            for (int i = 0; i < k; i++) {
                Input = br.readLine().split(" ");
                map[Integer.parseInt(Input[1])][Integer.parseInt(Input[0])] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] ==1) {
                        dfs(i,j,++count);
                    }
                }
            }

            System.out.println(--count);
        }
    }
}
