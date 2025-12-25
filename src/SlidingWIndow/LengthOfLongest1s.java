package SlidingWIndow;

public class LengthOfLongest1s {
    public static void main(String[] args) {
        int[]arr = {1,1,1};
        int ans = longestSubarray(arr);
        System.out.println(ans);
    }

    public static int longestSubarray(int[] nums) {
        int size = nums.length;
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int count = 0;
        while(j < size) {
            if(nums[j] == 0) {
                count++;
            }

            if(count < 2) {
                maxLength = Math.max(maxLength, j-i+1-count);
            }else {
                while(i<=j && count >=2) {
                    if(nums[i] == 0) {
                        count--;
                    }
                    i++;
                }
            }
            j++;
        }

        return maxLength;
    }
}
