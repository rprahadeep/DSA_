//leetcode 33
//search in rotated sorted array

public class problem5 {
  public static void main(String[] args) {
    int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
    int target = 0;
    if (search(arr, target, 0, pivot(arr)) != -1) {
      System.out.println(search(arr, target, 0, pivot(arr)));
    } else {
      System.out.println(search(arr, target, pivot(arr) + 1, arr.length - 1));
    }
  }

  public static int pivot(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;

      if (mid < end && arr[mid + 1] > arr[mid]) {
        return mid;
      }
      if (mid > start && arr[mid] < arr[mid - 1]) {
        return mid - 1;
      }
      if (arr[mid] >= arr[start]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  static int search(int arr[], int target, int start, int end) {

    while (start <= end) {
      int mid = (start + end) / 2;
      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
