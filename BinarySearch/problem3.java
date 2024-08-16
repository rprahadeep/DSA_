// leetcode 852
// peak index in mountain array

public class problem3 {
  public static void main(String[] args) {

    int arr[] = { 0, 1, 2, 5, 10, 2, 0 };
    System.out.println(peak(arr));
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