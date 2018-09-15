package luogu;

import java.util.Scanner;

public class P1428 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr = new int[num];
        int[] ans = new int[num];
        int i = 0;
        while(i < arr.length && scan.hasNext())
            arr[i++] = scan.nextInt();
        for(int j = 0; j < arr.length; j++){
            int temp = 0;
            for(int k = 0; k < j; k++){
                if(j == 0)
                    ans[k] = 0;
                if(arr[k] < arr[j])
                    temp++;
            }
            ans[j] = temp;
        }
        for(int j = 0; j < ans.length; j++) {
            if(j == ans.length - 1)
                System.out.print(ans[j]);
            else
                System.out.print(ans[j] + " ");
        }
    }
}
