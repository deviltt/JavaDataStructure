/**
 * 设有 nn 个正整数 (n≤20)(n≤20) ，将它们联接成一排，组成一个最大的多位整数。
 * 例如： n=3n=3 时， 33 个整数 1313 , 312312 , 343343 联接成的最大整数为： 3433121334331213
 * 又如： n=4n=4 时， 44 个整数 77 , 1313 , 44 , 246246 联接成的最大整数为： 74246137424613
 * 输入样例#1：
 * 3
 * 13 312 343
 */
package luogu;

import java.util.Scanner;

public class P1012 {
    public static void main(String[] args){
        String[] str = new String[3];
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < 3; i++)
            str[i] = input.next();

        for(int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((str[i] + str[j]).compareTo(str[j] + str[i]) < 0){
                    String temp;
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++)
            System.out.print(str[i]);
    }
}
