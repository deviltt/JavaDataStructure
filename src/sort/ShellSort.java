package sort;

public class ShellSort {
    public void shellSort(int[] arr){
        //确定步长
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]){
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }
    private void swap(int[] arr, int i, int j){
//        arr[i] = arr[i] + arr[j];
//        arr[j] = arr[i] - arr[j];
//        arr[i] = arr[i] - arr[j];
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
