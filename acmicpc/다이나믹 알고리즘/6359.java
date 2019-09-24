// 만취한 상범

// 처음 제출[메모리 : 13548KB 시간 : 96ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_6359 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int count=0;
            int n = Integer.parseInt(br.readLine());
            boolean[] prison = new boolean[n];
            for(int round=1; round<=n; round++){
                for(int door=0; door<n; door++){
                    if((door+1)%round==0)
                        prison[door] = !prison[door];
                }
            }
            for(int j=0; j<n; j++){
                if(prison[j])
                    count++;
            }
            System.out.println(count);
        }
    }
}

// 다른 사람의 코드
// 라운드가 지나면 그전 라운드 까지의 방은 바뀌지 않고 라운드의 배수들의 문을 검사한다는 것을 이용
// if((door+1)%round==0)부분을 하지 않고, 증감 값을 j+=i로 주어 배수를 표현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tt = Integer.parseInt(br.readLine());
		
		while(tt-->0) {
			int n = Integer.parseInt(br.readLine());
			boolean[] isEscaped = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n ; j += i) {
					isEscaped[j] = !isEscaped[j];
				}
			}
			
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if(isEscaped[i]) count++;
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
	}
}