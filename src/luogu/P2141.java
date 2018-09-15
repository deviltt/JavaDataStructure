/**
 * 计算数组中有多少个数，是数组中其它两个数的和
 */
package luogu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P2141 {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        Set<Integer> ret = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while(i < arr.length && scan.hasNext())
            arr[i++] = scan.nextInt();
        for(int j : arr)
            set.add(j);
        int ans = 0;
        //错因：我这个算的是有多少不同的对，加起来等于数组中另外一个数
//        for(int j = 0; j < arr.length - 1; j++){
//            for(int k = j + 1; k < arr.length; k++)
//                if(arr[j] != arr[k] && set.contains(arr[j] + arr[k]))
//                    ans++;
//        }
        for(int j = 0; j < arr.length; j++){
            for(int k = j + 1; k < arr.length; k++)
                if(set.contains(arr[j] + arr[k]))
                    ret.add(arr[j] + arr[k]);
        }
        System.out.println(ret.size());
    }
}
