// 덩치

// 처음 제출 [메모리 : 12908KB 시간 : 76ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int people[][] = new int[N][2];
        for(int i=0; i<N; i++){
            String[] inputArray = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(inputArray[0]);
            people[i][1] = Integer.parseInt(inputArray[1]);
        }

        for(int i=0; i<N; i++){
            int count=1;
            for(int j=0; j<N; j++){
                if(people[j][0]>people[i][0] && people[j][1]>people[i][1])
                    count++;
            }
            System.out.print(count + " ");
        }
    }
}


// 1등 꺼
// [메모리 : 12944KB 시간 : 68ms]
// 내 코드의 count 부분을 배열 3번째(index : 2) 요소로 줌 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(rd.readLine());
		int[][] size = new int[n][3];
		
		for(int i = 0;i < n;i++){
			String[] input = rd.readLine().split(" ");
			size[i][0] = Integer.parseInt(input[0]);
			size[i][1] = Integer.parseInt(input[1]);
			size[i][2] = 1;
		}
		
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				if(i == j){
					continue;
				}				
				if((size[i][0] < size[j][0]) && (size[i][1] < size[j][1])){
					size[i][2]++;
				}
			}
		}
		
		for(int i = 0;i<n;i++){
			sb.append(size[i][2]);
			if(i != n-1){
				sb.append(" ");
			}
		}
		
		System.out.println(sb.toString());		
	}
}