import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Java_2805 {
    public static int binSearch(int[] treeArray, int left, int right, int target) {
        while(left<=right){
            int mid = (left+right)/2;
            int cutTree;
            long sumCutTree = 0;
            for(int i=0; i<treeArray.length; i++){
                cutTree = treeArray[i]-mid;
                if(cutTree<0)
                    cutTree =0;
                sumCutTree += cutTree;
            }
            if(sumCutTree >= target)
                left = mid+1;
            else if(sumCutTree < target)
                right = mid-1;
        }
        return right;
   }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] InputArray = bf.readLine().split(" ");
        int treeCount = Integer.parseInt(InputArray[0]);
        int treeLength = Integer.parseInt(InputArray[1]);
        String[] treeInputArray = bf.readLine().split(" ");
        int[] treeArray = new int[treeCount];
        for(int i=0; i<treeInputArray.length; i++){
            treeArray[i] = Integer.parseInt(treeInputArray[i]);
        }
        Arrays.sort(treeArray);
        int left = 0;
        int right = treeArray[treeCount-1];
        right = binSearch(treeArray, left, right, treeLength);
        System.out.println(right);
    }
}
