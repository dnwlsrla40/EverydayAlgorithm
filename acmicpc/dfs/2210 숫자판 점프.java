// 2210번 숫자판 점프(silver 2)

/*
문제 출처 : https://www.acmicpc.net/problem/2210

문제
5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.

숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.

입력
다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.

출력
첫째 줄에 만들 수 있는 수들의 개수를 출력한다.

예제 입력 1 
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
예제 출력 1 
15
힌트
111111, 111112, 111121, 111211, 111212, 112111, 112121, 121111, 121112, 121211, 121212, 211111, 211121, 212111, 212121 이 가능한 경우들이다.
*/

/*
 * 생각 노트
 * 모든 경우의 수를 돌려보는데 중복이 가능해야 하므로 visit를 체크하지 않고 length() > 6 이상일 때 return 시키는 방식으로 처리했다. 조금 더 좋은 방법이 있을 것 같다.
*/

// 제출 결과 [메모리: 28020KB 시간: 1320ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2210 {
    static String[][] map = new String[5][5];
    static int[][] check = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static List<String> maked = new ArrayList<>();

    public static void dfs(String digit, int x , int y){
        if(digit.length() > 6)
            return;

        if(digit.length() == 6){
            if(!maked.contains(digit)){
                maked.add(digit);
                return;
            }
        }

        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];

            if (0 <= dx && dx < 5 && 0 <= dy && dy < 5) {
                dfs(digit+map[x][y], dx, dy);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = input[j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String digit = "";
                dfs(digit,i, j);
            }
        }

        System.out.println(maked.size());
    }
}
