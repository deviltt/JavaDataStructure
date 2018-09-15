/**
 * 试计算在区间 1 到 n 的所有整数中，数字x(0≤x≤9)共出现了多少次？
 * 例如，在1到11中，即在 1,2,3,4,5,6,7,8,9,10,11 中，数字 1 出现了 4 次。
 */
package luogu;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long x = scan.nextLong();
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int temp = i;
            while(temp != 0) {
                if (temp % 10 == x)
                    ans++;
                temp /= 10;
            }
        }
        System.out.println(ans);
    }
}
