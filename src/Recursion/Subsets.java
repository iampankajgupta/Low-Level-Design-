package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[]nums = {1,2,3};


    }

    // There is no need to check for duplicates

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, temp, ans);
        return ans;
    }


    // Time complexity -> O(2^N) since for every index there are 2 choices
    // Space Complexity -> O(N) which will be the size of the set
    public void helper(int[]nums, int index,List<Integer> temp, List<List<Integer>> ans) {
        if(index >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        /// take it
        temp.add(nums[index]);
        helper(nums, index+1, temp, ans);
        // remove it from the end because it is passed by reference and not value i.e why need to remove
        if(!temp.isEmpty()) {
            temp.remove(temp.size() -1);
        }
        // not take
        helper(nums, index+1, temp, ans);

    }
}
