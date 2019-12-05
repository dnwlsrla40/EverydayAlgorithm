// 영역 구하기

// 제출 결과: [메모리: 13404KB 시간: 88ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Java_2583 {
    static int[][] map;
    static int n,m,k;
    static int count = 1;
    static int[][] check = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[] area = new int[100*100/2+1];

    public static void dfs(int x, int y, int count){
        map[x][y] = count;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int dx = x + check[i][0];
                int dy = y + check[i][1];
                if(0<=dx && 0<=dy && dx<m && dy<n){
                    if(map[dx][dy] == 0)
                        dfs(dx,dy,count);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        m = Integer.parseInt(Input[0]);
        n = Integer.parseInt(Input[1]);
        k = Integer.parseInt(Input[2]);
        map = new int[m+1][n+1];
        for (int i = 0; i < k; i++) {
            Input = br.readLine().split(" ");
            int x1 = Integer.parseInt(Input[0]);
            int y1 = Integer.parseInt(Input[1]);
            int x2 = Integer.parseInt(Input[2]);
            int y2 = Integer.parseInt(Input[3]);
            for (int j = y1; j < y2 ; j++) {
                for (int l = x1; l < x2 ; l++) {
                    map[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0){
                    dfs(i,j,++count);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] > 1)
                    area[map[i][j]]++;
            }
        }

        Arrays.sort(area);

        System.out.println(count - 1);

        for (int i = 0; i < (100*100/2)+1; i++) {
            if(area[i] != 0)
                System.out.print(area[i]+" ");
        }
    }
}
