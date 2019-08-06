import java.util.Scanner;

// QuickSort
public class Java_2651 {
    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pc = arr[(pl+pr)/2];

        while(pl<=pr){
            while(arr[pl]<pc) pl++;
            while(arr[pr]>pc) pr--;
            if(pl<=pr)
                swap(arr, pl++, pr--);
        }
        if(left<pr) quickSort(arr, left, pr);
        if(right>pl) quickSort(arr, pl, right);
    }

    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        quickSort(arr, 0, n-1);
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }
}

// MergeSort
import java.util.Scanner;

public class Java_2651 {
    static int[] result;
    // 쪼개는 부분
    static void mergeSort(int[] arr, int left, int right) {
        int mid = (left+right)/2;
        if(left<right){
            mergeSort(arr,left, mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    // 합치는 부분
    public static void merge(int[] arr, int left, int mid, int right){
        int part1 = left;   // 앞쪽의 배열의 인덱스
        int part2 = mid+1;  // 뒷족의 배열의 인덱스
        int index = left;   // 결과 저장할 배열의 인덱스

        while(part1<=mid || part2<=right) { // 원소가 없어질 때 까지
            if(part1<=mid && part2<=right) {    // 배열이 둘다 남아 있다면 비교 후 작은 거 결과에 넣기
                if(arr[part1]<=arr[part2]) result[index] = arr[part1++];
                else result[index] = arr[part2++];
            }
            else if(part1<=mid && part2 > right)    // 첫 번째 배열이 남아있으면 결과에 넣기
                result[index] = arr[part1++];
            else result[index] = arr[part2++];  // 두 번째 배열이 남아있으면 결과에 넣기
            index++;
        }
        for(int i=left;i<right+1;i++)   // 결과 저장
            arr[i] = result[i];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        result = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        mergeSort(arr,0,n-1);
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }
}

// HeapSort