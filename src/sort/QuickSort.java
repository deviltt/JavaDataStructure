package sort;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            /**
             * 这两步很关键，因为low和high本身会变化，因此要先保存当前值，
             * 以便在后面递归的时候调用
             */
            int initLow = low;
            int initHigh = high;
            int pivot = arr[low];
            while(low < high){
                while(low < high && arr[high] >= pivot)
                    high--;
                arr[low] = arr[high];
                while(low < high && arr[low] <= pivot)
                    low++;
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            int pivoipos = low;
            quickSort(arr, initLow, pivoipos - 1);
            quickSort(arr, pivoipos + 1, initHigh);
        }
    }
}
