package luogu;

import java.util.Scanner;

public class Solution1427 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[100];
        int i = 0;
        while(scan.hasNext()) {
            arr[i] = scan.nextInt();
            if(arr[i] == 0)
                break;
            i++;
        }
        int left = 0, right = i - 1;
        int mid = (left + right) / 2;
        while(left <= mid){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for(int j = 0; j <= i - 1; j++){
            if(j != i - 1)
                System.out.print(arr[j] + " ");
            else
                System.out.print(arr[j]);
        }

    }
}
