// leetcode 744
// find smallest letter greater than target

public class problem1 {
  public static void main(String[] args) {
    char arr[] = { 'a', 'b', 'd', 'e', 'f' };
    System.out.println(letter(arr, 'c'));
  }

  static char letter(char[] arr, char target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (target < arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return arr[start % arr.length];
  }
}
