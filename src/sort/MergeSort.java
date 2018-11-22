package sort;

public class MergeSort {
    public void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }
    private void sort(int[] arr, int low, int high, int[] temp){
        if(low < high){
            int mid = (low + high) / 2;
            sort(arr, low, mid, temp);
            sort(arr, mid + 1, high, temp);
            merge(arr, low, mid, high, temp);
        }
    }
    private void merge(int[] arr, int low, int mid, int high, int[] temp){
        int i = low;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= high){
            if(arr[i] < arr[j])
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        }
        while(i <= mid)
            temp[t++] = arr[i++];
        while(j <= high)
            temp[t++] = arr[j++];

        t = 0;

        while(low <= high)
            arr[low++] = temp[t++];
    }
}
