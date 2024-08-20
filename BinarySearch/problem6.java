// leetcode 410
// split array largest sum

public class problem6 {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5 };
    int k = 2;
    System.out.println(splitArray(nums, k));
  }

  public static int splitArray(int[] nums, int k) {
    int start = 0;
    int end = 0;

    for (int i = 0; i < nums.length; i++) {
      start = Math.max(start, nums[i]);
      end += nums[i];
    }

    // binary search

    while (start < end) {
      int mid = (start + end) / 2;
      int sum = 0;
      int pieces = 1;
      for (int i : nums) {
        if (sum + i > mid) {
          sum = i;
          pieces++;
        } else {
          sum = sum + i;
        }
      }
      if (pieces > k) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return end;
  }
}