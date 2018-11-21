package sort;

public class HeapSort {
    //传入的n是数组元素的个数
    public void heapSort(int[] arr, int n, int j){
        for(int i = n / 2 - 1; i >= 0; i--) {
            if(j == 1)
                maxHeapDown(arr, i, n - 1);
            else
                minHeapDown(arr, i, n - 1);
        }

        for(int i = n - 1;i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            if(j == 1)
                maxHeapDown(arr, 0, i - 1);
            else
                minHeapDown(arr, 0, i - 1);
        }
    }

    private void minHeapDown(int[] arr, int start, int end){
        int c = start;
        int temp = arr[c];
        int l = 2 * c + 1;
        for(; l <= end; c = l, l = 2 * l + 1){
            if(l < end && arr[l] > arr[l + 1])  //选取左右子树中的小者，观察期时候要和父亲节点进行交换
                l++;
            if(temp < arr[l])
                break;
            else {
                arr[c] = arr[l];
                arr[l] = temp;
            }
        }
    }

    private void maxHeapDown(int[] arr, int start, int end){
        int c = start;  //c保留当前节点的位置
        int l = 2 * c + 1;  //l为当前节点的左孩子节点的位置
        int temp = arr[c];  //temp保留当前位置的值，以便于下沉操作
        for(; l <= end; c = l, l = 2 * l + 1){  //一定要每次都跟新当前节点的位置，因为当前节点如果在中间，执行了一次下沉操作之后可能还要继续执行下沉操作
            if(l < end && arr[l] < arr[l + 1])  //选取左右子树中的大者，观察期时候要和父亲节点进行交换
                l++;
            if(temp > arr[l])
                break;
            else{
                arr[c] = arr[l];
                arr[l] = temp;
            }
        }
    }
}
