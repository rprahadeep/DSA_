public class orderAgnostic {
  public static void main(String[] args) {

    int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    System.out.println(search(arr, 5));
  }

  static int search(int arr[], int target) {
    int start = 0;
    int end = arr.length - 1;

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
}
