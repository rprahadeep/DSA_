// leetcode 34
// search range in sorted array

public class problem2 {
  public static void main(String[] args) {
    int nums[] = { 4, 5, 5, 6, 6, 6, 6, 7, 8 };
    int target = 6;
    System.out.println(searchRange(nums, target));
  }

  public static int[] searchRange(int[] nums, int target) {
    int[] ans = { -1, -1 };
    int start = search(nums, target, true);
    int end = search(nums, target, false);
    ans[0] = start;
    ans[1] = end;

    return ans;
  }

  public static int search(int[] nums, int target, boolean searchbefore) {
    int ans = -1;

    int start = nums[0];
    int end = nums.length - 1;

    while (start >= end) {
      int mid = (start + end) / 2;
      if (target > nums[mid]) {
        start = mid + 1;
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        ans = mid;
        if (searchbefore) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return ans;

  }
}