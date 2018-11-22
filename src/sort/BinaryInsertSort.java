package sort;

/**
 * 思想：无论直接插入排序还是二分插入排序，其都分为左边已经排序好的序列以及右边没有排序好的序列
 * 直接插入排序是一个个进行比较
 * 二分插入排序采用折中的思想，先找到插入的位置
 */
public class BinaryInsertSort {
    public void binaryInsertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int low = 0;
            int high = i - 1;
            //找到元素插入的地方
            while(low <= high){
                int mid = (low + high) / 2;
                if(arr[mid] > temp)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            //将大于temp的元素都后移
            int j;
            for(j = i - 1; j >= low; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = temp;
        }
    }
}
