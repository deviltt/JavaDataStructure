package leetcode;

public class Solution682Arr {
    public int calPoints(String[] ops) {
        Integer[] arr = new Integer[ops.length];
        int sum = 0, i = 0;
        for(String str : ops){
            if(str.equals("C"))
                i--;
            else if(str.equals("D")){
                arr[i] = 2 * arr[i - 1];
                i++;
            }
            else if(str.equals("+")){
                arr[i] = arr[i - 1] + arr[i - 2];
                i++;
            }
            else
                arr[i++] = Integer.parseInt(str);
        }
        for(int j = 0; j < i; j++)
            sum += arr[j];
        return sum;
    }
}
