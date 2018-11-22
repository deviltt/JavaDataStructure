package sort.test;

import sort.*;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 1000);
        for (int temp : arr)
            System.out.print(temp + " ");

//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(arr, 0, arr.length - 1);
//        HeapSort heapSort = new HeapSort();
//        heapSort.heapSort(arr, arr.length, 0);
//        InsertSort insertSort = new InsertSort();
//        insertSort.insertSort(arr);
//        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
//        binaryInsertSort.binaryInsertSort(arr);
//        ShellSort shellSort = new ShellSort();
//        shellSort.shellSort(arr);
//        BubleSort bubleSort = new BubleSort();
//        bubleSort.bubleSort(arr);

        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(arr);

        System.out.println();
        for (int temp : arr)
            System.out.print(temp + " ");
    }
}
