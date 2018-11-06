package sort;

import java.util.Arrays;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/1
 * Time:21:39
 * 快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 7, 8, 32, 4, 2, 1};
        quicksort(arr, 0, arr.length-1);
    }

    private static void quicksort(int[] arr, int low, int high) {
        if (arr.length <= 1 || low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int tmp = arr[low];
        while (left < right) {
            while (left < right && arr[right] > tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        quicksort(arr,low,left-1);
        quicksort(arr,right+1,high);
        System.out.println(Arrays.toString(arr));
    }
}
