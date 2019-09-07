// 곱셈


// 처음 제출[메모리: 12792KB 시간: 72ms]
// 곱셈의 기본 원리를 잊고 어렵게 생각함
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2588 {
    public static void Mul(int num1, int num2){
        int[] result = new int[4];
        for(int i=0; num2!=0; i++){
            if(i!=3){
                result[i] = num1 * (num2%10);
                int temp = result[i];
                for(int j=1; j<=i; j++)
                    temp *= 10;
                result[3] += temp;
                num2 /= 10;
            }
        }
        for(int i=0; i<4; i++)
            System.out.println(result[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        Mul(num1, num2);
    }
}


// 간단한 방법
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		String y = br.readLine();
		
		System.out.println(Integer.parseInt(x)* (y.charAt(2)-48));
		System.out.println(Integer.parseInt(x)* (y.charAt(1)-48));
		System.out.println(Integer.parseInt(x)* (y.charAt(0)-48));
		System.out.println(Integer.parseInt(x)*Integer.parseInt(y));

	}
}