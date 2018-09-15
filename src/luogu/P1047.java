package luogu;

import java.util.Scanner;

public class P1047 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();
        int M = scan.nextInt();
        boolean[] arr = new boolean[L + 1];

        //思路：一共有L个区域，将访问过的区域元素变为true
        for(int i = 0; i < M; i++){
            int pre = scan.nextInt();
            int next = scan.nextInt();
            for(; pre <= next; pre++)
                if(arr[pre] == false)
                    arr[pre] = true;
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == false)
                ans++;
        System.out.println(ans);
    }
}
