import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());
		int sum = factorial(Input);
		System.out.println(sum);
	}
    
    public static int factorial(int n){
		if(n==1)
			return 1;
		else
			return n * factorial(n-1);
	}
}
