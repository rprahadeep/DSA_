//leetcode 1095
//find in mountain array

public class problem4 {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
    int target = 3;
    System.out.println(mountainsearch(arr, target));
  }

  public static int mountainsearch(int[] arr, int target) {
    int peak = peak(arr);
    int first = search(arr, target, 0, peak);
    if (first != -1) {
      return first;
    }

    return search(arr, target, peak + 1, arr.length - 1);
  }

  static int search(int arr[], int target, int start, int end) {

    // find whether the array is sorted in ascending or descending
    boolean isAsc = arr[start] < arr[end];

    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] == target) {
        return mid;
      }
      if (isAsc) {
        if (target < arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target > arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return -1;
  }

  public static int peak(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid] < arr[mid + 1]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return start;
  }
}
