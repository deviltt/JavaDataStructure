package sort.test;

import sort.QuickSort;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 1000);
        for (int temp : arr)
            System.out.print(temp + " ");

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println();
        for (int temp : arr)
            System.out.print(temp + " ");
    }
}
