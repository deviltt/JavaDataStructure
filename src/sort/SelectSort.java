package sort;

public class SelectSort {
    public void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            //先假设当前节点为最小值
            int index = i;
            for(int j = i + 1; j < arr.length; j++)
                if(arr[j] < arr[index])
                    index = j;

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
