import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1780 {
    static int oneCount = 0;
    static int zeroCount = 0;
    static int minusCount = 0;


    public static void Paper(int[][] arr, int x, int y, int n){
        int check = arr[y][x];
        boolean flag = false;
        if(n==1){
            if(check == 1)
                oneCount++;
            else if(check == 0)
                zeroCount++;
            else
                minusCount++;
        } else {
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(check != arr[y+i][x+j]) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                Paper(arr, x, y,n/3);
                Paper(arr, x+(n/3), y,n/3);
                Paper(arr, x+(2*(n/3)),y,n/3);
                Paper(arr, x,y+(n/3),n/3);
                Paper(arr, x+(n/3),y+(n/3),n/3);
                Paper(arr, x+(2*(n/3)),y+(n/3),n/3);
                Paper(arr, x,y+(2*(n/3)),n/3);
                Paper(arr, x+(n/3),y+(2*(n/3)),n/3);
                Paper(arr, x+(2*(n/3)),y+(2*(n/3)),n/3);
            } else{
                if(check == 1)
                    oneCount++;
                else if(check == 0)
                    zeroCount++;
                else
                    minusCount++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[][] square;
        n = Integer.parseInt(br.readLine());
        square = new int[n][n];
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                square[i][j] = Integer.parseInt(input[j]);
            }
        }
        Paper(square,0,0,n);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }
}
