// Generations of Tribbles

// 처음에 피보나치 형식의 재귀를 사용하여 int 형으로 구현 -> 시간 초과
// 고민하던 중 자료 타입 초과를 알고 long 타입으로 고침
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_9507 {
    public static long koong(long n){
        if(n<2)
            return 1;
        else if(n==2)
            return 2;
        else if(n==3)
            return 4;
        else
            return koong(n-1)+koong(n-2) + koong(n-3) + koong(n-4);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            long n = Long.parseLong(br.readLine());
            System.out.println(koong(n));
        }
    }
}

// 고민한 결과로 Dynamic Programming 방식으로 생각
// 배열을 이용하여 0~3 까지의 수를 저장하고 그 외는 전 4개의 요소를 더함
// 제출 결과 [메모리 : 12904KB 시간 : 72ms]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] koong = new long[68];
        koong[0] = 1; koong[1] = 1; koong[2] = 2; koong[3] = 4;
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            if(n<4){
                System.out.println(koong[n]);
            }
            else{
                for(int j=4; j<=n; j++){
                    koong[j] = koong[j-1]+koong[j-2]+koong[j-3]+koong[j-4];
                }
                System.out.println(koong[n]);
            }
        }
    }
}
