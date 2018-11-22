package sort;

public class RadixSort {
    public void radixSort(int[] arr){
        int exp;
        int max = getMax(arr);

        for(exp = 1; max / exp > 0; exp *= 10)
            count(arr, exp);
    }

    private void count(int[] arr, int exp){
        int[] output = new int[arr.length];
        int[] buckets = new int[10];

        /**
         * 分三步：
         * 1. 统计桶的个数
         * 2. 统计桶的索引在output数组中的位置
         * 3. arr中的元素拷贝到对应output数组中的指定位置
         */
        for(int i = 0; i < arr.length; i++)
            buckets[(arr[i] / exp) % 10]++; //统计对应末尾数字的个数

        for(int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];   //元素对应的位置的值与桶的索引值相同的元素在output中的位置

        //计算arr中每个元素在output中的位置
        for(int i = arr.length - 1; i >= 0; i--){
            output[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
            buckets[(arr[i] / exp) % 10]--;
        }

//        for(int i = 0; i < arr.length; i++)
//            arr[i] = output[i];
        System.arraycopy(output, 0, arr, 0, arr.length);

        output = null;
        buckets = null;
    }

    private int getMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++)
            if(arr[i] > max)
                max = arr[i];
        return max;
    }
}
