package luogu;

import java.util.Scanner;

public class P1046 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] applesHighth = new int[10];
        int i = 0;
        while(i < applesHighth.length && scan.hasNext()) {
            applesHighth[i++] = scan.nextInt();
        }
        int maxHighth = scan.nextInt();
        int ans = 0;
        for(int j : applesHighth)
            if(maxHighth + 30 > j)
                ans++;
        System.out.println(ans);
    }
}
