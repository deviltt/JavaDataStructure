package sort;

public class InsertSort {
    public void insertSort(int[] arr){
        //是从i = 1开始的
        for(int i = 1; i < arr.length; i++){
            //i为当前位置，0~i - 1都是已经排序好的序列
            if(arr[i] < arr[i - 1]){
                int temp = arr[i];
                int j;
                for(j = i - 1; j >= 0 && arr[j] > temp; j--)
                    arr[j + 1] = arr[j];    //把大的元素往后移
                arr[j + 1] = temp;
            }
        }
    }
}
