// 로또

/*
*   백트래킹이라는 처음보는 개념을 적용해볼 수 있었다. 
*   백트래킹이라고는 하지만 완전 탐색의 응용버전이라고 생각하면 적용하는데 어렵지 않을 것 같다.
*   dfs는 사용하지 않은 것 같은데 왜 dfs에 들어갔는 지 모르겠다 아직 많이 부족한 것 같다.
*   else 구문의 수를 pick하는 것과 pick하지 않는 것의 표현이 중요하다.
*/

// 제출 결과: [메모리: 17828KB 시간: 172ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_6603 {
    static int[] map;
    static int[] ans = new int[6];
    static int k;

    public static void dfs(int start, int count){
        if(start>=map.length && count < 6)
            return;
        if(count == 6){
            for (int i = 0; i < 6; i++)
                System.out.print(ans[i]+" ");
            System.out.println();
        }else {
            ans[count] = map[start];
            dfs(start+1, count+1);
            ans[count] = 0;
            dfs(start+1, count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] Input = br.readLine().split(" ");
            k = Integer.parseInt(Input[0]);
            map = new int[k];

            if(k == 0)
                break;

            for (int i = 0; i < k; i++) {
                map[i] = Integer.parseInt(Input[i+1]);
            }
            dfs(0,0);
            System.out.println();
        }
    }
}
